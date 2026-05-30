package org.generation.italy.examples.oo.mud;

public class GameContext {
    private final GameIO io;
    private final Player player;
    private Room currentRoom;

    public GameContext(GameIO io, Room currentRoom, Player player) {
        this.io = io;
        this.currentRoom = currentRoom;
        this.player = player;
    }

    public GameIO getIo() {
        return io;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean moveTo(int direction) {
        Room destination = currentRoom.exitAt(direction);
        if(destination == null){
            return false;
        }
        currentRoom = destination;
        return true;
    }
}
