package org.generation.italy.examples.oo.patterns.factory.simplefactory.exercices;
// assumendo di avere un'interfaccia notification che ha un solo metodo send di String message recipient
// e tre sue implementazioni EmailNotification SMSNotification e WhatsAppNotification
// voglio permettere la creazione in modo semplice e polimorfico di oggetti di questi tre tipi all'interno di una classe NotificationSender
public class Start {
    public static void main (String[] args){
        Notification sms = NotificationSender.createNotification("SMS");
        System.out.println(sms.send("ciao"));

        Notification whatsapp = NotificationSender.createNotification("WHATSAPP");
        System.out.println(whatsapp.send("ciao"));

        Notification email = NotificationSender.createNotification("EMAIL");
        System.out.println(email.send("ciao"));

    }
}
