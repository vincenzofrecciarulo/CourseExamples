package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.roles.CharacterClass;
import org.generation.italy.examples.oo.mud.roles.CharacterStats;
import org.generation.italy.examples.oo.mud.roles.Paladin;
import org.generation.italy.examples.oo.mud.roles.SpecialAbility;
import org.generation.italy.examples.oo.mud.commands.CommandOutcome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Player extends Entity {
    private ArrayList<Item> inventory;
    private Item equipped;
    private final CharacterClass characterClass;
    private final CharacterStats stats;
    private final int maxHitPoints;
    private final List<SpecialAbility> specialAbilities;

    public Player(int hp, String name, int level) {
        this(hp, name, level, new Paladin(), new CharacterStats(1, 1, 1, 1, 1));
    }

    public Player(int hp, String name, int level, CharacterClass characterClass, CharacterStats stats) {
        super(hp, name, level);
        this.inventory = new ArrayList<>();
        this.equipped = null;
        this.characterClass = characterClass;
        this.stats = stats;
        this.maxHitPoints = hp;
        this.specialAbilities = new ArrayList<>(characterClass.createSpecialAbilities());
    }

    public boolean pickUp(Item item){
        if(item==null) return false;
        return inventory.add(item);
    }

    public Optional<Item> drop(String name){
        /*
        // Old version: removing from a list inside an enhanced for-loop is fragile
        // because it mixes iteration and mutation in the same structure.
        for(Item i: inventory){
            if(i.getName().equalsIgnoreCase(name)){
                inventory.remove(i);
                if(equipped==i) equipped = null;
                return Optional.of(i);
            }
        }
        */
        var it = inventory.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(i.getName().equalsIgnoreCase(name)){
                it.remove();
                if(equipped==i) equipped = null;
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public boolean equip(String name){
        for(Item i: inventory){
            if(i.getName().equalsIgnoreCase(name)){
                this.equipped = i;
                return true;
            }
        }
        return false;
    }

    /** Drop an item by prefix match (case-insensitive) */
    public Optional<Item> dropByPrefix(String prefix){
        if(prefix==null || prefix.isEmpty()) return Optional.empty();
        String lower = prefix.toLowerCase();
        var it = inventory.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(i.getName().toLowerCase().startsWith(lower)){
                it.remove();
                if(equipped==i) equipped = null;
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /** Equip an item by prefix match (case-insensitive) */
    public boolean equipByPrefix(String prefix){
        if(prefix==null || prefix.isEmpty()) return false;
        String lower = prefix.toLowerCase();
        for(Item i: inventory){
            if(i.getName().toLowerCase().startsWith(lower)){
                this.equipped = i;
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getInventoryNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Item i: inventory) names.add(i.getName());
        return names;
    }

    public Item getEquipped(){
        return equipped;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public CharacterStats getStats() {
        return stats;
    }

    @Override
    public int getAttackBonus() {
        return 0;
    }

    @Override
    public int getDefenseBonus() {
        return 0;
    }

    @Override
    public int getDamageBonus() {
        return 0;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void heal(int points) {
        if(points <= 0){
            return;
        }
        setHp(Math.min(getHp() + points, maxHitPoints));
    }

    public List<SpecialAbility> getSpecialAbilities() {
        return specialAbilities;
    }

    public CommandOutcome useAbility(String input, GameContext context) {
        if(input == null || input.isBlank()){
            context.getIo().println("Quale abilita vuoi usare?");
            return CommandOutcome.CONTINUE;
        }

        String trimmed = input.trim();
        String normalized = trimmed.toLowerCase();
        for(SpecialAbility ability : specialAbilities){
            String candidateName = ability.getName().toLowerCase();
            if(normalized.equals(candidateName)){
                return ability.use(context, "");
            }
            if(normalized.startsWith(candidateName + " ")){
                String targetName = trimmed.substring(ability.getName().length()).trim();
                return ability.use(context, targetName);
            }
            if(candidateName.startsWith(normalized)){
                return ability.use(context, "");
            }
        }

        context.getIo().println("Non trovo questa abilita: " + trimmed);
        return CommandOutcome.CONTINUE;
    }
}
