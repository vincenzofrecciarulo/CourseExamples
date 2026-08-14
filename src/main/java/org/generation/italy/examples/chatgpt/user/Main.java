package org.generation.italy.examples.chatgpt.user;

public class Main {

    public static void main(String[] args) {

        User u1 = new User("Matteo");
        User u2 = new User("Luca");
        User u3 = new User("Anna");

        System.out.println(User.getTotalUsers());
    }
}
