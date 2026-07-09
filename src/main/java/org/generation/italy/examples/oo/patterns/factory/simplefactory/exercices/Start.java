package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;
// assumendo di avere un'interfaccia notification che ha un solo metodo send di String message recipient
// e tre sue implementazioni EmailNotification SMSNotification e WhatsAppNotification
// voglio permettere la creazione in modo semplice e polimorfico di oggetti di questi tre tipi all'interno di una classe NotificationSender
public class Start {
    public static void main(String[] args) {
        Notification smsNotification = NotificationCenter.createNotification(NotificationType.SMS);
        Notification emailNotification = NotificationCenter.createNotification(NotificationType.EMAIL);
        Notification whatsappNotification = NotificationCenter.createNotification(NotificationType.WHATSAPP);

        smsNotification.send("Hello, this is an SMS notification!", "user@example.com");
        emailNotification.send("Hello, this is an email notification!", "user@example.com");
        whatsappNotification.send("Hello, this is a WhatsApp notification!", "user@example.com");
    }
}
