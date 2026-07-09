package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class NotificationCenter {
    private NotificationCenter(){

    }
    public static Notification createNotifications(NotificationType type) {
        return switch (type) {
            case WHATSAPP -> new WhatsAppNotification();
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
        };
    }

}
