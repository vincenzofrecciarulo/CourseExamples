package org.generation.italy.examples.io;

import org.generation.italy.examples.jdbc.DataException;

import java.util.List;

public interface CitizenStorage {
    List<String> loadLines() throws DataException;
    void saveLines(List<String> lines) throws DataException;
}