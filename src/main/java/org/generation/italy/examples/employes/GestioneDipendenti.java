package org.generation.italy.examples.employes;
import java.util.*;

public class GestioneDipendenti {
    private final Map<Integer, Employee> dipendenti = new HashMap<>();
    public GestioneDipendenti(List<Employee> lista) {
        for (Employee e : lista) {
            dipendenti.put(e.getId(), e);
        }
    }
    public Employee getById(int id) {
        return dipendenti.get(id);
    }
    public List<Employee> getAllOrderedByAge() {
        List<Employee> lista = new ArrayList<>(dipendenti.values());
        lista.sort(Comparator.comparingInt(Employee::getEta).reversed());
        return lista;
    }
    public List<Employee> getTopTwoPaid() {
        Employee first  = null;
        Employee second = null;
        for (Employee e : dipendenti.values()) {
            if (first == null || e.getStipendio() > first.getStipendio()) {
                second = first;
                first  = e;
            } else if (second == null || e.getStipendio() > second.getStipendio()) {
                second = e;
            }
        }
        List<Employee> top = new ArrayList<>();
        if (first  != null) top.add(first);
        if (second != null) top.add(second);
        return top;
    }
    public List<Employee> getAllOrderedAlphabetically() {
        List<Employee> lista = new ArrayList<>(dipendenti.values());

        lista.sort(Comparator
                .comparing(Employee::getCognome)           // 1° criterio: cognome A→Z
                .thenComparing(e ->                        // 2° criterio: F prima di M
                        e.getSesso() == Employee.Sesso.F ? 0 : 1
                )
                .thenComparing(Employee::getNome)          // 3° criterio: nome A→Z (tie-break)
        );
        return lista;
    }
    static void main() {
        List<Employee> dipendenti = List.of(
                new Employee(1, "Luca",    "Rossi",    Employee.Sesso.M, 35, 3200),
                new Employee(2, "Maria",   "Rossi",    Employee.Sesso.F, 28, 2800),
                new Employee(3, "Giulia",  "Bianchi",  Employee.Sesso.F, 45, 5100),
                new Employee(4, "Marco",   "Bianchi",  Employee.Sesso.M, 50, 4800),
                new Employee(5, "Chiara",  "Verdi",    Employee.Sesso.F, 32, 6200),
                new Employee(6, "Antonio", "Verdi",    Employee.Sesso.M, 60, 5900)
        );

        GestioneDipendenti gd = new GestioneDipendenti(dipendenti);

        System.out.println("=== getById(3) ===");
        System.out.println(gd.getById(3));

        System.out.println("\n=== getAllOrderedByAge (decrescente) ===");
        gd.getAllOrderedByAge().forEach(System.out::println);

        System.out.println("\n=== getTopTwoPaid ===");
        gd.getTopTwoPaid().forEach(System.out::println);

        System.out.println("\n=== getAllOrderedAlphabetically ===");
        gd.getAllOrderedAlphabetically().forEach(System.out::println);
    }
}