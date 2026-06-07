package org.generation.italy.examples.oo.mudPersonale.entities;

import org.generation.italy.examples.oo.mudPersonale.Inventory;
import org.generation.italy.examples.oo.mudPersonale.Map;
import org.generation.italy.examples.oo.mudPersonale.entities.pokemon.PokemonEntity;
import org.generation.italy.examples.oo.mudPersonale.enums.Direction;
import org.generation.italy.examples.oo.mudPersonale.enums.Pokemon;
import org.generation.italy.examples.oo.mudPersonale.items.Item;

import org.generation.italy.examples.oo.mudPersonale.rooms.EmptyRoom;
import org.generation.italy.examples.oo.mudPersonale.rooms.Room;

import java.util.ArrayList;

public class Player extends Entity {
    private int coins;
    private final Inventory inventory;
    private int currentY = 10;
    private int currentX = 10;
    private final ArrayList<PokemonEntity> pokemonEntities;

    public Player(String name, int coins, Inventory inventory) {
        super(name);
        this.coins = coins;
        this.inventory = inventory;
        this.pokemonEntities = new ArrayList<>();
        pokemonEntities.add(new PokemonEntity(Pokemon.PICHU,1));
    }

    @Override
    public void interact(Player player) {
        //scambio pokemon
        //combatti
    }

    public int getCoins(){
        return coins;
    }

    public boolean depositCoins(int coins){
        if(coins < 0){
            return false;
        }
        this.coins += coins;
        return true;
    }

    public boolean healPokemon(int healAmount){
        IO.println("Quale pokemon vuoi curare?");
        for(int i = 0; i < pokemonEntities.size(); i++){
            System.out.printf("(%s) %S \n", i, pokemonEntities.get(i).getName());
        }
        int input = Integer.parseInt(IO.readln("->"));
        if(input < pokemonEntities.size()){
            if(!pokemonEntities.get(input).heal(healAmount)){
                System.out.println(pokemonEntities.get(input).getName() + " ha già vita massima");
                return false;
            }
        }
        System.out.println(pokemonEntities.get(input).getName() + " ha recuperato " + healAmount + " vita");
        return true;
    }

    public void healAllPokemon(){
        for(PokemonEntity pokemon : pokemonEntities){
            pokemon.healMax();
        }
    }

    public void showPokemon(){
        IO.println("Quale pokemon vuoi selezionare?:");
        for(int i = 0; i < pokemonEntities.size(); i++){
            System.out.printf("(%s) %S \n", i, pokemonEntities.get(i).getName());
        }
        int input = Integer.parseInt(IO.readln("->"));
        if(input < pokemonEntities.size()){
            pokemonEntities.get(input).showStats();
        }
    }

    public boolean withdrawCoins(int amount){
        if(coins < amount){
            return false;
        }
        coins -= amount;
        return true;
    }

    public boolean pick(Item item){
        return inventory.add(item);
    }

    public void drop(Item item){
        inventory.remove(item);
    }

    public boolean showItems(){
        return inventory.showItems();
    }

    public Item findItem(int index){
        return inventory.findItem(index);
    }


    public double getInventoryWeight(){
        return inventory.getInventoryWeight();
    }

    public Room getCurrentRoom(Map map){
        return map.getRoom(currentY, currentX);
    }

    public void moveTo(Map map, Direction direction){
        switch(direction) {
            case Direction.NORTH:
                if(currentY - 1 < 0 || map.getRoom(currentY-1, currentX) instanceof EmptyRoom){
                    Room.showDeadEnd();
                    break;
                }
                if(map.getRoom(currentY - 1, currentX) == null){
                    Room room = Room.getRandomRoom();
                    map.setRoom(room, currentY - 1, currentX);
                }
                if(!(map.getRoom(currentY - 1, currentX) instanceof EmptyRoom)){
                    currentY--;
                    IO.println("Stai correndo...");
                }else{
                    Room.showDeadEnd();
                }
                break;
            case Direction.SOUTH:
                if(currentY + 1 >= 20 || map.getRoom(currentY + 1,currentX) instanceof EmptyRoom){
                    Room.showDeadEnd();
                    break;
                }
                if(map.getRoom(currentY + 1,currentX) == null){
                    Room room = Room.getRandomRoom();
                    map.setRoom(room,currentY + 1,currentX);

                }
                if(!(map.getRoom(currentY + 1,currentX) instanceof EmptyRoom)){
                    currentY++;
                    IO.println("Stai correndo...");
                }else{
                    Room.showDeadEnd();
                }
                break;
            case Direction.EAST:
                if(currentX + 1 >= 20 || map.getRoom(currentY,currentX + 1) instanceof EmptyRoom){
                    Room.showDeadEnd();
                    break;
                }
                if(map.getRoom(currentY,currentX + 1) == null){
                    Room room = Room.getRandomRoom();
                    map.setRoom(room,currentY,currentX + 1);

                }
                if(!(map.getRoom(currentY, currentX + 1) instanceof EmptyRoom)){
                    currentX++;
                    IO.println("Stai correndo...");
                }else{
                    Room.showDeadEnd();
                }
                break;
            case Direction.WEST:
                if(currentX - 1 < 0 || map.getRoom(currentY,currentX - 1) instanceof EmptyRoom){
                    Room.showDeadEnd();
                    break;
                }

                if(map.getRoom(currentY, currentX - 1) == null){
                    Room room = Room.getRandomRoom();
                    map.setRoom(room,currentY,currentX - 1);
                }
                if(!(map.getRoom(currentY,currentX - 1) instanceof EmptyRoom)){
                    currentX--;
                    IO.println("Stai correndo...");
                }else{
                    Room.showDeadEnd();
                }
                break;
            default:
                break;
        }
    }

    public void teleportToStart(){
        currentX = 10;
        currentY = 10;
    }


}
