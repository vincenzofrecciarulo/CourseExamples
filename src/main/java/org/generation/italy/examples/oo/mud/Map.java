package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.enums.Direction;
import org.generation.italy.examples.oo.mud.rooms.EmptyRoom;
import org.generation.italy.examples.oo.mud.rooms.MarketRoom;
import org.generation.italy.examples.oo.mud.rooms.Room;
import org.generation.italy.examples.oo.mud.rooms.TempleRoom;

import java.util.Arrays;

public class Map {
    private final Room[][] map = new Room[20][20];


    public Map(){
        map[10][10] = new TempleRoom();
        map[9][10] = new MarketRoom();
    }

    public Room getRoom(int y, int x){
        return map[y][x];
    }

    public void setRoom(Room room, int y, int x){
        map[y][x] = room;
    }

    public void showRooms(){
        for(Room[] row : map){
            IO.println(Arrays.toString(row));
        }
    }

}
