package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class EmailNotification implements Notification {

    @Override
    public String send(String message, String sender) {
        return "Email: " + message + " from " + sender;
    }
}
