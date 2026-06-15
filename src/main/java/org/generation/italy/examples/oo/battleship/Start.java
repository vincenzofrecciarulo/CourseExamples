package org.generation.italy.examples.oo.battleship;

public class Start {
    static void main() {



    }
    public void positionBoats(Player p){
        for(BoatTypes bt:BoatTypes.values()){
            for(int i=1;i<3;i++){
                IO.println("Inserisci la nave di tipo: "+bt.name()+" e dimensione: "+bt.getDimension());
                String inputC=IO.readln("Inserisci la coordinata ex:(a,1)");
                Coordinate c=Coordinate.getCoordinate(inputC);
                String inputO=IO.readln("In che verso la voi?? ex(v/o)");
                p.addBoat(bt,c,inputO);
            }
        }
    }
}
