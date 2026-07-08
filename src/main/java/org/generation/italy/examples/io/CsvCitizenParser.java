package org.generation.italy.examples.io;

import org.generation.italy.examples.model.tropico.Citizen;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.math.BigDecimal;

/**
 * Helper for parsing CSV tokens into Citizen instances.
 */
public final class CsvCitizenParser {

    private CsvCitizenParser() {}

    public static Citizen getCitizenFromTokens(String[] f) {
        try {
            int id = Integer.parseInt(f[0]);
            String firstName = f[1];
            String lastName = f[2];
            char gender = f[3].charAt(0);
            int age = Integer.parseInt(f[4]);
            String educationLevel = f[5];
            BigDecimal salary = new BigDecimal(f[6]);
            String wealthLevel = (f.length > 7 && !f[7].isBlank()) ? f[7] : null;
            Boolean isRebel = f[8] != null? Boolean.parseBoolean(f[8]): null;
            Integer happinessTotal = f[9] != null? Integer.parseInt(f[9]) : null;

            return new Citizen(id, firstName, lastName, gender, age,
                    educationLevel, salary, wealthLevel, isRebel, happinessTotal);
        } catch (Exception e) {
            throw new UncheckedIOException(new IOException("Malformed CSV tokens: " + String.join(",", f), e));
        }
    }
}
