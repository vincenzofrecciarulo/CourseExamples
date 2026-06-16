package org.generation.italy.examples.oo.homeexercise.ex11;

public class Delfino extends AnimaleAcquatico{

    public Delfino(String name, double profondità, Habitat habitats) {
        super(name, profondità, habitats);
    }

    @Override
    public void descriviAmbiente() {
        switch (habitats){
            case SAVANA:
                System.out.println("Il Delfino " + super.name + " non vive nella Savana");
                break;
            case FORESTA:
                System.out.println("Il Delfino " + super.name + " non vive nella Foresta");
                break;
            case ACQUATICO:
                System.out.println("Il Delfino " + super.name + " vive nel mare");
                break;
            case ARTICO:
                System.out.println("Il Delfino " + super.name + " vive nell'Oceano");
                break;
        }

    }
}
