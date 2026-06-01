# Fantasy Text Adventure MUD - Game Guide

## Summary of Changes

### 1. **Unique IDs for Entities and Items**
- `Entity` class now has an auto-incrementing `id` (separate counter for all entities)
- `Item` class now has an auto-incrementing `id` (separate counter for all items)
- Each gets unique IDs starting from 1 and incrementing with each new instance
- Useful for students to understand object identity vs equality

### 2. **Prefix Matching for Commands**
When you use commands like `prendi` (take), `getta` (drop), `equipaggia` (equip), `parla` (talk), `attacca` (attack), you can now use **prefix matching** instead of exact names.

**What is prefix matching?**
- **Prefix match**: The text you type just needs to match the *beginning* of the command/item/entity name
- Example: `p scu` will match `Scudo di ferro` (because "scu" is the start of "scudo")
- Example: `at lup` will match `Lupo Solitario` (because "lup" is the start of "lupo")
- **Case-insensitive**: `P SCU` works just like `p scu`

**Why prefix matching?**
- Students don't need to type long exact names
- More forgiving and user-friendly
- Simulates how many real MUDs work

### 3. **Italian Commands with Shortcuts**

#### Movement
```
n / nord          → Move North
s / sud           → Move South
e / est           → Move East
o / ovest         → Move West
```

#### Items & Inventory
```
p / prendi <obj>      → Pick up an object
d / getta <obj>       → Drop an object
i / inventario        → Show inventory
eq / equipaggia <obj> → Equip an object
```

#### Interaction
```
pa / parla <entity>   → Talk to a character
at / attacca <entity> → Attack an enemy (5 damage per hit)
```

#### Other
```
g / guarda      → Look around (redisplay the room)
h / aiuto       → Show this help message
q / esci        → Exit the game
```

## Example Play Session

```
-> p man
Hai preso: Mela

-> i
Inventario: [Mela]

-> n
Ti muovi verso nord

Piazza del Tempio
Davanti al grande tempio, la piazza è calma. I devoti accendono candele.
Una scalinata maestosa conduce all'interno del santuario.
In questo luogo sono presenti: [Sacerdote Anziano]
Vedi i seguenti oggetti: [Amuleto della Dea]

-> p amu
Hai preso: Amuleto della Dea

-> eq amu
Equipaggiato!

-> n
Ti muovi verso nord

Armeria del Falco
Esposizione di armi e armature lucenti. Il proprietario affila le lame con cura.
In questo luogo sono presenti: [Mastro Armaiolo]
Vedi i seguenti oggetti: [Spada di Ferro, Scudo]

-> p spa
Hai preso: Spada di Ferro

-> eq spa
Equipaggiato!

-> o
Ti muovi verso ovest

Fucina Laterale
Una piccola fucina dove si riparano armi e armature. Il fuoco arde costante.
...

(Continue exploring! Try going north to Torrione di Guardia, then to Foresta Profonda)
```

## Map Overview

The world is organized as a vertical north-south axis with east-west branches:

```
                    Foresta Profonda (NORTH)
                    (Lupo Solitario, Pelle di Lupo)
                            |
                    Bordo della Foresta ---- Prato Fiorito (EAST)
                            |
                    Torrione di Guardia
                            |
    Fucina Laterale -- Armeria del Falco
    (WEST)           (Mastro Armaiolo)
                            |
    Forno (WEST) -- Piazza del Tempio -- Biblioteca (EAST)
                    (Sacerdote Anziano)   (Vecchio Saggio, Pergamena Antica)
                            |
    Taverna (WEST) -- Piazza del Mercato -- Molo (EAST)
                      (START)              (Capitano del Porto, Corda)
                      (Guardia del Mercato, Mela, Moneta)
                            |
                    Giardino della Città
                     (SOUTH - peaceful)
                            
From Molo going south:
                            |
                    Riva del Fiume
                            |
                    Ingresso della Caverna
                    (Vecchia Chiave)
                            |
                    Tana del Goblin (SOUTH - dangerous)
                    (Capo Goblin, Scrigno del Tesoro)
```

## Key NPCs and Loot

| Location | NPC | Item |
|----------|-----|------|
| Foresta Profonda | Lupo Solitario | Pelle di Lupo |
| Prato Fiorito | (none) | (none) |
| Torrione di Guardia | (none) | (none) |
| Armeria del Falco | Mastro Armaiolo | Spada di Ferro, Scudo |
| Fucina Laterale | (none) | (none) |
| Piazza del Tempio | Sacerdote Anziano | Amuleto della Dea |
| Biblioteca della Città | Vecchio Saggio, Apprendista | Pergamena Antica |
| Forno di Lieta | Fornaio | Pagnotta Calda, Fetta di Pane |
| Piazza del Mercato | Guardia del Mercato | Mela, Moneta |
| Taverna del Pugnale Rosso | Oste Burlone | Fiaschetta di vino |
| Molo | Capitano del Porto | Corda |
| Riva del Fiume | (none) | (none) |
| Ingresso della Caverna | (none) | Vecchia Chiave |
| Tana del Goblin | Capo Goblin | Scrigno del Tesoro |

## Code Structure for Students

### `Entity.java`
- Base class for any living creature (player and NPCs)
- Properties: `id`, `hp`, `name`, `level`
- Methods: `applyDamage()`, `getHp()`, `getId()`

### `Item.java`
- Represents any pickable object
- Properties: `id`, `weight`, `value`, `name`
- Each item is unique via `id`

### `Player.java` (extends Entity)
- Represents the player character
- `inventory`: List of items the player carries
- `equipped`: Currently equipped item
- Methods: `pickUp()`, `drop()`, `equip()`, `dropByPrefix()`, `equipByPrefix()`

### `Room.java`
- Represents a location in the world
- Contains items and entities (including other players and NPCs)
- Directions: NORTH, SOUTH, EAST, WEST (can link to other rooms)
- Methods: `findItemByPrefix()`, `findEntityByPrefix()`, `removeItemByName()`, etc.

### `World.java`
- Game initialization and main loop
- Constructs the entire map (rooms, NPCs, items, connections)
- `startGame()`: Main command loop

### `GameIO.java`
- Interface for input/output
- Allows decoupled I/O (console, network, testing, etc.)

### `ConsoleIO.java`
- Implementation of GameIO using Scanner and System.out

## Testing

Run tests to verify the system:
```bash
mvn test
```

Tests cover:
- Room mutators and player listing (`RoomTest.java`)
- Player inventory operations (`PlayerTest.java`)
- Prefix matching for items and entities
- Unique ID generation for items and entities

## Running the Game

```bash
mvn -q package
java -cp target/classes org.generation.italy.examples.oo.mud.MudMain
```

Or run directly from your IDE.

## Pedagogical Use

This MUD is designed as an incremental learning project:

1. **Week 1-2**: Explore existing code, play the game, understand OOP (Entity, Room, Item, Player)
2. **Week 3-4**: Students implement new commands or expand the map
3. **Week 5-6**: Add persistence (save/load)
4. **Week 7-8**: Add networking (multi-player support with sockets)
5. **Week 9-10**: Team project: implement quests, shops, advanced combat

## Next Improvements (for future development)

- [ ] Add an NPC dialog system (shop/quest givers)
- [ ] Implement combat system with equipment bonuses
- [ ] Add persistence (JSON save/load of player state)
- [ ] Networking support (ServerSocket-based multiplayer)
- [ ] Economy system (currency, buying/selling)
- [ ] Quest system
- [ ] Spell/magic system

