package org.generation.italy.examples.introarchitecture.abstractfactory;

public class AbstractFactoryArchitectureApp {

    public static void main(String[] args) {
        ApplicationFactory factory = new JpaApplicationFactory();
        CitizenConsoleController controller =
                factory.createCitizenConsoleController();
        controller.start();
        factory.close();
    }
}
