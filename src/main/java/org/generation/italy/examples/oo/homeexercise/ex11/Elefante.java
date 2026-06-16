package org.generation.italy.examples.oo.homeexercise.ex11;

public class Elefante extends AnimaleTerraFerma{

    public Elefante(String name,int zampe, Habitat habitats) {
        super(name,zampe,habitats);
    }

    @Override
    public void descriviAmbiente() {
        switch (habitats){
            case SAVANA:
                System.out.println("L'elefante " + super.name + " vive nella Savana");
                break;
            case FORESTA:
                System.out.println("L'elefante " + super.name + " vive nella Foresta");
                break;
            case ACQUATICO:
                System.out.println("L'elefante " + super.name + " non vive nel mare");
                break;
            case ARTICO:
                System.out.println("L'elefante " + super.name + " non vive nell'Oceano");
                break;
        }

    }
}
