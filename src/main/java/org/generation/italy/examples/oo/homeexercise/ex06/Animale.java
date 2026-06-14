package org.generation.italy.examples.oo.homeexercise.ex06;

public class Animale {
//1.Crea una classe madre Animale con campi nome (String) e età (int), un costruttore, e un metodo faiVerso() che stampa "...".
//2.Crea le sottoclassi Cane e Gatto che estendono Animale.
//3.Override di faiVerso() in Cane (stampa "Bau!") e in Gatto (stampa "Miao!").
//4.Aggiungi in Cane un metodo portaAPasseggio() e in Gatto un metodo graffia() — metodi che non esistono in Animale.
//5.Nel main crea oggetti di entrambi i tipi e chiama faiVerso() su ciascuno.

    private String name;
    private int age;

    public Animale(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void faiVerso (){
      System.out.println("Il verso dell'animale è: ");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
