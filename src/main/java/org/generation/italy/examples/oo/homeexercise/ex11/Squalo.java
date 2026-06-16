package org.generation.italy.examples.oo.homeexercise.ex11;

public class Squalo extends AnimaleAcquatico{

    public Squalo(String name, double profondità, Habitat habitats) {
        super(name,profondità, habitats);
    }

    @Override
    public void descriviAmbiente() {
        switch (habitats){
            case SAVANA:
                System.out.println("Lo squalo " + super.name + " non vive nella Savana");
                break;
            case FORESTA:
                System.out.println("Lo squalo " + super.name + " non vive nella Foresta");
                break;
            case ACQUATICO:
                System.out.println("Lo squalo " + super.name + " vive nel mare");
                break;
            case ARTICO:
                System.out.println("Lo squalo " + super.name + " vive nell'Oceano");
                break;
        }

    }
}
