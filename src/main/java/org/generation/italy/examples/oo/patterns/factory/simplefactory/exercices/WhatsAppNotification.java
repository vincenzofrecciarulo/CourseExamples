package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class WhatsAppNotification implements Notification{

    @Override
    public void send(String message) {
        System.out.println("What's app "+message);
    }
}
