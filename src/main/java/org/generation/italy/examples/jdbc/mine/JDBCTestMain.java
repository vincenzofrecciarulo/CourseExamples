package org.generation.italy.examples.jdbc.mine;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCTestMain {
    void main() throws SQLException, DataException {
        Connection conn = ConnectionFactory.getConnection();
        JDBCCitizenRepository citizenRepository = new JDBCCitizenRepository(conn);

//        List<Citizen> citizens = citizenRepository.findAll();
//        for (Citizen citizen : citizens) {
//            System.out.println(citizen);
//        }

//        List<Citizen> citizens = citizenRepository.findBySexAndEducationLevel('M', "Illiterate");
//        for (Citizen citizen : citizens) {
//            System.out.println(citizen);
//        }

        Citizen newCitizen = new Citizen("John", "Doe", 'M', 30, "HighSchool", 50000.0, "Broke", false, 80);
        Citizen createdCitizen = citizenRepository.createCitizen(newCitizen);
        System.out.println("Created citizen: " + createdCitizen);

        createdCitizen.setFirstName("Jane");
        createdCitizen.setLastName("Smith");
        createdCitizen.setGender('F');
        createdCitizen.setAge(28);
        boolean updated = citizenRepository.updateCitizen(createdCitizen);
        System.out.println("Updated citizen: " + updated + "\n" + citizenRepository.findById(createdCitizen.getId()).orElse(null));

        boolean deleted = citizenRepository.deleteCitizen(createdCitizen.getId());
        System.out.println("Deleted citizen: " + deleted + "\n" + citizenRepository.findById(createdCitizen.getId()).orElse(null));
    }
}
