package org.generation.italy.examples.pokemon.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPokemon implements Battler, Healable {

    protected PokedexEntry entry;
    protected int level;
    protected int currentHp;
    protected int maxHp;
    protected int attack, defense, spAttack, spDefense, speed;
    protected List<Move> moves;
    protected StatusEffect status;
    protected int xp;
    protected int sleepCounter;

    protected AbstractPokemon(PokedexEntry entry, int level) {
        this.entry = entry;
        this.level = level;
        this.status = StatusEffect.NONE;
        this.xp = 0;
        this.sleepCounter = 0;
        this.moves = new ArrayList<>();
        recalculateStats();
        this.currentHp = maxHp;
        initMoves();
    }

    protected void recalculateStats() {
        BaseStats b = entry.getBaseStats();
        maxHp    = calcHp(b.getHp(), level);
        attack   = calcStat(b.getAttack(), level);
        defense  = calcStat(b.getDefense(), level);
        spAttack = calcStat(b.getSpAttack(), level);
        spDefense = calcStat(b.getSpDefense(), level);
        speed    = calcStat(b.getSpeed(), level);
    }

    private int calcHp(int base, int lvl) {
        return (2 * base * lvl) / 100 + lvl + 10;
    }

    private int calcStat(int base, int lvl) {
        return (2 * base * lvl) / 100 + 5;
    }

    protected void initMoves() {
        moves.clear();
        if (entry == null || entry.getLearnset() == null || entry.getLearnset().isEmpty()) return;
        for (PokedexEntry.LearnEntry le : entry.getLearnset()) {
            if (le == null || le.moveTemplate == null) continue; // riga corrotta nel learnset
            if (le.level > level) break;
            Move copy = le.moveTemplate.copy();
            if (moves.size() < 4) {
                moves.add(copy);
            } else {
                moves.remove(0);
                moves.add(copy);
            }
        }
    }

    /** Check if the Pokémon learns a move at its current level, and add it. */
    public void learnMovesAtCurrentLevel() {
        for (PokedexEntry.LearnEntry le : entry.getLearnset()) {
            if (le.level == level) {
                Move copy = le.moveTemplate.copy();
                boolean alreadyKnown = moves.stream().anyMatch(m -> m.getName().equals(copy.getName()));
                if (alreadyKnown) continue;
                System.out.println(getName() + " wants to learn " + copy.getName() + "!");
                if (moves.size() < 4) {
                    moves.add(copy);
                    System.out.println(getName() + " learned " + copy.getName() + "!");
                } else {
                    System.out.println(getName() + " forgot " + moves.get(0).getName()
                            + " and learned " + copy.getName() + "!");
                    moves.remove(0);
                    moves.add(copy);
                }
            }
        }
    }

    /** Abstract: subclasses provide their own flavour description. */
    public abstract String getDescription();

    // ─── Battler ────────────────────────────────────────────────────────────
    @Override public String getName()            { return entry.getName(); }
    @Override public int getLevel()              { return level; }
    @Override public int getCurrentHp()          { return currentHp; }
    @Override public int getMaxHp()              { return maxHp; }
    @Override public boolean isAlive()           { return currentHp > 0; }
    @Override public List<Move> getMoves()       { return moves; }
    @Override public PokemonType[] getTypes()    { return entry.getTypes(); }
    @Override public StatusEffect getStatus()    { return status; }
    @Override public void setStatus(StatusEffect e) {
        if (e == null) return; // ignora status null invece di NullPointerException
        if (this.status == StatusEffect.NONE || e == StatusEffect.NONE) {
            this.status = e;
            if (e == StatusEffect.SLEEP) sleepCounter = (int) (Math.random() * 3) + 1;
        }
    }
    @Override public void takeDamage(int dmg)    { currentHp = Math.max(0, currentHp - dmg); }
    @Override public int getAttack()             { return attack; }
    @Override public int getDefense()            { return defense; }
    @Override public int getSpAttack()           { return spAttack; }
    @Override public int getSpDefense()          { return spDefense; }
    @Override public int getSpeed()              { return speed; }

    // ─── Healable ───────────────────────────────────────────────────────────
    @Override public void heal(int amount) { currentHp = Math.min(maxHp, currentHp + amount); }
    @Override public void fullHeal()       { currentHp = maxHp; status = StatusEffect.NONE; sleepCounter = 0; }
    @Override public void restorePp()      { moves.forEach(Move::restorePp); }

    // ─── Accessors ──────────────────────────────────────────────────────────
    public PokedexEntry getEntry()    { return entry; }
    public int getXp()                { return xp; }
    public void addXp(int amount)     { xp += amount; }
    public int getSleepCounter()      { return sleepCounter; }
    public void decrementSleepCounter() { if (sleepCounter > 0) sleepCounter--; }
}