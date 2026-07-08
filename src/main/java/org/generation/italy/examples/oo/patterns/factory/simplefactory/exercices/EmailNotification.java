package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class EmailNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        IO.println("Email to " + recipient + ": " + message);
    }
}