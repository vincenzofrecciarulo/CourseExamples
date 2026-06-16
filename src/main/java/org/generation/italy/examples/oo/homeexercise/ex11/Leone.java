package org.generation.italy.examples.oo.homeexercise.ex11;

public class Leone extends AnimaleTerraFerma{


    public Leone(String name, int zampe, Habitat habitats) {
        super(name,zampe,habitats);

    }

    @Override
    public void descriviAmbiente() {
        switch (habitats){
            case SAVANA:
                System.out.println("Il leone " + super.name + " vive nella Savana");
                break;
            case FORESTA:
                System.out.println("Il leone " + super.name + " non vive nella Foresta");
                break;
            case ACQUATICO:
                System.out.println("Il leone " + super.name + " non vive nel mare");
                break;
            case ARTICO:
                System.out.println("Il leone " + super.name + " non vive nell'Oceano");
                break;
        }

    }
}
