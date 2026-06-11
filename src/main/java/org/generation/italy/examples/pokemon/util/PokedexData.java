package org.generation.italy.examples.pokemon.util;

import org.generation.italy.examples.pokemon.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Hardcoded Generation-1 Pokédex data for all 24 species used in the game.
 * Each entry is a read-only template shared by all Pokémon instances.
 */
public class PokedexData {

    // ─── All 24 entries declared up-front (assigned in static block) ────────
    public static final PokedexEntry BULBASAUR;
    public static final PokedexEntry IVYSAUR;
    public static final PokedexEntry VENUSAUR;
    public static final PokedexEntry CHARMANDER;
    public static final PokedexEntry CHARMELEON;
    public static final PokedexEntry CHARIZARD;
    public static final PokedexEntry SQUIRTLE;
    public static final PokedexEntry WARTORTLE;
    public static final PokedexEntry BLASTOISE;
    public static final PokedexEntry CATERPIE;
    public static final PokedexEntry BUTTERFREE;
    public static final PokedexEntry PIDGEY;
    public static final PokedexEntry PIDGEOTTO;
    public static final PokedexEntry PIDGEOT;
    public static final PokedexEntry RATTATA;
    public static final PokedexEntry RATICATE;
    public static final PokedexEntry PIKACHU;
    public static final PokedexEntry RAICHU;
    public static final PokedexEntry GEODUDE;
    public static final PokedexEntry GRAVELER;
    public static final PokedexEntry GASTLY;
    public static final PokedexEntry HAUNTER;
    public static final PokedexEntry GENGAR;
    public static final PokedexEntry SNORLAX;
    public static final PokedexEntry MEWTWO;

    static {
        BULBASAUR = entry(1, "Bulbasaur",
            types(PokemonType.GRASS, PokemonType.POISON),
            stats(45, 49, 49, 65, 65, 45),
            ls( 1, MoveData.TACKLE,  1, MoveData.GROWL,  7, MoveData.VINE_WHIP,
               13, MoveData.POISON_POWDER, 20, MoveData.RAZOR_LEAF,
               29, MoveData.SLEEP_POWDER, 41, MoveData.SOLAR_BEAM),
            16, 2,
            "A strange seed was planted on its back at birth. It sprouts and grows with this Pokémon.",
            45, 64);

        IVYSAUR = entry(2, "Ivysaur",
            types(PokemonType.GRASS, PokemonType.POISON),
            stats(60, 62, 63, 80, 80, 60),
            ls( 1, MoveData.TACKLE,  1, MoveData.GROWL,  1, MoveData.VINE_WHIP,
               22, MoveData.POISON_POWDER, 22, MoveData.RAZOR_LEAF,
               30, MoveData.SLEEP_POWDER, 43, MoveData.SOLAR_BEAM),
            32, 3,
            "When the bud on its back starts swelling, a sweet aroma wafts indicating the flower will soon bloom.",
            45, 141);

        VENUSAUR = entry(3, "Venusaur",
            types(PokemonType.GRASS, PokemonType.POISON),
            stats(80, 82, 83, 100, 100, 80),
            ls( 1, MoveData.TACKLE,  1, MoveData.GROWL,  1, MoveData.VINE_WHIP,
                1, MoveData.RAZOR_LEAF,
               32, MoveData.SLEEP_POWDER, 45, MoveData.SOLAR_BEAM, 53, MoveData.BODY_SLAM),
            -1, -1,
            "The flower on its back catches the sun's rays. Solar energy is converted into nutrition.",
            45, 208);

        CHARMANDER = entry(4, "Charmander",
            types(PokemonType.FIRE),
            stats(39, 52, 43, 60, 50, 65),
            ls( 1, MoveData.SCRATCH,  1, MoveData.GROWL,  9, MoveData.EMBER,
               15, MoveData.LEER, 22, MoveData.SLASH, 30, MoveData.FLAMETHROWER,
               38, MoveData.FIRE_SPIN),
            16, 5,
            "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.",
            45, 62);

        CHARMELEON = entry(5, "Charmeleon",
            types(PokemonType.FIRE),
            stats(58, 64, 58, 80, 65, 80),
            ls( 1, MoveData.SCRATCH,  1, MoveData.GROWL,  1, MoveData.EMBER,
               24, MoveData.SLASH, 33, MoveData.FLAMETHROWER, 46, MoveData.FIRE_SPIN,
               50, MoveData.FIRE_BLAST),
            36, 6,
            "When it swings its burning tail, it elevates the temperature to unbearably high levels.",
            45, 142);

        CHARIZARD = entry(6, "Charizard",
            types(PokemonType.FIRE, PokemonType.FLYING),
            stats(78, 84, 78, 109, 85, 100),
            ls( 1, MoveData.SCRATCH,  1, MoveData.GROWL,  1, MoveData.EMBER,  1, MoveData.LEER,
               36, MoveData.SLASH, 46, MoveData.FLAMETHROWER, 55, MoveData.FIRE_BLAST,
               60, MoveData.WING_ATTACK),
            -1, -1,
            "A powerful flame burns from its mouth. It is said the flame burns so hot it can melt boulders.",
            45, 209);

        SQUIRTLE = entry(7, "Squirtle",
            types(PokemonType.WATER),
            stats(44, 48, 65, 50, 64, 43),
            ls( 1, MoveData.TACKLE,  1, MoveData.TAIL_WHIP,  7, MoveData.BUBBLE,
               13, MoveData.WATER_GUN, 22, MoveData.BITE, 28, MoveData.WITHDRAW,
               33, MoveData.SLAM, 40, MoveData.HYDRO_PUMP),
            16, 8,
            "After birth, its back swells and hardens into a shell. It powerfully sprays foam from its mouth.",
            45, 63);

        WARTORTLE = entry(8, "Wartortle",
            types(PokemonType.WATER),
            stats(59, 63, 80, 65, 80, 58),
            ls( 1, MoveData.TACKLE,  1, MoveData.TAIL_WHIP,  1, MoveData.BUBBLE,
                1, MoveData.WATER_GUN, 24, MoveData.BITE, 32, MoveData.WITHDRAW,
               37, MoveData.BODY_SLAM, 44, MoveData.HYDRO_PUMP),
            36, 9,
            "Often hides in water to stalk prey. It moves its ears to maintain balance while swimming fast.",
            45, 143);

        BLASTOISE = entry(9, "Blastoise",
            types(PokemonType.WATER),
            stats(79, 83, 100, 85, 105, 78),
            ls( 1, MoveData.TACKLE,  1, MoveData.TAIL_WHIP,  1, MoveData.BUBBLE,
                1, MoveData.WATER_GUN, 28, MoveData.WITHDRAW,
               38, MoveData.BODY_SLAM, 44, MoveData.SURF, 52, MoveData.HYDRO_PUMP),
            -1, -1,
            "A brutal Pokémon with pressurized water jets on its shell. They are used for high-speed tackles.",
            45, 210);

        CATERPIE = entry(10, "Caterpie",
            types(PokemonType.BUG),
            stats(45, 30, 35, 20, 20, 45),
            ls( 1, MoveData.TACKLE,  1, MoveData.STRING_SHOT),
            10, 12,
            "Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls.",
            255, 39);

        BUTTERFREE = entry(12, "Butterfree",
            types(PokemonType.BUG, PokemonType.FLYING),
            stats(60, 45, 50, 90, 80, 70),
            ls( 1, MoveData.CONFUSION,  1, MoveData.TACKLE,
               12, MoveData.SLEEP_POWDER, 15, MoveData.POISON_POWDER,
               24, MoveData.GUST, 27, MoveData.BUG_BITE, 32, MoveData.WING_ATTACK),
            -1, -1,
            "In battle, it flaps its wings at great speed to release highly toxic dust into the air.",
            45, 160);

        PIDGEY = entry(16, "Pidgey",
            types(PokemonType.NORMAL, PokemonType.FLYING),
            stats(40, 45, 40, 35, 35, 56),
            ls( 1, MoveData.TACKLE,  1, MoveData.GROWL,
                9, MoveData.QUICK_ATTACK, 25, MoveData.WING_ATTACK, 28, MoveData.GUST),
            18, 17,
            "A common sight in forests and woods. It flaps its wings at ground level to kick up blinding sand.",
            255, 55);

        PIDGEOTTO = entry(17, "Pidgeotto",
            types(PokemonType.NORMAL, PokemonType.FLYING),
            stats(63, 60, 55, 50, 50, 71),
            ls( 1, MoveData.TACKLE,  1, MoveData.GROWL,  1, MoveData.QUICK_ATTACK,
               22, MoveData.WING_ATTACK, 31, MoveData.GUST, 40, MoveData.HYPER_BEAM),
            36, 18,
            "Very protective of its sprawling territory, this Pokémon fiercely pecks any intruder.",
            45, 113);

        PIDGEOT = entry(18, "Pidgeot",
            types(PokemonType.NORMAL, PokemonType.FLYING),
            stats(83, 80, 75, 70, 70, 101),
            ls( 1, MoveData.TACKLE,  1, MoveData.GROWL,  1, MoveData.QUICK_ATTACK,
                1, MoveData.WING_ATTACK, 44, MoveData.GUST, 54, MoveData.HYPER_BEAM),
            -1, -1,
            "When hunting, it skims the surface of water at high speed to pick off unwary prey such as Magikarp.",
            45, 172);

        RATTATA = entry(19, "Rattata",
            types(PokemonType.NORMAL),
            stats(30, 56, 35, 25, 35, 72),
            ls( 1, MoveData.TACKLE,  1, MoveData.TAIL_WHIP,
                7, MoveData.QUICK_ATTACK, 14, MoveData.HYPER_FANG,
               23, MoveData.LEER, 34, MoveData.BODY_SLAM),
            20, 20,
            "Will chew on anything with its fangs. If you see one, 40 more are living in the area.",
            255, 57);

        RATICATE = entry(20, "Raticate",
            types(PokemonType.NORMAL),
            stats(55, 81, 60, 50, 70, 97),
            ls( 1, MoveData.TACKLE,  1, MoveData.TAIL_WHIP,  1, MoveData.QUICK_ATTACK,
                1, MoveData.HYPER_FANG, 28, MoveData.LEER, 38, MoveData.BODY_SLAM,
               50, MoveData.HYPER_BEAM),
            -1, -1,
            "It uses its whiskers to maintain balance. It apparently slows down if they are cut off.",
            127, 116);

        PIKACHU = entry(25, "Pikachu",
            types(PokemonType.ELECTRIC),
            stats(35, 55, 40, 50, 50, 90),
            ls( 1, MoveData.THUNDER_SHOCK,  1, MoveData.TAIL_WHIP,
                9, MoveData.QUICK_ATTACK, 20, MoveData.THUNDER_WAVE,
               26, MoveData.THUNDERBOLT, 33, MoveData.THUNDER),
            25, 26,
            "Whenever Pikachu comes across something new, it blasts it with a jolt of electricity.",
            190, 82);

        RAICHU = entry(26, "Raichu",
            types(PokemonType.ELECTRIC),
            stats(60, 90, 55, 90, 80, 110),
            ls( 1, MoveData.THUNDER_SHOCK,  1, MoveData.TAIL_WHIP,
                1, MoveData.QUICK_ATTACK,   1, MoveData.THUNDER_WAVE,
               36, MoveData.THUNDERBOLT, 45, MoveData.THUNDER),
            -1, -1,
            "Its long tail serves as a lightning rod so that lightning strikes only the tail and not its body.",
            75, 122);

        GEODUDE = entry(74, "Geodude",
            types(PokemonType.ROCK, PokemonType.GROUND),
            stats(40, 80, 100, 30, 30, 20),
            ls( 1, MoveData.TACKLE,  1, MoveData.DEFENSE_CURL,
               11, MoveData.ROCK_THROW, 16, MoveData.MAGNITUDE,
               21, MoveData.ROCK_BLAST, 29, MoveData.EARTHQUAKE),
            25, 75,
            "Found in fields and mountains. Mistaking them for boulders, people often step on them.",
            255, 73);

        GRAVELER = entry(75, "Graveler",
            types(PokemonType.ROCK, PokemonType.GROUND),
            stats(55, 95, 115, 45, 45, 35),
            ls( 1, MoveData.TACKLE,  1, MoveData.DEFENSE_CURL,  1, MoveData.ROCK_THROW,
                1, MoveData.MAGNITUDE, 26, MoveData.ROCK_BLAST,
               36, MoveData.EARTHQUAKE, 48, MoveData.BODY_SLAM),
            -1, -1,
            "Rolls down slopes to move. It rolls over any obstacle without slowing or changing direction.",
            120, 134);

        GASTLY = entry(92, "Gastly",
            types(PokemonType.GHOST, PokemonType.POISON),
            stats(30, 35, 30, 100, 35, 80),
            ls( 1, MoveData.LICK,  1, MoveData.HYPNOSIS,
               27, MoveData.NIGHT_SHADE, 35, MoveData.POISON_GAS,
               38, MoveData.SHADOW_BALL),
            25, 93,
            "Almost invisible, this gaseous Pokémon cloaks the target and puts it to sleep without notice.",
            190, 95);

        HAUNTER = entry(93, "Haunter",
            types(PokemonType.GHOST, PokemonType.POISON),
            stats(45, 50, 45, 115, 55, 95),
            ls( 1, MoveData.LICK,  1, MoveData.HYPNOSIS,  1, MoveData.NIGHT_SHADE,
               29, MoveData.POISON_GAS, 38, MoveData.SHADOW_BALL,
               48, MoveData.PSYCHIC_ATK),
            38, 94,
            "Because of its ability to slip through block walls, it is said to be from another dimension.",
            90, 126);

        GENGAR = entry(94, "Gengar",
            types(PokemonType.GHOST, PokemonType.POISON),
            stats(60, 65, 60, 130, 75, 110),
            ls( 1, MoveData.LICK,  1, MoveData.HYPNOSIS,  1, MoveData.SHADOW_BALL,
                1, MoveData.POISON_GAS, 40, MoveData.PSYCHIC_ATK,
               50, MoveData.NIGHT_SHADE),
            -1, -1,
            "Under a full moon, this Pokémon likes to mimic the shadows of people and laugh at their fright.",
            45, 190);

        SNORLAX = entry(143, "Snorlax",
            types(PokemonType.NORMAL),
            stats(160, 110, 65, 65, 110, 30),
            ls( 1, MoveData.TACKLE,  1, MoveData.DEFENSE_CURL,  1, MoveData.AMNESIA,
               35, MoveData.BODY_SLAM, 54, MoveData.HYPER_BEAM),
            -1, -1,
            "Very lazy. Just eats and sleeps. As its rotund bulk builds, it becomes steadily more slothful.",
            25, 154);

        MEWTWO = entry(150, "Mewtwo",
            types(PokemonType.PSYCHIC),
            stats(106, 110, 90, 154, 90, 130),
            ls( 1, MoveData.CONFUSION,  1, MoveData.LEER,
               16, MoveData.PSYCHIC_ATK, 20, MoveData.SHADOW_BALL,
               30, MoveData.ICE_BEAM,   40, MoveData.HYPER_BEAM),
            -1, -1,
            "A Pokémon created by genetic manipulation. Even science cannot fully explain its origin.",
            3, 220);
    }

    // ─── Private builder helpers ─────────────────────────────────────────────

    private static PokedexEntry entry(int num, String name, PokemonType[] types, BaseStats stats,
                                      List<PokedexEntry.LearnEntry> ls, int evoLvl, int evoNum,
                                      String desc, int catchRate, int xpYield) {
        return new PokedexEntry(num, name, types, stats, ls, evoLvl, evoNum, desc, catchRate, xpYield);
    }

    private static PokemonType[] types(PokemonType... t) { return t; }

    private static BaseStats stats(int hp, int atk, int def, int spa, int spd, int spe) {
        return new BaseStats(hp, atk, def, spa, spd, spe);
    }

    /** Builds a learnset from interleaved (level, Move, level, Move, …) varargs. */
    private static List<PokedexEntry.LearnEntry> ls(Object... pairs) {
        List<PokedexEntry.LearnEntry> list = new ArrayList<>();
        for (int i = 0; i + 1 < pairs.length; i += 2) {
            list.add(new PokedexEntry.LearnEntry((Integer) pairs[i], (Move) pairs[i + 1]));
        }
        return list;
    }

    private PokedexData() {}
}