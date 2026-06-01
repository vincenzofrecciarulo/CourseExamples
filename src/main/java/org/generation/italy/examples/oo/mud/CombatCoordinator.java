package org.generation.italy.examples.oo.mud;

import java.util.concurrent.atomic.AtomicReference;

public class CombatCoordinator {
    private final GameContext context;
    private final GameIO io;
    private final AtomicReference<CombatSession> activeSession = new AtomicReference<>();
    private volatile boolean gameOver;

    public CombatCoordinator(GameContext context, GameIO io) {
        this.context = context;
        this.io = io;
    }

    public boolean isCombatActive() {
        CombatSession session = activeSession.get();
        return session != null && session.isRunning();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean startCombat(Entity opponent) {
        if(opponent == null){
            return false;
        }

        CombatSession session = new CombatSession(context, io, opponent, this);
        if(!activeSession.compareAndSet(null, session)){
            return false;
        }

        session.start();
        return true;
    }

    public void enqueueInput(String rawInput) {
        CombatSession session = activeSession.get();
        if(session == null){
            return;
        }
        CombatAction action = parse(rawInput);
        if(action != null){
            session.enqueue(action);
        }
    }

    public void stopCombat() {
        CombatSession session = activeSession.getAndSet(null);
        if(session != null){
            session.stop();
        }
    }

    void onCombatEnded(CombatSession session) {
        activeSession.compareAndSet(session, null);
    }

    void markGameOver() {
        gameOver = true;
    }

    private CombatAction parse(String rawInput) {
        if(rawInput == null){
            return null;
        }

        String trimmed = rawInput.trim();
        if(trimmed.isEmpty()){
            return null;
        }

        String lower = trimmed.toLowerCase();
        if(lower.equals("flee") || lower.equals("run") || lower.equals("escape") || lower.equals("fuga")){
            return CombatAction.flee();
        }
        if(lower.equals("wait") || lower.equals("rest") || lower.equals("aspetta")){
            return CombatAction.waitTurn();
        }
        if(lower.startsWith("use ")){
            return CombatAction.useAbility(trimmed.substring(4).trim());
        }
        if(lower.startsWith("ability ")){
            return CombatAction.useAbility(trimmed.substring(8).trim());
        }
        if(lower.startsWith("skill ")){
            return CombatAction.useAbility(trimmed.substring(6).trim());
        }

        io.println("Durante il combattimento puoi usare: flee, ability <abilita>, wait");
        return null;
    }
}
