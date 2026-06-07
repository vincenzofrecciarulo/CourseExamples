package org.generation.italy.examplesMio.ooMio.mudMio.rpgMio;

public class DndClass {
    private int hpBase;
    private ClassList classList;
    private int baseStrength;
    private int baseDefense;

    public DndClass(int hpBase, int baseStrength, int baseDefense, ClassList classList){
        this.hpBase = hpBase;
        this.baseStrength = baseStrength;
        this.baseDefense = baseDefense;
        this.classList = classList;
    }

    public int getHpBase() {
        return hpBase;
    }

    public int getBaseStrength(){
        return baseStrength;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public ClassList getClassList(){
        return classList;
    }
}
