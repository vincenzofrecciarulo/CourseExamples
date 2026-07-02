package org.generation.italy.examples.jdbc;

import java.sql.*;

public class DbTestHelper {
    private Connection con;

    private static final String COUNT_CITIZEN =
            """
                    SELECT COUNT(*) AS num_citizens
                    FROM citizen
                    """;
    private static final String COUNT_BY_SEX_AND_EDUCATION = """
            SELECT COUNT(*) AS count_educated
            FROM citizen
            WHERE gender = ? AND education_level = ?
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

    public int countBySexAndEducation(char sex,String education) throws SQLException{
        try (PreparedStatement ps = con.prepareStatement(COUNT_BY_SEX_AND_EDUCATION)){
            ps.setString(1,String.valueOf(sex));
            ps.setString(2,education);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }


}
