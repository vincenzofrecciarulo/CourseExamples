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
            Result result = fightFightable(monster);
            if (result == Result.DEFEAT) return Result.DEFEAT;
            if (result == Result.FLED)   return Result.FLED;
        }
        room.removeDeadMonsters();
        return Result.VICTORY;
    }

    /**
     * Avvia il combattimento contro un singolo NPC (provocato durante conversazione).
     * Al termine rimuove l'NPC dalla stanza se sconfitto.
     */
    public Result startCombat(NPC npc) {
        Result result = fightFightable(npc);
        if (result == Result.VICTORY) {
            room.removeEntity(npc);
        }
        return result;
    }

    /**
     * Logica a turni condivisa tra Monster e NPC — lavora su Fightable.
     */
    private Result fightFightable(Fightable enemy) {
        IO.println("\n  Combattimento iniziato contro: " + enemy.getName());
        IO.println("────────────────────────────────────────");

        while (player.isAlive() && enemy.isAlive()) {
            printStatus(enemy);

            IO.println("\nCosa fai?");
            IO.println("  1 - Attacca");
            IO.println("  2 - Usa oggetto");
            IO.println("  3 - Fuggi");

            int scelta = Console.readInt();

            switch (scelta) {
                case 1:
                    turnoAttacco(enemy);
                    break;
                case 2:
                    turnoUsoOggetto();
                    if (enemy.isAlive()) turnoNemico(enemy);
                    break;
                case 3:
                    if (tentaFuga()) return Result.FLED;
                    turnoNemico(enemy);
                    break;
                default:
                    IO.println("Comando non valido, perdi il turno!");
                    turnoNemico(enemy);
            }
        }

        if (!player.isAlive()) {
            IO.println("\n Sei stato sconfitto da " + enemy.getName() + "...");
            return Result.DEFEAT;
        }

        onEnemyDefeated(enemy);
        return Result.VICTORY;
    }

    // ── Turno giocatore ───────────────────────────────────────────────────────

    private void turnoAttacco(Fightable enemy) {
        int dannoBase = calcolaAttaccoGiocatore();
        int attaccoGiocatore = player.getTotalPower();
        int dannoInflitto = enemy.takeDamage(dannoBase + attaccoGiocatore);
        IO.println("  Attacchi " + enemy.getName() + " per " + dannoInflitto + " danni!");
        if (enemy.isAlive()) {
            IO.println("   " + enemy.getName() + ": " + enemy.getCurrentHp() + " HP");
            turnoNemico(enemy);
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
        boolean fuggito = Math.random() < 0.5;
        if (fuggito) {
            IO.println(" Sei riuscito a fuggire!");
        } else {
            IO.println(" Non sei riuscito a fuggire!");
        }
        return fuggito;
    }

    // ── Turno nemico (Monster o NPC) ─────────────────────────────────────────

    private void turnoNemico(Fightable enemy) {
        int dannoNemico = enemy.attack();
        int difesaGiocatore = player.getTotalDefense();
        int dannoEffettivo = Math.max(1, dannoNemico - difesaGiocatore);
        player.setCurrentHp(player.getCurrentHp() - dannoEffettivo);

        IO.println("⚔ " + enemy.getName() + " ti attacca per " + dannoEffettivo + " danni!" +
                (difesaGiocatore > 0 ? " (armatura ha assorbito " + (dannoNemico - dannoEffettivo) + ")" : ""));
        IO.println("   Tu: " + player.getHpBar());
    }

    // ── Ricompensa ───────────────────────────────────────────────────────────

    private void onEnemyDefeated(Fightable enemy) {
        IO.println("\n Hai sconfitto " + enemy.getName() + "!");
        IO.println("   +" + enemy.getExpReward() + " EXP  |  +" + enemy.getGoldReward() + " oro");
        player.gainExp(enemy.getExpReward());
        player.gainGold(enemy.getGoldReward());
    }

    // ── Calcolo attacco giocatore ─────────────────────────────────────────────

    private int calcolaAttaccoGiocatore() {
        return 10 + player.getLevel() * 2;
    }

    // ── Stampa stato combattimento ────────────────────────────────────────────

    private void printStatus(Fightable enemy) {
        IO.println("\n── Stato ───────────────────────────────");
        IO.println("  Tu      : " + player.getHpBar());
        IO.println("  " + enemy.getName() + ": " + enemy.getCurrentHp() + " HP");
        IO.println("────────────────────────────────────────");
    }
}
