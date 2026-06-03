package org.generation.italy.examples.oo.mudMio;

public class Consumable extends Item {

    public enum Effect {
        HEAL,       // ripristina HP
        ANTIDOTE,   // rimuove veleno (per ora stampa messaggio, pronto per futuri status)
        BOOST_ATK   // bonus temporaneo attacco (pronto per futuri combattimenti)
    }

    private Effect effect;
    private int power; // entità dell'effetto (es. quanti HP cura)
    private int quantity;

    public Consumable(double weight, int value, String name, Effect effect, int power, int quantity) {
        super(weight, value, name);
        this.effect = effect;
        this.power = power;
        this.quantity = quantity;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getPower() {
        return power;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static Consumable pozioneCura(int quantity) {
        return new Consumable(0.5, 20, "Pozione di Cura", Effect.HEAL, 30, quantity);
    }

    /**
     * Applica l'effetto al giocatore e consuma l'oggetto dall'inventario.
     * Ritorna true se l'uso ha avuto effetto.
     */
    public boolean use(Player player) {
        switch (effect) {
            case HEAL:
                int hpPrima = player.getCurrentHp();
                int hpDopo = Math.min(player.getMaxHp(), hpPrima + power);
                player.setCurrentHp(hpDopo);
                int curati = hpDopo - hpPrima;
                if (curati == 0) {
                    IO.println("Hai già la vita al massimo! La " + getName() + " non ha effetto.");
                    return false;
                }
                IO.println("Usi " + getName() + " e recuperi " + curati + " HP! " + player.getHpBar());
                break;

            case ANTIDOTE:
                IO.println("Usi " + getName() + " — il veleno svanisce dal tuo corpo!");
                // in futuro: player.removeStatus(Status.POISON)
                break;

            case BOOST_ATK:
                IO.println("Usi " + getName() + " — ti senti più forte per qualche istante!");
                // in futuro: player.addTemporaryBonus(...)
                break;
        }
        quantity--;
        if (quantity <= 0) {
            player.getInventory().remove(this);
        }
        return true;
    }


    @Override
    public String toString() {
        return String.format("%s (consumabile, effetto: %s +%d)", getName(), effect, power);
    }

    // ---------------------------------------------------------------
    // Factory
    // ---------------------------------------------------------------

   public static Consumable pozioneCura() {
        return new Consumable(0.3, 10, "Pozione di Cura", Effect.HEAL, 10, 1);
   }

    public static Consumable bendaSacra() {
        return new Consumable(0.3, 15, "Benda Sacra", Effect.HEAL, 15, 1);
    }

    public static Consumable antidoto() {
        return new Consumable(0.3, 18, "Antidoto", Effect.ANTIDOTE, 0, 1);
    }

    public static Consumable fungoVelenoso() {
        return new Consumable(0.2, 5, "Fungo Velenoso", Effect.HEAL, 5, 1);
    }

    public static Consumable elisirForza() {
        return new Consumable(0.5, 80, "Elisir di Forza", Effect.BOOST_ATK, 20, 1);
    }
}
