package org.generation.italy.examples.oo.exceptions;

// repository perchè esiste un pattern archittetturale, un design di livello molto alto,
// che riguarda l'archittetura di una app

// classi entity, una classe i cui dati/stato verranno salvati su una sorgente dati
// (ad esempio un database)
// Student è la classe entity
// Però per non violare il primo principio solid, non mettiamo i metodi in Student ma da un'altra parte
// un repository è una classe che viene creata per le entity e ha la responsabilità dei dati per quella entity
// in passato i repository venivano chiamati DAO (DATA ACESS OBJECT) - DAO PATTERN = REPOSITORY PATTERN
// questo repository non andrè in un database ma li mettermo in "memory" (in una struttura dati come una hashmap)


import java.time.LocalDate;
import java.util.*;

public class StudentRepository {
    private static Map<Long, Student> students = new HashMap<>();

    // "costruttore statico" (o "static block")
    static {
        Student s1 = new Student(
                1, "Riccardo", "Rossi", LocalDate.of(2026, 4,2));
        Student s2 = new Student(
                2, "Roberto", "Verdi", LocalDate.of(2026, 4,3));
        Student s3 = new Student(
                3, "Cicalone", "Bianchi", LocalDate.of(2026, 4,4));

        students.put(s1.getId(), s1);
        students.put(s2.getId(), s2);
        students.put(s3.getId(), s3);
    }



    public Optional<Student> findByID(long id){
//        Student maybe = students.get(id);
//        if (maybe == null){
//            return Optional.empty();
//        }
//        return Optional.of(maybe);
        return Optional.ofNullable(students.get(id));
    }

    public List<Student> findAllOrderedByAge (){
        List<Student> all = new ArrayList<>(students.values());
        Collections.sort(all); // qui prende la lista e non il comparator

        return all;
    }

    public Collection<Student> findAllBornAfter (LocalDate birthDate ){
        Collection<Student> all = new ArrayList<>();
        for (Student s : students.values()){
            if (s.isBornAfter(birthDate)) {
                all.add(s);
            }
        }
        return all;
    }

    public List<Student> findAllOrderedById() {
        List<Student> result = new ArrayList<>(students.values());
        // questa sintassi crea una nuova classe che implementa Comparator, ne istanzia un oggetto e overrida compare
        // lo svantaggio di questo approccio è che non possiamo chiamare questo comparatore altrove, e dovremmo riscriverlo
        result.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//                return (int)(o1.getId() - o2.getId());
                return Long.compare(o1.getId(), o2.getId());
            }
        });
        return result;
    }

    public void addStudent(Student s) throws StudentAlreadyExistsException {
        if (students.containsKey(s.getId())){
            throw new StudentAlreadyExistsException("Lo studente che vuoi inserire ha un'ID già presente nella base dati.");
            // Crea un oggetto di tipo eccezione Illegal... poi lo lancia e blocca l'esecuzione della funzione e passa l'eccezione al metodo che l'ha chiamato
        }
        students.put(s.getId(), s);

    }

}
