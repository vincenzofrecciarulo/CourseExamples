package org.generation.italy.examples.employes;

public class Employee {

    public enum Sesso { M, F }

    private final int    id;
    private final String nome;
    private final String cognome;
    private final Sesso  sesso;
    private final int    eta;       // anni — usata per l'ordinamento per età
    private final double stipendio;

    public Employee(int id, String nome, String cognome, Sesso sesso, int eta, double stipendio) {
        this.id        = id;
        this.nome      = nome;
        this.cognome   = cognome;
        this.sesso     = sesso;
        this.eta       = eta;
        this.stipendio = stipendio;
    }

    public int    getId()        { return id; }
    public String getNome()      { return nome; }
    public String getCognome()   { return cognome; }
    public Sesso  getSesso()     { return sesso; }
    public int    getEta()       { return eta; }
    public double getStipendio() { return stipendio; }

    @Override
    public String toString() {
        return String.format("[%d] %s %s | %s | età %d | €%.2f",
                id, nome, cognome, sesso, eta, stipendio);
    }
}