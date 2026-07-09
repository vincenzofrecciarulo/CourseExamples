package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class SMSnotification implements Notification{
    @Override
    public String sendNotification(String message, String recipient) {
        return "You received the following SMS: "+ message;
    }
}
