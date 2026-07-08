package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;
// assumendo di avere una classe Enemy e tre ambienti Forest, Space e Dungeon
// e tre implementazioni di enemy per questi tre ambienti che saranno wolf per la forest, alien per space e goblin per dungeon
// i tre ambienti saranno tre casi particolari di Level e ogni level deve essere inm grado di creare enemies per il suo ambiente in maniera polimorfica
// la classe level dovrà avere dei metodi per poter attaccare l'enemy
public class Start {
    public static void main(String[] args) {
        Level forest = new Forest();
        Level space = new Space();
        Level dungeon = new Dungeon();

        forest.play();
        space.play();
        dungeon.play();
    }
}
