package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.enums.Direction;
import org.generation.italy.examples.oo.mud.rooms.EmptyRoom;
import org.generation.italy.examples.oo.mud.rooms.MarketRoom;
import org.generation.italy.examples.oo.mud.rooms.Room;
import org.generation.italy.examples.oo.mud.rooms.TempleRoom;

public class Map {
    private final Room[][] map = new Room[20][20];
    private int currentY = 10;
    private int currentX = 10;

    public Map(){
        map[currentY][currentX] = new TempleRoom();
        map[currentY-1][currentX] = new MarketRoom();
    }

    public void moveTo(Player player, Direction direction){
        switch(direction) {
            case Direction.NORTH:
                if(currentY - 1 < 0 || map[currentY - 1][currentX] instanceof EmptyRoom){
                    IO.println("""
                    Non c'è niente in quella direzione...
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    """);
                    break;
                }
                if(map[currentY - 1][currentX] == null){
                    Room room = Room.getRandomRoom();
                    map[currentY - 1][currentX] = room;

                }
                if(!(map[currentY - 1][currentX] instanceof EmptyRoom)){
                    currentY--;
                }
                IO.println("Stai correndo...");
                break;
            case Direction.SOUTH:
                if(currentY + 1 >= 20 || map[currentY + 1][currentX] instanceof EmptyRoom){
                    IO.println("""
                    Non c'è niente in quella direzione...
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    """);
                    break;
                }
                if(map[currentY + 1][currentX] == null){
                    Room room = Room.getRandomRoom();
                    map[currentY + 1][currentX] = room;

                }
                if(!(map[currentY + 1][currentX] instanceof EmptyRoom)){
                    currentY++;
                }
                IO.println("Stai correndo...");
                break;
            case Direction.EAST:
                if(currentX + 1 >= 20 || map[currentY][currentX + 1] instanceof EmptyRoom){
                    IO.println("""
                    Non c'è niente in quella direzione...
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    """);
                    break;
                }
                if(map[currentY][currentX + 1] == null){
                    Room room = Room.getRandomRoom();
                    map[currentY][currentX + 1] = room;

                }
                if(!(map[currentY][currentX + 1] instanceof EmptyRoom)){
                    currentX++;
                }
                IO.println("Stai correndo...");
                break;
            case Direction.WEST:
                if(currentX - 1 < 0 || map[currentY][currentX - 1] instanceof EmptyRoom){
                    IO.println("""
                    Non c'è niente in quella direzione...
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    """);
                    break;
                }

                if(map[currentY][currentX - 1] == null){
                    Room room = Room.getRandomRoom();
                    map[currentY][currentX - 1] = room;
                }
                if(!(map[currentY][currentX - 1] instanceof EmptyRoom)){
                    currentX--;
                }
                IO.println("Stai correndo...");
                break;
            default:
                break;
        }
    }

    public Room getCurrentRoom(){
        return map[currentY][currentX];
    }

    public void setCurrentRoom(int x, int y){
        currentX = x;
        currentY = y;
    }

    public void resetToStart(){
        setCurrentRoom(10,10);
    }

}
