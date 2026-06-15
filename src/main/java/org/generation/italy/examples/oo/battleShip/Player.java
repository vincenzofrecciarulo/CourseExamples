package org.generation.italy.examples.oo.battleShip;

public class Player {
    private final int gridDimension =10;
    private Cell[][] defenceGrid;
    private Cell[][] attackGrid;
    private String name;

    public Player(String name) {
        this.name=name;
        this.defenceGrid=new Cell[gridDimension][gridDimension];
        this.attackGrid=new Cell[gridDimension][gridDimension];

    }
    public Cell[][] getDefenceGrid() {return defenceGrid;}
    public Cell[][] getAttackGrid() {return attackGrid;}
    public String getName() {return name;}

    public void addBoat(BoatType b) {
        int dim = b.getSize();
        boolean validPosition = false;

        do {
            IO.println("\nLa tua griglia:");
            this.printDefenceGrid();
            IO.println("Stai posizionando una nave di dimensione: " + dim);
            Coordinate coordinate = InputManager.readCoordinate();
            char orientation = InputManager.readOrientation();
            validPosition = tryPositioningBoat(coordinate, orientation, b);

            if (!validPosition) {
                IO.println("Posizione non valida! La nave esce dalla griglia o si sovrappone.");
            }
        } while (!validPosition);
    }


    private boolean tryPositioningBoat(Coordinate coordinate, char orientation, int dim) {

    }

    private void printDefenceGrid() {
    }

    private boolean columnIsValid(int column) {
        return column >= 0 && column <= 9;
    }

    private boolean rowIsValid(char row) {
        return
    }
}
