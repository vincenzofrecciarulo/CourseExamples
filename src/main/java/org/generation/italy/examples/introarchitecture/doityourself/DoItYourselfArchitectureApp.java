package org.generation.italy.examples.introarchitecture.doityourself;

public class DoItYourselfArchitectureApp {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        CitizenConsoleController controller = config.citizenConsoleController();
        controller.start();
        config.close();
    }
}
