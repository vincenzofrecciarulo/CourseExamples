package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class EmailNotification implements Notification{
    @Override
    public void send(String messageRecipient) {
        System.out.println(messageRecipient);
    }
}
