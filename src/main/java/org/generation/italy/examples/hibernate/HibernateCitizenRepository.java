package org.generation.italy.examples.hibernate;

import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.tropico.Citizen;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class HibernateCitizenRepository implements CitizenRepository {

    private final SessionFactory sessionFactory;

    public HibernateCitizenRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session current() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        try {
            Query<Citizen> q = current().createQuery("from Citizen", Citizen.class);
            return q.list();
        } catch (Exception ex) {
            throw new DataException("Error finding all citizens", ex);
        }
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        try {
            Query<Citizen> q = current().createQuery("from Citizen c where c.gender = :sex and c.educationLevel = :edu", Citizen.class);
            q.setParameter("sex", sex);
            q.setParameter("edu", educationLevel);
            return q.list();
        } catch (Exception ex) {
            throw new DataException("Error finding by sex and education level", ex);
        }
    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try {
            if (citizen.getId() == null || current().get(Citizen.class, citizen.getId()) == null) {
                return false;
            }
            current().merge(citizen);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error updating citizen", ex);
        }
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try {
            Citizen c = current().get(Citizen.class, citizenId);
            if (c == null) return false;
            current().remove(c);
            return true;
        } catch (Exception ex) {
            throw new DataException("Error deleting citizen", ex);
        }
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        try {
            if (newCitizen.getId() == null) {
                current().persist(newCitizen);
            } else {
                insertWithExplicitId(newCitizen);
            }
            return newCitizen;
        } catch (Exception ex) {
            throw new DataException("Error creating citizen", ex);
        }
    }

    private void insertWithExplicitId(Citizen citizen) {
        current().doWork(connection -> {
            String sql = """
                    INSERT INTO citizen
                        (id, first_name, last_name, gender, age, education_level, salary,
                         wealth_level, is_rebel, happiness_total, supported_faction_id)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, citizen.getId());
                ps.setString(2, citizen.getFirstName());
                ps.setString(3, citizen.getLastName());
                ps.setString(4, String.valueOf(citizen.getGender()));
                ps.setInt(5, citizen.getAge());
                ps.setString(6, citizen.getEducationLevel());
                ps.setBigDecimal(7, citizen.getSalary());
                ps.setString(8, citizen.getWealthLevel());
                setNullableBoolean(ps, 9, citizen.isRebel());
                setNullableInteger(ps, 10, citizen.getHappinessTotal());
                Integer factionId = citizen.getSupportedFaction() == null
                        ? null
                        : citizen.getSupportedFaction().getId();
                setNullableInteger(ps, 11, factionId);
                ps.executeUpdate();
            }
        });
    }

    private void setNullableBoolean(PreparedStatement ps, int index, Boolean value)
            throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.BOOLEAN);
        } else {
            ps.setBoolean(index, value);
        }
    }

    private void setNullableInteger(PreparedStatement ps, int index, Integer value)
            throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.INTEGER);
        } else {
            ps.setInt(index, value);
        }
    }
}
