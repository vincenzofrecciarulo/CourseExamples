package org.generation.italy.examples.jdbc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvFileHandler {

    private static final String url = "src/main/resources/createFile.csv";
    public static boolean isFileCreated() {
        try {
            File myObj = new File(url);
            if (myObj.createNewFile()) {
                return true;
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public static void writeCitizensToCsv(List<Citizen> citizens) throws DataException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(url))) {
            bw.write("id;first_name;last_name;gender;age;education_level;salary;wealth_level;is_rebel;happiness_total");
            bw.newLine();
            for (Citizen c : citizens) {
                StringBuilder sb = new StringBuilder();
                bw.write(sb.append(c.getId()).append(";").append(c.getFirstName()).append(";").append(c.getLastName()).append(";").append(c.getGender()).append(";").append(c.getAge()).append(";").append(c.getEducationLevel()).append(";").append(c.getSalary()).append(";").append(c.getWealthLevel()).append(";").append(c.isRebel()).append(";").append(c.getHappinessTotal()).toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    public static List<Citizen> readFile() throws DataException {
        File myObj = new File(url);
        List<Citizen> c = new ArrayList<>();
        try (Scanner scanner = new Scanner(myObj)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] citizen = scanner.nextLine().split(";");
                int id = Integer.parseInt(citizen[0]);
                char gender = citizen[3].charAt(0);
                int age = Integer.parseInt(citizen[4]);
                double salary = Double.parseDouble(citizen[6]);
                boolean isRebel = Boolean.parseBoolean(citizen[8]);
                int happinessTotal = Integer.parseInt(citizen[9]);
                String firstName = citizen[1];
                String lastName = citizen[2];
                String educationLevel = citizen[5];
                String wealthLevel = citizen[7];
                Citizen citizen1 = new Citizen(id, firstName, lastName, gender, age, educationLevel, salary, wealthLevel, isRebel, happinessTotal);
                c.add(citizen1);
            }
        } catch (FileNotFoundException e) {
            throw new DataException(e.getMessage(), e);
        }
        return c;
    }

    public static void appendCitizenToCsv(Citizen c) throws DataException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(url, true))) {
            StringBuilder sb = new StringBuilder();
            bufferedWriter.write(sb.append(c.getId()).append(";").append(c.getFirstName()).append(";").append(c.getLastName()).append(";").append(c.getGender()).append(";").append(c.getAge()).append(";").append(c.getEducationLevel()).append(";").append(c.getSalary()).append(";").append(c.getWealthLevel()).append(";").append(c.isRebel()).append(";").append(c.getHappinessTotal()).toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

}
