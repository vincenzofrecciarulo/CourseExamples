package org.generation.italy.examples.oo.mudPersonale.entities.pokemon;

public class PokemonStat {
    private int baseHp;
    private int baseAttack;
    private int baseSpecialAttack;
    private int baseDefense;
    private int baseSpecialDefense;
    private int baseSpeed;

    private float hpGrowth;
    private float attackGrowth;
    private float specialAttackGrowth;
    private float defenseGrowth;
    private float specialDefenseGrowth;
    private float speedGrowth;

    public PokemonStat(int baseHp, int baseAttack,  int baseSpecialAttack, int baseDefense,
                       int baseSpecialDefense, int baseSpeed, float hpGrowth,  float attackGrowth,
                       float specialAttackGrowth, float defenseGrowth, float specialDefenseGrowth, float speedGrowth) {
        this.baseHp = baseHp;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseSpecialAttack = baseSpecialAttack;
        this.baseSpecialDefense = baseSpecialDefense;
        this.hpGrowth = hpGrowth;
        this.baseSpeed = baseSpeed;
        this.attackGrowth = attackGrowth;
        this.specialAttackGrowth = specialAttackGrowth;
        this.defenseGrowth = defenseGrowth;
        this.specialDefenseGrowth = specialDefenseGrowth;
        this.speedGrowth = speedGrowth;
    }

    public int getHp(int level){
        return (int) (baseHp + level * hpGrowth);
    }

    public int getAttack(int level){
        return (int) (baseAttack + level * attackGrowth);
    }

    public int getSpecialAttack(int level){
        return (int) (baseSpecialAttack + level * specialAttackGrowth);
    }

    public int getDefense(int level){
        return (int) (baseDefense + level * defenseGrowth);
    }

    public int getSpecialDefense(int level){
        return (int) (baseSpecialDefense + level * specialDefenseGrowth);
    }

    public int getSpeed(int level){
        return (int) (baseSpeed + level * speedGrowth);
    }
}
