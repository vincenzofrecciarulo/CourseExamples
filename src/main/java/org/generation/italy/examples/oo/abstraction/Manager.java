package org.generation.italy.examples.oo.abstraction;

import java.time.LocalDate;

public class Manager extends Person {
    private boolean lovesVideocalls;

    public Manager(String name, String surname, LocalDate dateofbirth, char gender, boolean lovesVideocalls) {
        super(name, surname, dateofbirth, gender);
        this.lovesVideocalls = lovesVideocalls;
    }

    public void onboardNewHire(Person p) {
        IO.println(p);
        p.assignTask();
        p.startWorking();
    }

    @Override
    public void startWorking() {
        System.out.println("Faccio solo riunioni.");
    }

    @Override
    public void assignTask() {
        System.out.println("Quello che assegna le task sono io.");
    }
}
