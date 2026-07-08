package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;
// Espandere l'esercizio del factorymethod in modo che ci siano tre famiglie di enemy: boss,enemy e treasure
// avremo gli stessi tre livelli e all'interno dovranno essere creati dei enemy boss e trasure adeguati al livello
// la foresta avra enemy wolf, boss troll e treasure magicMushroom
// space avrà enemy alienSoldier, boss alienQueen e il critsallo di antimateria
// dungeon avrà enemy goblin, boss necromancer e treasure magicCoin
public class Start {
    public static void main(String[] args) {
        Level forest = new Level(new ForestLevelFactory());
        Level space = new Level(new SpaceLevelFactory());
        Level dungeon = new Level(new DungeonLevelFactory());

        IO.println("Forest: " + forest.describe());
        IO.println("Space: " + space.describe());
        IO.println("Dungeon: " + dungeon.describe());
    }
}
