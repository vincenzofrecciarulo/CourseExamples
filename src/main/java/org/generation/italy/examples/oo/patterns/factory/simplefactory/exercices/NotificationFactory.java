package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class NotificationFactory {
    private NotificationFactory() {}

    public static Notification createNotification(NotificationType type) {
        return switch (type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
            case WHATSAPP -> new WhatsappNotification();

        };
    }
}
