package org.generation.italy.examples.dependencyinjectionexercise;

public class SmsNotificationService implements NotificationService{


    @Override
    public void send(String message) {
        System.out.println("SMS " +message);
    }
}
