package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public abstract class Level{
    private String name;
   /* public boolean attackedEnemy(EnemyType type){
        Enemy enemy = createEnemy(type);
        attackEnemy(enemy);
        return true;
    };*/
    protected abstract Enemy createEnemy(EnemyType type);

    private void attackEnemy(Enemy enemy){
        IO.println("attacked enemy "+enemy.type);
    };

}
