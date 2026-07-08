package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class SMSNotification implements Notification{
    @Override
    public void send(String message, String recipient) {
        System.out.println("Invio SMS a " + recipient);
    }
}
