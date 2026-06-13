package org.generation.italy.examples.exathome.abstraction.ex03;

public class Start {
    public static void main(){
        Auto car = new Auto(40);
        Moto motorcycle = new Moto(30);

        System.out.println("Frena con quella dannata auto!");
        car.frena();
        System.out.println("Ora invece dai gas!");
        car.accelera();

        System.out.println("");

        System.out.println("Dai gas a quella moto tutta scassata!");
        motorcycle.accelera();
        System.out.println("Frenaaa!");
        motorcycle.frena();
    }
}