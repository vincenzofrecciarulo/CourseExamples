package org.generation.italy.examples.oo.homeexercise.exerciseinterface.ex01;

// Dichiariamo la classe Cerchio, che "firma il contratto" di Forma tramite implements
public class Cerchio implements Forma {

    // Attributo che memorizza il raggio del cerchio
    double raggio;

    // Costruttore: viene eseguito quando creiamo un nuovo Cerchio con "new Cerchio(...)"
    public Cerchio(double raggio) {
        this.raggio = raggio;  // "this.raggio" è l'attributo della classe, "raggio" è il parametro in ingresso
                               // questa riga assegna il valore passato all'attributo dell'oggetto
    }

    // @Override segnala al compilatore: "sto implementando un metodo dell'interfaccia"
    @Override
    public double calcolaArea(){
        // Calcoliamo l'area con la formula matematica: π * raggio²
        double area = Math.PI * (this.raggio * this.raggio);
        // Restituiamo il valore calcolato a chi ha chiamato il metodo
        return area;

    }
    // Restituiamo semplicemente una stringa fissa, perché questa classe rappresenta sempre un cerchio
    @Override
    public String getNome(){
        String name="Cerchio";
        return name;
    }
}
