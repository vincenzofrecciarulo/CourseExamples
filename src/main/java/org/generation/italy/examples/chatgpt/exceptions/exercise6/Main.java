package org.generation.italy.examples.chatgpt.exceptions.exercise6;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        UserService service = new UserService(repository);
        UserController controller = new UserController(service);
        controller.getUser(1);   // utente esistente
        controller.getUser(50);  // utente inesistent
    }
}
