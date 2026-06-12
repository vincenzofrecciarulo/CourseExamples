package org.generation.italy.examples.oo.homeexercise.ex02;

public class Start {
    //4.Nel main, prova a impostare temperature fuori range e verifica il comportamento.
    public static void main(String[] args){
        Ex02Termostato tsKitchen = new Ex02Termostato(25.0);
        tsKitchen.setTemperature(31.0);
        System.out.println("Ora il termostato della cucina è: " + tsKitchen.getStato());

        Ex02Termostato tsBathroom = new Ex02Termostato(25.0);
        tsBathroom.setTemperature(19.0);
        System.out.println("Ora il termostato del bagno è: " + tsBathroom.getStato());

        Ex02Termostato tsLivingRoom = new Ex02Termostato(25.0);
        tsLivingRoom.setTemperature(3.0);
        System.out.println("Ora il termostato del salone è: " + tsLivingRoom.getStato());
    }
}
