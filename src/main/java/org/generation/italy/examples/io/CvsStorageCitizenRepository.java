package org.generation.italy.examples.io;

import org.generation.italy.examples.model.tropico.Citizen;
import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;

import java.util.List;

public class CvsStorageCitizenRepository implements CitizenRepository {

    private static final String HEADER =
            "id;firstName;lastName;gender;age;educationLevel;" +
                    "salary;wealthLevel;isRebel;happinessTotal";

    private final CitizenStorage storage;

    public CvsStorageCitizenRepository(CitizenStorage storage) {
        this.storage = storage;
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        return readCitizens();
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel)
            throws DataException {

        return readCitizens()
                .stream()
                .filter(c -> c.getGender() == sex)
                .filter(c -> c.getEducationLevel().equalsIgnoreCase(educationLevel))
                .toList();
    }

    @Override
    public Citizen findById(int id) throws DataException {
        return null;
    }


    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {

        List<Citizen> citizens = new java.util.ArrayList<>(readCitizens());

        newCitizen.setId(nextId(citizens));
        citizens.add(newCitizen);

        writeCitizens(citizens);

        return newCitizen;
    }


    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {

        List<Citizen> citizens = new java.util.ArrayList<>(readCitizens());

        boolean updated = false;

        for (int i = 0; i < citizens.size(); i++) {
            if (citizens.get(i).getId() == citizen.getId()) {
                citizens.set(i, citizen);
                updated = true;
                break;
            }
        }

        if (updated) {
            writeCitizens(citizens);
        }

        return updated;
    }

    @Override
    public boolean updateHappinessTotal(int citizenId, int happinessTotal) throws DataException {
        return false;
    }

    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {

        List<Citizen> citizens = new java.util.ArrayList<>(readCitizens());

        boolean removed = citizens.removeIf(c -> c.getId() == citizenId);

        if (removed) {
            writeCitizens(citizens);
        }

        return removed;
    }

    private List<Citizen> readCitizens() throws DataException {

        try {
            return storage.loadLines()
                    .stream()
                    .skip(1) // header
                    .filter(l -> !l.isBlank())
                    .map(this::parse)
                    .toList();

        } catch (Exception e) {
            throw new DataException("Error reading CSV", e);
        }
    }

    private void writeCitizens(List<Citizen> citizens) throws DataException {

        try {
            List<String> lines = citizens.stream()
                    .map(this::toCsv)
                    .toList();

            storage.saveLines(
                    java.util.stream.Stream.concat(
                            java.util.stream.Stream.of(HEADER),
                            lines.stream()
                    ).toList()
            );

        } catch (Exception e) {
            throw new DataException("Error writing CSV", e);
        }
    }


    private Citizen parse(String line) {
        String[] f = line.split(";", -1);
        return CsvCitizenParser.getCitizenFromTokens(f);
    }

    private String toCsv(Citizen c) {
        return String.join(";",
                String.valueOf(c.getId()),
                c.getFirstName(),
                c.getLastName(),
                String.valueOf(c.getGender()),
                String.valueOf(c.getAge()),
                c.getEducationLevel(),
                String.valueOf(c.getSalary()),
                c.getWealthLevel(),
                String.valueOf(c.isRebel()),
                String.valueOf(c.getHappinessTotal())
        );
    }

    private int nextId(List<Citizen> citizens) {
        return citizens.stream()
                .mapToInt(Citizen::getId)
                .max()
                .orElse(0) + 1;
    }
}