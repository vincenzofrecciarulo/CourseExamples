package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class EmailNotification implements Notification{

    @Override
    public String sendNotification(String message, String recipient) {
        return "You received the following email: "+ message;
    }
}
