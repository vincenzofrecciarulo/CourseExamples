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

    public void showRooms(Player player){
        IO.println("""
                Legenda:
                'M' - Mercato
                'T' - Tempio
                'X' - Muro
                'D' - Zona pericolosa
                'P' - Player
                '-' - Inesplorata
                """);
        for(int i = 0; i < map.length; i++){
            StringBuilder row = new StringBuilder();
            Room playerLocation = player.getCurrentRoom(this);
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == null){
                    row = new StringBuilder(row + "  -");
                }else{
                    row.append("  ").append(playerLocation == map[i][j] ? 'P' : map[i][j].getMapIcon());
                }
            }
            IO.println(row);
        }
    }

}
