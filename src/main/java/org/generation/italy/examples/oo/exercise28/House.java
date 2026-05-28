package org.generation.italy.examples.oo.exercise28;
/*Esercizio #28
        • Creare una classe di nome House
• Fornirle le proprietà address (String), area (int) e spm (square meter price, int).
        • Fornirle il metodo di oggetto int getPrice(), per il calcolo del prezzo, ottenuto come spm * area.
• Fornire il metodo di oggetto public String toString(), che produca una stringa con indirizzo, area
e prezzo della casa.
        • Scrivere una classe con un main (classe di avvio, non classe modello) che crei un oggetto casa
coi seguenti dati:
Via Verdi 100, Cassano
Area: 100 MQ
Prezzo al MQ: 1000
        • E ne stampi il toString().*/
public class House {

    String address;
    int area;
    int spm;
    int finalPrice;


    public int getPrice(){
        finalPrice=spm*area;
        return finalPrice;
    }

    public String toString(){
        return address+" "+area+" mq a soli "+finalPrice;
    }
}
