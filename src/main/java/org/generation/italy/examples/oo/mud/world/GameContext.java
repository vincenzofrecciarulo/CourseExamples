package org.generation.italy.examples.oo.mud.world;

import org.generation.italy.examples.oo.mud.combat.CombatCoordinator;

public class GameContext {
    private final PlayerSession session;
    private final Player player;
    private volatile CombatCoordinator combatCoordinator;
    private volatile Room currentRoom;

    public GameContext(PlayerSession session, Room currentRoom, Player player) {
        this(session, currentRoom, player, null);
    }

    public GameContext(PlayerSession session, Room currentRoom, Player player, CombatCoordinator combatCoordinator) {
        this.session = session;
        this.currentRoom = currentRoom;
        this.player = player;
        this.combatCoordinator = combatCoordinator;
    }

    public PlayerSession getSession() {
        return session;
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
