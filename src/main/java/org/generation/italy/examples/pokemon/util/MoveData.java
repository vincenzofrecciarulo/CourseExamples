package org.generation.italy.examples.pokemon.util;

import org.generation.italy.examples.pokemon.model.*;

/** Singleton move templates. Each Pokémon calls .copy() to get its own PP-tracked instance. */
public class MoveData {

    // ─── Normal ─────────────────────────────────────────────────────────────
    public static final Move TACKLE       = new Move("Tackle",       PokemonType.NORMAL, 40, 100, 35, MoveCategory.PHYSICAL);
    public static final Move SCRATCH      = new Move("Scratch",      PokemonType.NORMAL, 40, 100, 35, MoveCategory.PHYSICAL);
    public static final Move QUICK_ATTACK = new Move("Quick Attack", PokemonType.NORMAL, 40, 100, 30, MoveCategory.PHYSICAL);
    public static final Move BODY_SLAM    = new Move("Body Slam",    PokemonType.NORMAL, 85, 100, 15, MoveCategory.PHYSICAL);
    public static final Move HYPER_BEAM   = new Move("Hyper Beam",   PokemonType.NORMAL, 150, 90,  5, MoveCategory.SPECIAL);
    public static final Move HYPER_FANG   = new Move("Hyper Fang",   PokemonType.NORMAL, 80,  90, 15, MoveCategory.PHYSICAL);
    public static final Move SLAM         = new Move("Slam",         PokemonType.NORMAL, 80,  75, 20, MoveCategory.PHYSICAL);
    public static final Move CUT          = new Move("Cut",          PokemonType.NORMAL, 50,  95, 30, MoveCategory.PHYSICAL);
    public static final Move SLASH        = new Move("Slash",        PokemonType.NORMAL, 70, 100, 20, MoveCategory.PHYSICAL);
    public static final Move BITE         = new Move("Bite",         PokemonType.NORMAL, 60, 100, 25, MoveCategory.PHYSICAL);
    // Status – Normal
    public static final Move GROWL        = new Move("Growl",        PokemonType.NORMAL,  0, 100, 40, MoveCategory.STATUS);
    public static final Move TAIL_WHIP    = new Move("Tail Whip",    PokemonType.NORMAL,  0, 100, 30, MoveCategory.STATUS);
    public static final Move LEER         = new Move("Leer",         PokemonType.NORMAL,  0, 100, 30, MoveCategory.STATUS);
    public static final Move DEFENSE_CURL = new Move("Defense Curl", PokemonType.NORMAL,  0, 100, 40, MoveCategory.STATUS);
    public static final Move AMNESIA      = new Move("Amnesia",      PokemonType.PSYCHIC,  0, 100, 20, MoveCategory.STATUS);

    // ─── Fire ───────────────────────────────────────────────────────────────
    public static final Move EMBER        = new Move("Ember",        PokemonType.FIRE,  40, 100, 25, MoveCategory.SPECIAL,  StatusEffect.BURN, 10);
    public static final Move FLAMETHROWER = new Move("Flamethrower", PokemonType.FIRE,  90, 100, 15, MoveCategory.SPECIAL,  StatusEffect.BURN, 10);
    public static final Move FIRE_BLAST   = new Move("Fire Blast",   PokemonType.FIRE, 110,  85,  5, MoveCategory.SPECIAL,  StatusEffect.BURN, 10);
    public static final Move FIRE_SPIN    = new Move("Fire Spin",    PokemonType.FIRE,  35,  85, 15, MoveCategory.SPECIAL);
    public static final Move WILL_O_WISP  = new Move("Will-O-Wisp", PokemonType.FIRE,   0,  85, 15, MoveCategory.STATUS,   StatusEffect.BURN, 100);

    // ─── Water ──────────────────────────────────────────────────────────────
    public static final Move WATER_GUN    = new Move("Water Gun",    PokemonType.WATER, 40, 100, 25, MoveCategory.SPECIAL);
    public static final Move BUBBLE       = new Move("Bubble",       PokemonType.WATER, 40, 100, 30, MoveCategory.SPECIAL);
    public static final Move SURF         = new Move("Surf",         PokemonType.WATER, 90, 100, 15, MoveCategory.SPECIAL);
    public static final Move HYDRO_PUMP   = new Move("Hydro Pump",   PokemonType.WATER,110,  80,  5, MoveCategory.SPECIAL);
    public static final Move WITHDRAW     = new Move("Withdraw",     PokemonType.WATER,  0, 100, 40, MoveCategory.STATUS);

    // ─── Grass ──────────────────────────────────────────────────────────────
    public static final Move VINE_WHIP    = new Move("Vine Whip",    PokemonType.GRASS, 45, 100, 25, MoveCategory.PHYSICAL);
    public static final Move RAZOR_LEAF   = new Move("Razor Leaf",   PokemonType.GRASS, 55,  95, 25, MoveCategory.PHYSICAL);
    public static final Move SOLAR_BEAM   = new Move("Solar Beam",   PokemonType.GRASS,120, 100, 10, MoveCategory.SPECIAL);
    public static final Move SLEEP_POWDER = new Move("Sleep Powder", PokemonType.GRASS,  0,  75, 15, MoveCategory.STATUS, StatusEffect.SLEEP,  100);
    public static final Move POISON_POWDER= new Move("Poison Powder",PokemonType.POISON, 0,  75, 35, MoveCategory.STATUS, StatusEffect.POISON, 100);

    // ─── Electric ───────────────────────────────────────────────────────────
    public static final Move THUNDER_SHOCK= new Move("Thunder Shock",PokemonType.ELECTRIC, 40, 100, 30, MoveCategory.SPECIAL, StatusEffect.PARALYSIS, 10);
    public static final Move THUNDERBOLT  = new Move("Thunderbolt",  PokemonType.ELECTRIC, 90, 100, 15, MoveCategory.SPECIAL, StatusEffect.PARALYSIS, 10);
    public static final Move THUNDER      = new Move("Thunder",      PokemonType.ELECTRIC,110,  70, 10, MoveCategory.SPECIAL, StatusEffect.PARALYSIS, 30);
    public static final Move THUNDER_WAVE = new Move("Thunder Wave", PokemonType.ELECTRIC,  0,  90, 20, MoveCategory.STATUS,  StatusEffect.PARALYSIS,100);

    // ─── Psychic ────────────────────────────────────────────────────────────
    public static final Move CONFUSION    = new Move("Confusion",    PokemonType.PSYCHIC, 50, 100, 25, MoveCategory.SPECIAL);
    public static final Move PSYCHIC_ATK  = new Move("Psychic",      PokemonType.PSYCHIC, 90, 100, 10, MoveCategory.SPECIAL);
    public static final Move HYPNOSIS     = new Move("Hypnosis",     PokemonType.PSYCHIC,  0,  60, 20, MoveCategory.STATUS, StatusEffect.SLEEP, 100);

    // ─── Bug ────────────────────────────────────────────────────────────────
    public static final Move STRING_SHOT  = new Move("String Shot",  PokemonType.BUG,  0,  95, 40, MoveCategory.STATUS);
    public static final Move BUG_BITE     = new Move("Bug Bite",     PokemonType.BUG, 60, 100, 20, MoveCategory.PHYSICAL);
    public static final Move LEECH_LIFE   = new Move("Leech Life",   PokemonType.BUG, 20, 100, 15, MoveCategory.PHYSICAL);

    // ─── Flying ─────────────────────────────────────────────────────────────
    public static final Move GUST         = new Move("Gust",         PokemonType.FLYING, 40, 100, 35, MoveCategory.SPECIAL);
    public static final Move WING_ATTACK  = new Move("Wing Attack",  PokemonType.FLYING, 60, 100, 35, MoveCategory.PHYSICAL);

    // ─── Rock / Ground ──────────────────────────────────────────────────────
    public static final Move ROCK_THROW   = new Move("Rock Throw",   PokemonType.ROCK,  50,  90, 15, MoveCategory.PHYSICAL);
    public static final Move ROCK_BLAST   = new Move("Rock Blast",   PokemonType.ROCK,  25,  90, 10, MoveCategory.PHYSICAL);
    public static final Move MAGNITUDE    = new Move("Magnitude",    PokemonType.GROUND, 70, 100, 30, MoveCategory.PHYSICAL);
    public static final Move EARTHQUAKE   = new Move("Earthquake",   PokemonType.GROUND,100, 100, 10, MoveCategory.PHYSICAL);

    // ─── Ghost / Poison ─────────────────────────────────────────────────────
    public static final Move LICK         = new Move("Lick",         PokemonType.GHOST, 30, 100, 30, MoveCategory.PHYSICAL, StatusEffect.PARALYSIS, 30);
    public static final Move SHADOW_BALL  = new Move("Shadow Ball",  PokemonType.GHOST, 80, 100, 15, MoveCategory.SPECIAL);
    public static final Move NIGHT_SHADE  = new Move("Night Shade",  PokemonType.GHOST, 50, 100, 15, MoveCategory.SPECIAL);
    public static final Move POISON_GAS   = new Move("Poison Gas",   PokemonType.POISON,  0,  90, 40, MoveCategory.STATUS, StatusEffect.POISON, 100);

    // ─── Ice ────────────────────────────────────────────────────────────────
    public static final Move ICE_BEAM     = new Move("Ice Beam",     PokemonType.ICE, 90, 100, 10, MoveCategory.SPECIAL);

    private MoveData() {}
}