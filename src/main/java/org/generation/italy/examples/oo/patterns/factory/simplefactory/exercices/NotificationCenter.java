package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class NotificationCenter {
    private NotificationCenter() {}

    public static Notification createNotification(NotificationType type){
        return switch (type) {
            case SMS -> new SmsNotification();
            case EMAIL -> new EmailNotification();
            case WHATSAPP -> new WhatsappNotification();
        };
    }
}
