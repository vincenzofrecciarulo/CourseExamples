package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class WhatsAppNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        IO.println("WhatsApp to " + recipient + ": " + message);
    }
}