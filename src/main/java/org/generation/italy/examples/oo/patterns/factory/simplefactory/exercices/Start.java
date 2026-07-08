package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;
// assumendo di avere un'interfaccia notification che ha un solo metodo send di String message recipient
// e tre sue implementazioni EmailNotification SMSNotification e WhatsAppNotification
// voglio permettere la creazione in modo semplice e polimorfico di oggetti di questi tre tipi all'interno di una classe NotificationSender
public class Start {
    public static void main(String[] args) {
        NotificationSender sender = new NotificationSender();
        sender.send(NotificationType.EMAIL, "Benvenuto!", "manuel@example.com");
        sender.send(NotificationType.SMS, "Codice: 1234", "3331234567");
        sender.send(NotificationType.WHATSAPP, "Ci vediamo alle 18", "3331234567");
    }
}
