package org.generation.italy.examples.dependencyinjectionexercise;

public class NotificationManager {

   private NotificationService service;

    public NotificationManager(NotificationService service) {
        this.service = service;
    }

    public NotificationService getService() {
        return service;
    }

    public void notify(String message){
        this.service.send(message);
    }

}
