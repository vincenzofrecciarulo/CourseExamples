package org.generation.italy.examples.dependencyinjectionexercise;

public class EmailNotificationService implements NotificationService{


    @Override
    public void send(String message) {
        System.out.println("Email "+message);
    }
}
