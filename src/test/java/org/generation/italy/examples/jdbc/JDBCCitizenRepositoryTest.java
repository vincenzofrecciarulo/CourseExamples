package org.generation.italy.examples.jdbc;

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

    @BeforeEach
    void setUp() {
        try {
            con = ConnectionFactory.createConnection();
            helper = new DbTestHelper(con);
            repo = new JDBCCitizenRepository(con);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
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
}