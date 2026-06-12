package org.generation.italy.examples.oo.homeexercise.ex02;

public class Ex02Termostato {
//1.Crea una classe Termostato con campo privato temperatura (double). Valore minimo 5.0, massimo 30.0.

    private double minTemperature = 5.0;
    private double maxTemperature = 30.0;
    private double temperature;

    public Ex02Termostato(double temperature){
        this.temperature= temperature;
    }

    //2.Nel setter setTemperatura(), usa l'operatore ternario per impostare 5.0 se il valore è troppo basso, 30.0 se troppo alto, altrimenti il valore ricevuto.

    public void setTemperature(double temperature) {
        this.temperature =
                temperature < minTemperature ? minTemperature :
                        temperature > maxTemperature ? maxTemperature :
                        temperature;
    }

    //3.Aggiungi un metodo getStato() che usa ancora l'operatore ternario e restituisce "Caldo" se temperatura >= 20, altrimenti "Fresco".
    public String getStato() {
         String state= this.temperature >=20 ? "Caldo" : "Fresco";
         return state;
    }

    //4.Nel main, prova a impostare temperature fuori range e verifica il comportamento.


}
