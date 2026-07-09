package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class NotificationSender {
    private NotificationSender() {
    }

    public static Notification createNotification(String type) {
        return switch (type) {
            case "EMAIL" -> new EmailNotification();
            case "SMS" -> new SmsNotification();
            case "WHATSAPP" -> new WhatsappNotification();
            default -> throw new IllegalArgumentException("Tipo di notifica non valido: " + type);

        };
    }

}
