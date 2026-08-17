package org.generation.italy.examples.chatgpt.exceptions.exercise6;

public class UserService {
    private UserRepository repository;

    // Questo è il costruttore di UserService
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // Quindi il Service dice: "Repository, cercami l'utente con questo ID."
    public String getUser(int id) {
        return repository.findUserById(id);
    }
}
