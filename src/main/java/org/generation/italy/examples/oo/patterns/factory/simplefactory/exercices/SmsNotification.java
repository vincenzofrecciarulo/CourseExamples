package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class SmsNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("Sending SMS to " + recipient + " with message: " + message);
    }
}
