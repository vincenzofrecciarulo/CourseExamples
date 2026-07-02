package org.generation.italy.examples.jdbc;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCCitizenRepositoryTest {
    private Connection con;
    private DbTestHelper helper;
    private JDBCCitizenRepository repo;
    private Citizen created;
    @BeforeEach
    void setUp() {
        try {
            con = ConnectionFactory.getConnection();
            helper = new DbTestHelper(con);
            repo = new JDBCCitizenRepository(con);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
        created = new Citizen(10000,"Giovanni","Rana",'M',89,10000,"College");
    }

    @AfterEach
    void tearDown() {
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                fail(e.getMessage());
            }
        }
    }

    @Test
    void findAll() {
        try {
            int expected = helper.countCitizens();
            List<Citizen> citizens =  repo.findAll();
            assertEquals(expected, citizens.size());
        } catch (SQLException | DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findBySexAndEducation(){
        try {
            List<Citizen> groupBySecAndeducation = repo.findBySexAndEducationLevel('M',"College");
            int expeted = helper.countBySexAndEducation('M',"College");
            assertEquals(expeted,groupBySecAndeducation.size());
        }catch (SQLException | DataException e){
            fail(e.getMessage());
        }
    }
    @Test
    void createCitizen(){
         try {
          List<Citizen> all = repo.findAll();
             int expeted = helper.countCitizens() + 1;
             repo.createCitizen(created);
             assertEquals(expeted,all.size());
         }catch (SQLException | DataException e){
             fail(e.getMessage());
         }
    }
    @Test
    void deleteCitizen()  {
        try {
            List<Citizen> all = repo.findAll();
            int expeted = helper.countCitizens() -1;

        }catch (SQLException | DataException e){
            fail(e.getMessage());
        }
    }
}