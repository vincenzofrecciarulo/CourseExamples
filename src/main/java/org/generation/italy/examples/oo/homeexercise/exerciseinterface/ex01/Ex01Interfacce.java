package org.generation.italy.examples.oo.homeexercise.exerciseinterface.ex01;

import java.util.ArrayList;
import java.util.List;

public class Ex01Interfacce {
//    Esercizio 1 — Base: Interfacce + Polimorfismo
//    Crea un'interfaccia Forma con un metodo double calcolaArea().
//    Implementa le classi Cerchio, Rettangolo e Triangolo. Poi crea una List<Forma>, aggiungi alcune istanze miste,
//    e scrivi un metodo che scorra la lista stampando l'area di ciascuna forma (sfruttando il polimorfismo, senza if/instanceof).
//
public static void main(String[] args){
    // Creiamo una lista che può contenere QUALSIASI oggetto che implementa Forma
    // ArrayList è l'implementazione concreta scelta per List
    List<Forma> forme = new ArrayList<>();

    // Aggiungiamo un nuovo Cerchio (raggio 5.0) alla lista
    // Nota: anche se Cerchio è un tipo concreto, viene "visto" come Forma dentro la lista
    forme.add(new Cerchio(5.0));
    // Aggiungiamo un nuovo Rettangolo (altezza 10.0, base 5.0)
    forme.add(new Rettangolo(10.0,5.0));
    // Aggiungiamo un nuovo Triangolo (base 4.0, altezza 9.0)
    forme.add(new Triangolo(4.0,9.0));

    // Ciclo for-each: scorre OGNI elemento della lista "forme", uno alla volta
    // ad ogni iterazione, "t" punta all'oggetto corrente (prima Cerchio, poi Rettangolo, poi Triangolo)
    for( Forma t: forme){
        System.out.println("L'area del " + t.getNome() +" è: " + t.calcolaArea());
        // t.getNome() chiama il metodo getNome() dell'oggetto REALE puntato da t in quel momento
        // t.calcolaArea() chiama il metodo calcolaArea() dell'oggetto REALE, non un metodo generico
        // questo è il polimorfismo: stessa riga di codice, comportamento diverso a seconda dell'oggetto

    }
  }
}