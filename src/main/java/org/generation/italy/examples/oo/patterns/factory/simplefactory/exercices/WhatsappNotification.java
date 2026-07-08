package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class WhatsappNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("Sending WhatsApp message to " + recipient + " with message: " + message);
    }
}
