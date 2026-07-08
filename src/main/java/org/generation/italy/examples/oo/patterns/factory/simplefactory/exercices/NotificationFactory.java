package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

// La Factory sposta questa responsabilità in un punto unico
// La classe NotificationFactory è responsabile della creazione delle notifiche
public class NotificationFactory {
    private NotificationFactory(){
    }

    public static Notification createNotification(NotificationType type){
        return switch(type){
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
            case WHATSAPP -> new WhatsAppNotification();
        };
    }
}
