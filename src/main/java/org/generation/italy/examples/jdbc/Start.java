package org.generation.italy.examples.jdbc;


public class Start {
    public static void main(String[] args) throws DataException {
        FileCitizenRepository fileCitizenRepository = new FileCitizenRepository();
        fileCitizenRepository.findAll();
    }
}
