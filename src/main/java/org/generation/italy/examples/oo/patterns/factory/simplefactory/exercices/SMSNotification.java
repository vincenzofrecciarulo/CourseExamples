package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class SMSNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        IO.println("SMS to " + recipient + ": " + message);
    }
}