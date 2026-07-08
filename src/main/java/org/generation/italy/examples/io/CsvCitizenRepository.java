package org.generation.italy.examples.io;

import org.generation.italy.examples.model.tropico.Citizen;
import org.generation.italy.examples.jdbc.CitizenRepository;
import org.generation.italy.examples.jdbc.DataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvCitizenRepository implements CitizenRepository {

    private static final String HEADER =
            "id,firstName,lastName,gender,age,educationLevel," +
                    "salary,wealthLevel,isRebel,happinessTotal";

    private static final String SEPARATOR = ",";

    private final Path csvFile;

    public CsvCitizenRepository(Path csvFile) throws DataException {
        this.csvFile = csvFile;
        initializeFile();
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        return readCitizens();
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex,
                                                    String educationLevel)
            throws DataException {

        return readCitizens()
                .stream()
                .filter(c -> c.getGender() == sex)
                .filter(c -> c.getEducationLevel()
                        .equalsIgnoreCase(educationLevel))
                .toList();
    }

    @Override
    public Citizen findById(int citizenId) throws DataException {
        return null;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen)
            throws DataException {

        List<Citizen> citizens = new java.util.ArrayList<>(readCitizens());
        int nextId = nextId(citizens);
        newCitizen.setId(nextId);
        citizens.add(newCitizen);
        writeCitizens(citizens);
        return newCitizen;
    }

    @Override
    public boolean updateCitizen(Citizen citizen)
            throws DataException {

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
    public boolean deleteCitizen(int citizenId)
            throws DataException {

        List<Citizen> citizens = new java.util.ArrayList<>(readCitizens());

        boolean removed =
                citizens.removeIf(c -> c.getId() == citizenId);

        if (removed) {
            writeCitizens(citizens);
        }

        return removed;
    }

    // ==================================================
    // PRIVATE HELPERS
    // ==================================================

    private void initializeFile() throws DataException {

        try {
            if (Files.exists(csvFile)) {
                return;
            }
            Path parent = csvFile.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            Files.write(csvFile, List.of(HEADER));
        } catch (IOException e) {
            throw new DataException(
                    "Unable to initialize CSV repository",
                    e);
        }
    }

    private List<Citizen> readCitizens() throws DataException {

        try {

            return Files.lines(csvFile)
                    .skip(1) // skip header
                    .filter(line -> !line.isBlank())
                    .map(this::parseCitizen)
                    .toList();


        } catch (IOException e) {
            throw new DataException(
                    "Error reading CSV file",
                    e);
        }
    }

    private void writeCitizens(List<Citizen> citizens)
            throws DataException {
        try {
            List<String> lines =
                    citizens.stream()
                            .map(this::toCsvLine)
                            .toList();
            List<String> output =
                    java.util.stream.Stream.concat(
                                    java.util.stream.Stream.of(HEADER),
                                    lines.stream())
                            .toList();
            Files.write(csvFile, output);
        } catch (IOException e) {
            throw new DataException(
                    "Error writing CSV file",
                    e);
        }
    }

    private int nextId(List<Citizen> citizens) {

        return citizens.stream()
                .mapToInt(Citizen::getId)
                .max()
                .orElse(0) + 1;
    }

    private Citizen parseCitizen(String line) {
        String[] fields = line.split(SEPARATOR);
        return CsvCitizenParser.getCitizenFromTokens(fields);
    }

    private String toCsvLine(Citizen citizen) {

        return String.join(
                SEPARATOR,
                String.valueOf(citizen.getId()),
                citizen.getFirstName(),
                citizen.getLastName(),
                String.valueOf(citizen.getGender()),
                String.valueOf(citizen.getAge()),
                citizen.getEducationLevel(),
                String.valueOf(citizen.getSalary()),
                citizen.getWealthLevel() == null
                        ? ""
                        : citizen.getWealthLevel(),
                String.valueOf(citizen.isRebel()),
                String.valueOf(citizen.getHappinessTotal())
        );
    }
}