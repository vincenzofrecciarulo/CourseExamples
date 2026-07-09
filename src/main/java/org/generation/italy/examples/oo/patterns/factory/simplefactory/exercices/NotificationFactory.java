package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

public class NotificationFactory {
    private NotificationFactory(){
    }
    public static Notification createNotification(NotificationType type){
        return switch (type){
            case EMAILNOTIFICATION  -> new EmailNotification();
            case SMSNOTIFICATION  -> new SMSnotification();
            case WHATSAPPNOTIFICATION  -> new WhatsappNotification();
        };
    }

}
