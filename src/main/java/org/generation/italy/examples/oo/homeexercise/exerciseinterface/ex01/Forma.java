package org.generation.italy.examples.oo.homeexercise.exerciseinterface.ex01;

// Dichiariamo un'interfaccia: definisce un "contratto" che le classi devono rispettare
public interface Forma {

    // Metodo astratto (nessun corpo): ogni classe che implementa Forma DEVE fornirne un'implementazione
    double calcolaArea();

    // Altro metodo astratto: stesso discorso, restituisce il nome della forma come stringa
    String getNome();
}
