package org.generation.italy.examples.oo.modulo009;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person {

    double mediumVotes;
    protected int costMensa = 2000;
    ArrayList<StudentVotes> votes = new ArrayList<>();

    public Student(String name, String surname, LocalDate dateOfBirth, String gender) {
        super(name, surname, dateOfBirth, gender);
    }

    public void addVote(int vote, String subject) {
        votes.add(new StudentVotes(subject, vote));
    }

    public double calculateMediumVotes() {
        if (votes.isEmpty()) return 0;

        int sum = 0;
        for (StudentVotes v : votes) {
            sum += v.getVotes();
        }
        mediumVotes = (double) sum / votes.size();
        return mediumVotes;
    }

    public int hasBorsa() {
        if (mediumVotes >= 8) {
            for (StudentVotes v : votes) {
                if (v.getVotes() < 6) {  // ← se trova anche solo un voto sotto 6...
                    return 0;            // ...niente borsa
                }
            }
            return 1000;                 // ← nessun voto sotto 6, borsa assegnata
        }
        return 0;                        // ← media sotto 8, niente borsa
    }

    @Override
    public int getCost() {
        return costMensa + hasBorsa();
    }

}