package org.generation.italy.examples.io;


import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvCitizenStorage implements CitizenStorage {

    private static final String HEADER =
            "id;firstName;lastName;gender;age;educationLevel;" +
                    "salary;wealthLevel;isRebel;happinessTotal";

    private final Path file;

    public CsvCitizenStorage(Path file) {

        this.file = file;

        initialize();
    }

    @Override
    public List<String> loadLines() {

        try {
            return Files.readAllLines(file);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void saveLines(List<String> lines) {

        try {
            Files.write(file, lines);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void initialize() {

        try {

            if (Files.exists(file)) {
                return;
            }

            Path parent = file.getParent();

            if (parent != null) {
                Files.createDirectories(parent);
            }

            Files.write(file, List.of(HEADER));

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
