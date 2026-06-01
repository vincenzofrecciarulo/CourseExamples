package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CombatSession implements Runnable {
    private final GameContext context;
    private final GameIO io;
    private final Entity opponent;
    private final CombatCoordinator coordinator;
    private final BlockingQueue<CombatAction> actionQueue = new LinkedBlockingQueue<>();
    private final CombatResolver combatResolver = new CombatResolver(new RandomDiceRoller(new Random()));
    private final Random random = new Random();
    private volatile boolean running = true;
    private Thread thread;

    public CombatSession(GameContext context, GameIO io, Entity opponent, CombatCoordinator coordinator) {
        this.context = context;
        this.io = io;
        this.opponent = opponent;
        this.coordinator = coordinator;
    }

    public void start() {
        thread = new Thread(this, "combat-" + opponent.getName());
        thread.start();
    }

    public void enqueue(CombatAction action) {
        if(action != null && running){
            actionQueue.offer(action);
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void stop() {
        running = false;
        if(thread != null){
            thread.interrupt();
        }
    }

    @Override
    public void run() {
        io.println("Combattimento contro " + opponent.getName() + "!");

        while(running && context.getPlayer().isAlive() && opponent.isAlive() && context.getCurrentRoom().getEntities().contains(opponent)){
            io.println(context.getPlayer().getName() + " vs " + opponent.getName() + " | PF " + context.getPlayer().getHp() + "/" + opponent.getHp());
            resolvePlayerTurn();
            if(!running || !context.getPlayer().isAlive() || !opponent.isAlive()){
                break;
            }

            sleepQuietly(500);
            resolveOpponentTurn();
            sleepQuietly(500);
        }

        if(!context.getPlayer().isAlive()){
            io.println("Sei stato sconfitto.");
            coordinator.markGameOver();
        } else if(!opponent.isAlive() || !context.getCurrentRoom().getEntities().contains(opponent)){
            io.println(opponent.getName() + " cade.");
        }

        running = false;
        coordinator.onCombatEnded(this);
    }

    private void resolvePlayerTurn() {
        CombatAction action = actionQueue.poll();
        if(action == null){
            action = CombatAction.attack();
        }

        switch(action.getType()){
            case ATTACK -> resolveAttack(context.getPlayer(), opponent);
            case USE_ABILITY -> {
                CommandOutcome outcome = context.getPlayer().useAbility(action.getPayload(), context);
                if(outcome == CommandOutcome.QUIT){
                    running = false;
                }
            }
            case FLEE -> attemptFlee();
            case WAIT -> io.println(context.getPlayer().getName() + " aspetta.");
        }
    }

    private void resolveOpponentTurn() {
        if(!running || !context.getPlayer().isAlive() || !opponent.isAlive()){
            return;
        }
        resolveAttack(opponent, context.getPlayer());
    }

    private void resolveAttack(Entity attacker, Entity defender) {
        AttackResult result = combatResolver.resolveAttack(attacker, defender);
        if(!result.isHit()){
            io.println(attacker.getName() + " manca " + defender.getName() + ".");
            return;
        }

        boolean dead = defender.applyDamage(result.getDamage());
        io.println(attacker.getName() + " colpisce " + defender.getName()
                + " per " + result.getDamage() + " danni.");
        if(dead){
            io.println(defender.getName() + " crolla a terra.");
            if(defender != context.getPlayer()){
                context.getCurrentRoom().removeEntity(defender);
            }
        }
    }

    private void attemptFlee() {
        Room room = context.getCurrentRoom();
        int[] directions = {Room.NORTH, Room.EAST, Room.SOUTH, Room.WEST};
        int chosenDirection = directions[random.nextInt(directions.length)];
        Room destination = room.exitAt(chosenDirection);
        if(destination == null){
            io.println(context.getPlayer().getName() + " prova a fuggire ma non trova una via d'uscita.");
            return;
        }

        room.removeEntity(context.getPlayer());
        context.setCurrentRoom(destination);
        destination.addEntity(context.getPlayer());
        io.println(context.getPlayer().getName() + " fugge verso " + directionName(chosenDirection) + ".");
        io.println(destination.toString());
        running = false;
    }

    private String directionName(int direction) {
        return switch(direction) {
            case Room.NORTH -> "nord";
            case Room.EAST -> "est";
            case Room.SOUTH -> "sud";
            case Room.WEST -> "ovest";
            default -> "?";
        };
    }

    private void sleepQuietly(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
