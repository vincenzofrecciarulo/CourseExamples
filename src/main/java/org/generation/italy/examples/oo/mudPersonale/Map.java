package org.generation.italy.examples.oo.mudPersonale;

import org.generation.italy.examples.oo.mudPersonale.entities.Player;
import org.generation.italy.examples.oo.mudPersonale.rooms.ShopRoom;
import org.generation.italy.examples.oo.mudPersonale.rooms.Room;
import org.generation.italy.examples.oo.mudPersonale.rooms.PokecenterRoom;


public class Map {
    private final Room[][] map = new Room[20][20];


    public Map(){
        map[10][10] = new PokecenterRoom();
        map[9][10] = new ShopRoom();
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
