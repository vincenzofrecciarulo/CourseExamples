package org.generation.italy.examples.oo.homeexercise.ex11;

public class ZooPark {
//1.Crea un enum Habitat: SAVANA, FORESTA, ACQUATICO, ARTICO.
//2.Crea la gerarchia: Animale (base) → AnimaleTerraferma → AnimaleAcquatico.
//3.AnimaleTerraferma ha campo zampe (int). AnimaleAcquatico ha campo profondita (double).
//4.Crea almeno due sottoclassi di ognuna (es. Leone, Elefante per terraferma; Delfino, Squalo per acquatico).
//5.Ogni classe concreta ha un metodo descriviAmbiente() che usa lo switch sull'enum Habitat.
//6.Nel main crea un array Animale[] con almeno 6 animali e usa cicli + instanceof + cast per descriverli tutti.
    public static void main (String[] args){
        Animale[] zoo= {new Leone("Simba", 4, Habitat.SAVANA),
                new Elefante("Dumbo",4, Habitat.FORESTA),
                new Delfino("Flipper",100.0, Habitat.ACQUATICO),
                new Squalo("Shark",200.0, Habitat.ARTICO),
                new Leone("Mufasa",4, Habitat.FORESTA),
                new Elefante("Indiano", 4,Habitat.ACQUATICO)};

        for(Animale a: zoo){
            a.descriviAmbiente();

            if (a instanceof AnimaleTerraFerma) {

                AnimaleTerraFerma t =
                        (AnimaleTerraFerma) a;

                System.out.println("Zampe: " + t.zampe);

            } else if (a instanceof AnimaleAcquatico) {

                AnimaleAcquatico acq =
                        (AnimaleAcquatico) a;

                System.out.println("Profondità: "
                        + acq.profondità + " m");
            }

        }

    }

}
