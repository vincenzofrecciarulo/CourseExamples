package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class NotificationSender {
    public Notification sendNotification(NotificationType type){
        return NotificationFactory.createNotification(type);
    }
}
