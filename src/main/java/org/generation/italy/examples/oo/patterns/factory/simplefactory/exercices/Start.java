package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

// assumendo di avere un'interfaccia notification che ha un solo metodo send di String message recipient
// e tre sue implementazioni EmailNotification SMSNotification e WhatsAppNotification
// voglio permettere la creazione in modo semplice e polimorfico di oggetti di questi tre tipi all'interno di una classe NotificationSender
public class Start {
    public static void main(String[] args) {
        NotificationSender notificationSender = new NotificationSender();
        Notification notification = NotificationSender.createNotification("SMS");
        notificationSender.sendNot(notification);
        notification = NotificationSender.createNotification("WhatsApp");
        notificationSender.sendNot(notification);
        notification = NotificationSender.createNotification("Email");
        notificationSender.sendNot(notification);
    }
}