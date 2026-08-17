package org.generation.italy.examples.chatgpt.exceptions.exercise6;

// Il repository cerca un utente
public class UserRepository {
    public String findUserById(int id) {
        if (id != 1) {
            throw new UserNotFoundException(
                    "Utente con ID " + id + " non trovato."
            );
        }

        return "Matteo"; // quindi Matteo avrà id = 1
    }
}
