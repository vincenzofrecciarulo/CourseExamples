package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import com.generation.library.*;

public class Combat {

    // Risultato del combattimento
    public enum Result {
        VICTORY, DEFEAT, FLED
    }

    private Player player;
    private Room room;

    public Combat(Player player, Room room) {
        this.player = player;
        this.room = room;
    }

    /**
     * Avvia il combattimento con tutti i mostri vivi nella stanza,
     * uno alla volta. Se il giocatore muore o fugge, si ferma.
     */
    public Result startCombat() {
        ArrayList<Monster> monsters = room.getMonsters();

        for (Monster monster : monsters) {
            Result result = fightMonster(monster);
            if (result == Result.DEFEAT) return Result.DEFEAT;
            if (result == Result.FLED)   return Result.FLED;
        }
        room.removeDeadMonsters();
        return Result.VICTORY;
    }

    /**
     * Combattimento a turni contro un singolo mostro.
     */
    private Result fightMonster(Monster monster) {
        IO.println("\n  Combattimento iniziato contro: " + monster.getName() +
                " [" + monster.getRarity() + "] Liv." + monster.getLevel());
        IO.println("────────────────────────────────────────");

        while (player.isAlive() && monster.isAlive()) {
            printStatus(monster);

            IO.println("\nCosa fai?");
            IO.println("  1 - Attacca");
            IO.println("  2 - Usa oggetto");
            IO.println("  3 - Fuggi");

            int scelta = Console.readInt();

            switch (scelta) {
                case 1:
                    turnoAttacco(monster);
                    break;
                case 2:
                    turnoUsoOggetto();
                    if (monster.isAlive()) turnoMostro(monster);
                    break;
                case 3:
                    if (tentaFuga()) return Result.FLED;
                    // fuga fallita: il mostro attacca
                    turnoMostro(monster);
                    break;
                default:
                    IO.println("Comando non valido, perdi il turno!");
                    turnoMostro(monster);
            }
        }

        if (!player.isAlive()) {
            IO.println("\n Sei stato sconfitto da " + monster.getName() + "...");
            return Result.DEFEAT;
        }

        // Mostro sconfitto
        onMonsterDefeated(monster);
        return Result.VICTORY;
    }

    // ── Turno giocatore

    private void turnoAttacco(Monster monster) {
        int dannoBase = calcolaAttaccoGiocatore();
        int dannoInflitto = monster.takeDamage(dannoBase);
        IO.println("  Attacchi " + monster.getName() + " per " + dannoInflitto + " danni!");
        if (monster.isAlive()) {
            IO.println("   " + monster.getName() + ": " + monster.getHpBar());
            turnoMostro(monster);
        }
    }

    private void turnoUsoOggetto() {
        ArrayList<Item> inv = player.getInventory();
        if (inv.isEmpty()) {
            IO.println("Non hai oggetti da usare!");
            return;
        }
        // mostra solo consumabili
        ArrayList<Integer> indiciConsumabili = new ArrayList<>();
        IO.println("── Consumabili ─────────────────────────");
        for (int i = 0; i < inv.size(); i++) {
            if (inv.get(i) instanceof Consumable) {
                IO.println("  " + i + ". " + inv.get(i).getName());
                indiciConsumabili.add(i);
            }
        }
        if (indiciConsumabili.isEmpty()) {
            IO.println("Nessun consumabile disponibile!");
            return;
        }
        IO.println("Scegli (o -1 per annullare):");
        int idx = Console.readInt();
        if (idx < 0 || idx >= inv.size() || !(inv.get(idx) instanceof Consumable)) {
            IO.println("Scelta non valida.");
            return;
        }
        player.useItem(inv.get(idx));
    }

    private boolean tentaFuga() {
        // 50% di probabilità di fuga
        boolean fuggito = Math.random() < 0.5;
        if (fuggito) {
            IO.println(" Sei riuscito a fuggire!");
        } else {
            IO.println(" Non sei riuscito a fuggire!");
        }
        return fuggito;
    }

    // ── Turno mostro ─────────────────────────────────────────────────────────

    private void turnoMostro(Monster monster) {
        int dannoMostro = monster.attack();
        int difesaGiocatore = player.getTotalDefense();
        int dannoEffettivo = Math.max(1, dannoMostro - difesaGiocatore);
        player.setCurrentHp(player.getCurrentHp() - dannoEffettivo);

        IO.println("🐾 " + monster.getName() + " ti attacca per " + dannoEffettivo + " danni!" +
                (difesaGiocatore > 0 ? " (armatura ha assorbito " + (dannoMostro - dannoEffettivo) + ")" : ""));
        IO.println("   Tu: " + player.getHpBar());
    }

    // ── Ricompensa ───────────────────────────────────────────────────────────

    private void onMonsterDefeated(Monster monster) {
        IO.println("\n Hai sconfitto " + monster.getName() + "!");
        IO.println("   +" + monster.getExpReward() + " EXP  |  +" + monster.getGoldReward() + " oro");
        // future espansioni: player.addExp(...), player.addGold(...)
    }

    // ── Calcolo attacco giocatore (base 10 + livello, in futuro armi)

    private int calcolaAttaccoGiocatore() {
        return 10 + player.getLevel() * 2;
    }

    // ── Stampa stato combattimento

    private void printStatus(Monster monster) {
        IO.println("\n── Stato ───────────────────────────────");
        IO.println("  Tu      : " + player.getHpBar());
        IO.println("  " + monster.getName() + ": " + monster.getHpBar());
        IO.println("────────────────────────────────────────");
    }
}
