package org.generation.italy.examples.oo.mud;

public class GameContext {
    private final GameIO io;
    private final Player player;
    private volatile CombatCoordinator combatCoordinator;
    private volatile Room currentRoom;

    public GameContext(GameIO io, Room currentRoom, Player player) {
        this(io, currentRoom, player, null);
    }

    public GameContext(GameIO io, Room currentRoom, Player player, CombatCoordinator combatCoordinator) {
        this.io = io;
        this.currentRoom = currentRoom;
        this.player = player;
        this.combatCoordinator = combatCoordinator;
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

    public CombatCoordinator getCombatCoordinator() {
        return combatCoordinator;
    }

    public void setCombatCoordinator(CombatCoordinator combatCoordinator) {
        this.combatCoordinator = combatCoordinator;
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
