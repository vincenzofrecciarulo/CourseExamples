package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class NotificationSender {
    public NotificationSender(){}
    public static Notification createNotification(String notificationType) {
        switch (notificationType) {
            case "SMS":
                return new SMSNotification();
            case "WhatsApp":
                return new WhatsappNotification();
            case "Email":
                return new EmailNotification();
            default:
                throw new IllegalArgumentException("Tipo di notifica non supportato");
        }

    }
    public void sendNot(Notification notification){
        System.out.println(notification.send());
    }
}
