package org.generation.italy.examples.chatgpt.exceptions.exercise6;

public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public void getUser(int id) {
        try {
            String user = service.getUser(id);
            System.out.println("Utente trovato: " + user);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}