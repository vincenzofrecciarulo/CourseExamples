package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class NotificationSender {
    public void send(NotificationType type, String message, String recipient) {
        Notification notification = NotificationFactory.createNotification(type);
        notification.send(message, recipient);
    }
}