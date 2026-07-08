package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public abstract class Level implements EntityFactory{
    Enemy enemy;
    Boss boss;
    Treasure treasure;
    void talkToEntity(Entity e){
        IO.println(e.name()+"\n dice:\n");
        e.speak();
    }
    void enemyAttack(Entity e){
        e.attack();
    }

}
