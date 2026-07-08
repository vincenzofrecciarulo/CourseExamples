package org.generation.italy.examples.dependencyinjectionexercise;

public class Main {

    static void main() {
       NotificationService ns = new SmsNotificationService();
       NotificationManager nm = new NotificationManager(ns);
        String message = IO.readln("Scrivi un messaggio ");
       nm.notify(message);
    }

}
