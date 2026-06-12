package org.generation.italy.examples.oo.homeexercise.ex01;

public class Ex01Libro {
    //1.  Crea una classe Libro con i campi privati: titolo (String), autore (String), prezzo (double), disponibile (boolean).

    private String title;
    private String author;
    private double price;
    private boolean availability;

    //2.  Scrivi due costruttori: uno che accetta tutti e quattro i campi, e uno che accetta solo titolo e autore (prezzo = 0.0, disponibile = true).
    public Ex01Libro(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0;
        this.availability = true;
    }

    public Ex01Libro(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    //3.  Aggiungi getter e setter per ogni campo.

    public String getTitle() {
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice (){
        return price;
    }
    public boolean getAvailability(){
        return availability;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setAvailability(boolean availability){
        this.availability = availability;
    }
}
//4.	Nel main crea almeno tre libri usando entrambi i costruttori e stampa i loro dati.
