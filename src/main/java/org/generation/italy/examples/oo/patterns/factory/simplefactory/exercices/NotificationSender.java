package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class NotificationSender {

    public NotificationSender() {
    }

    public static Notification sender(String message){
        return switch (message){
            case "Email" -> new EmailNotification();
            case "SMS" -> new SMSNotification();
            case "WhatsApp" -> new WhatsAppNotification();
            default -> throw new IllegalArgumentException("Non valido" + message);
        };
    }
}
