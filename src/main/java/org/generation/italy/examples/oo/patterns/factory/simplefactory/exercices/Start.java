package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;

// assumendo di avere un'interfaccia notification che ha un solo metodo send di String message recipient
// e tre sue implementazioni EmailNotification SMSNotification e WhatsAppNotification
// voglio permettere la creazione in modo semplice e polimorfico di oggetti di questi tre tipi all'interno di una classe NotificationSender
public class Start {
    static void main() {
        Notification n = NotificationCenter.createNotifications(NotificationType.EMAIL);
        n.send("Mi piacciono le banane");
    }

     }
