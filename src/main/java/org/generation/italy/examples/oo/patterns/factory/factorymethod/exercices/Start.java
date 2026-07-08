package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

import java.util.ArrayList;
import java.util.List;

// assumendo di avere una classe Enemy e tre ambienti Forest, Space e Dungeon
// e tre implementazioni di enemy per questi tre ambienti che saranno wolf per la forest, alien per space e goblin per dungeon
// i tre ambienti saranno tre casi particolari di Level e ogni level deve essere inm grado di creare enemies per il suo
// ambiente in maniera polimorfica
// la classe level dovrà avere dei metodi per poter attaccare l'enemy
public class Start {
    static List<Level> levels= new ArrayList<>();

    static void main() {
        levels=List.of(new Forest(), new Space(), new Dungeon());
        levels.forEach(level -> {;
            level.spawnEnemy();
            level.attackEnemy();
            level.talkToEnemy();
        });
    }

}
