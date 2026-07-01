package org.generation.italy.examples.jdbc;


import java.sql.Connection;
import java.sql.SQLException;

public class Start {
    public static void main(String[] args) throws DataException {
        try (Connection con = ConnectionFactory.getConnection()) {
            JDBCCitizenRepository jdbcCitizenRepository = new JDBCCitizenRepository(con);
            CsvFileHandler.writeCitizensToCsv(jdbcCitizenRepository.findAll(), false);
            FileCitizenRepository fileCitizenRepository = new FileCitizenRepository();
            System.out.println(fileCitizenRepository.findAll());
           /* System.out.println(fileCitizenRepository.createCitizen(new Citizen(
                    0,
                    "Luigi",
                    "Verdi",
                    'M',
                    29,
                    "College",
                    1200.50,
                    "Poor",
                    false,
                    60
            )));
            System.out.println(fileCitizenRepository.createCitizen(new Citizen(
                    0,
                    "Sara",
                    "Bianchi",
                    'F',
                    34,
                    "HighSchool",
                    950.75,
                    "Broke",
                    true,
                    42
            )));*/
       /*     System.out.println(fileCitizenRepository.updateCitizen(new Citizen(
                    96,
                    "Sara",
                    "Bianchini",
                    'F',
                    34,
                    "HighSchool",
                    950.75,
                    "Broke",
                    true,
                    42
            )));*/

            //System.out.println(fileCitizenRepository.deleteCitizen(96));

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }

    }
}
