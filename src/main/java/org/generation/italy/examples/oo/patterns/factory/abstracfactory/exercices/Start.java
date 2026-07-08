package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;
// Espandere l'esercizio del factorymethod in modo che ci siano tre famiglie di enemy: boss,enemy e treasure
// avremo gli stessi tre livelli e all'interno dovranno essere creati dei enemy boss e trasure adeguati al livello
// la foresta avra enemy wolf, boss troll e treasure magicMushroom
// space avrà enemy alienSoldier, boss alienQueen e il critsallo di antimateria
// dungeon avrà enemy goblin, boss necromancer e treasure magicCoin
public class Start {
    public static void main(String[] args) {
        IO.println("Benvenuto avventuriero! In quale livello vuoi andare?");
        IO.println("1. Foresta");
        IO.println("2. Spazio");
        IO.println("3. Dungeon");
        IO.print("Scegli (1-3): ");
        int choice = Integer.parseInt(IO.readln());

        Level level = null;
        do{switch (choice) {
            case 1:
                level = new ForestLevel();
                IO.println("\n=== FORESTA ===");
                break;
            case 2:
                level = new SpaceLevel();
                IO.println("\n=== SPAZIO ===");
                break;
            case 3:
                level = new DungeonLevel();
                IO.println("\n=== DUNGEON ===");
                break;
            default:
                IO.println("Scelta non valida!");
                return;
        }

        Entity enemy = level.createEnemy();
        Boss boss = level.createBoss();
        Treasure treasure = level.createTreasure();

        IO.println("Nemico: " + enemy.name());
        IO.println("Boss: " + boss.name());
        IO.println("Tesoro: " + treasure);

        IO.println("\nQuale azione vuoi eseguire?");
        IO.println("1. Ascolta il nemico");
        IO.println("2. Ascolta il boss");
        IO.println("3. Osserva il tesoro");
        IO.println("4. Attacca il nemico");
        IO.println("5. Attacca il boss");
        IO.print("Scegli azione (1-5): ");
        int action = Integer.parseInt(IO.readln());

        switch (action) {
            case 1:
                enemy.speak();
                break;
            case 2:
                boss.speak();
                break;
            case 3:
                treasure.observe();
                break;
            case 4:
                enemy.attack();
                break;
            case 5:
                boss.attack();
                break;
            default:
                IO.println("Azione non valida!");
                return ;
        }}while(true);
    }
}
