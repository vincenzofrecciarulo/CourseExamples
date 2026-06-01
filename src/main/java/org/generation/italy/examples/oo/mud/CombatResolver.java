package org.generation.italy.examples.oo.mud;

public class CombatResolver {
    private final DiceRoller diceRoller;

    public CombatResolver(DiceRoller diceRoller) {
        this.diceRoller = diceRoller;
    }

    public AttackResult resolveAttack(Entity attacker, Entity defender) {
        int attackRoll = diceRoller.rollD21();
        int defenseRoll = diceRoller.rollD21();

        int attackScore = attackRoll + attacker.getStats().getStrength() + attacker.getAttackBonus();
        int defenseScore = defenseRoll + defender.getStats().getAgility() + defender.getDefenseBonus();

        if(attackScore <= defenseScore){
            return new AttackResult(false, attackScore, defenseScore, 0);
        }

        int damageRoll = diceRoller.rollD21();
        int damage = Math.max(1, (attacker.getStats().getStrength() / 2) + (damageRoll / 3) + attacker.getDamageBonus());
        return new AttackResult(true, attackScore, defenseScore, damage);
    }
}
