package org.generation.italy.examples.Exercises.Exercise1.Objects.Animals;

public class Animal {
    /*
    Classe astratta/base:

Animale

Metodo:
verso()

Classi figlie:
Cane
Gatto
Mucca

Ognuna implementa il proprio verso.
Crea una lista di animali e richiama verso() su tutti.
     */
    private String animalSound;
    public Animal(String animalSound){
        this.animalSound = animalSound;
    }
    public String getAnimalSound(){
        return animalSound;
    }
    public void sound(){

    }
}
