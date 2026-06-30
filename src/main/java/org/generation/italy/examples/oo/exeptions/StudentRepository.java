package org.generation.italy.examples.oo.exeptions;

import java.time.LocalDate;
import java.util.*;

/*chiamato così perché esiste un pattern
   architetturale
   abbiamo delle classe Entity
   ovvero classi salvate in una sorgente dati(Database)
   Student sarà la classe Entity
   ma il principio di single responsability
   non vogliamo mettere i metodi di persistenza di una
   Entity dentro la stessa Entity
   Per quwsto viene creato un repository che ha la
   responsabilità della persistenza dei dati della
   Entity
   (per n Entity si fanno n Repository)
    */
public class StudentRepository {
    private static Map<Long,Student> students= new HashMap<>();
/*bisogna creare un costruttore statico
è un blocco di codice eseguito subito e serve a inizializzare
le variabili statiche
 */
    static{
        Student s1 = new Student(1234,"Mario","Rossi", LocalDate.of(1999,8,17));
        Student s2 = new Student(1244,"Mirko","Bianchi", LocalDate.of(1998,7,15));
        Student s3 = new Student(1334,"Miele","Neri", LocalDate.of(1997,6,14));

        students.put(s1.getId(), s1);
        students.put(s2.getId(), s2);
        students.put(s3.getId(), s3);
    }

    public Student findById(long id){
        return students.get(id);
    }

    public List<Student> findAllOrderedByAge(){
        List<Student> result = new ArrayList<>(students.values());
        Collections.sort(result);
        return result;
    }
}
