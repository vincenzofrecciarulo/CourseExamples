package org.generation.italy.examples.oo.modulo009;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentVotes {

     private String subject;
     private int votes;

     public StudentVotes(String materia, int votes) {
          this.subject = subject;
          this.votes = votes;
     }

     public String getSubject() {
          return subject;
     }

     public void setSubject(String subject) {
          subject = subject;
     }

     public int getVotes() {
          return votes;
     }

     public void setVotes(int votes) {
          votes = votes;
     }

     public String toString() {
          return "Materia: " + subject + " | Voto: " + votes;
     }
}

