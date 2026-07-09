package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class EmailNotification implements Notification{
    @Override
    public String send() {
        return "Questa è una notifica da Email";
    }
}
