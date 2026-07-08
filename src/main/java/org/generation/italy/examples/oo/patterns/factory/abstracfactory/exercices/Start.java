package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Enemy;
import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Forest;

// Espandere l'esercizio del factorymethod in modo che ci siano tre famiglie di enemy: boss,enemy e treasure
// avremo gli stessi tre livelli e all'interno dovranno essere creati dei enemy boss e treasure adeguati al livello
// la foresta avrà enemy wolf, boss troll e treasure magicMushroom
// space avrà enemy alienSoldier, boss alienQueen e il cristallo di antimateria
// dungeon avrà enemy goblin, boss necromancer e treasure magicCoin
public class Start {
    public static void main(String[] args) {

        System.out.println("=== FOREST ===");
        MonsterFactory forest = new ForestFactory();
        forest.createEnemy().attack();
        forest.createBoss().specialAttack();
        forest.createTreasure().gather();

        System.out.println("=== SPACE ===");
        MonsterFactory space = new SpaceFactory();
        space.createEnemy().attack();
        space.createBoss().specialAttack();
        space.createTreasure().gather();

        System.out.println("=== DUNGEON ===");
        MonsterFactory dungeon = new DungeonFactory();
        dungeon.createEnemy().attack();
        dungeon.createBoss().specialAttack();
        dungeon.createTreasure().gather();
    }
}
