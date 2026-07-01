package org.generation.italy.examples.jdbc;

import java.sql.Connection;
import java.util.List;

public class DataMigracion {

     private JDBCCitizenRepository jdbcR;
     private FileCitizenRepository fcR;

    public DataMigracion(JDBCCitizenRepository jdbcR, FileCitizenRepository fcR) {
        this.jdbcR = jdbcR;
        this.fcR = fcR;
    }

    public JDBCCitizenRepository getJdbcR() {
        return jdbcR;
    }

    public FileCitizenRepository getFcR() {
        return fcR;
    }


}
