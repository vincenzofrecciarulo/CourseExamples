package org.generation.italy.examples.jdbcfrommaster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTestHelper {
    private Connection con;

    private static final String COUNT_CITIZEN =
            """
                    SELECT COUNT(*) AS num_citizens
                    FROM citizen
                    """;

    public DbTestHelper(Connection con) {
        this.con = con;
    }

    public int countCitizens() throws SQLException {
        try(Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(COUNT_CITIZEN)){
            rs.next();
            return rs.getInt(1);
        }
    }
}
