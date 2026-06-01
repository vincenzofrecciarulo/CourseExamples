package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;
import java.util.Random;

public class Room {
    private String title;
    private String description;
    private ArrayList<Entity> entities;
    private ArrayList<Item> items;

    private static final Random random = new Random();

    public Room(String title, String description, ArrayList<Entity> entities, ArrayList<Item> items) {
        this.title = title;
        this.description = description;
        this.entities = entities;
        this.items = items;
    }

    public void interact(Player player){
        String input = IO.readln("Vuoi interagire con un npc (1) o raccogliere degli oggetti (2) ?\n->");

        switch (input){
            case "1":
                showNpc();
                int index = Integer.parseInt(IO.readln("Inserisci l'npc con cui vuoi interagire\n->"));
                getEntity(index).interact(player);
                break;
            case "2":
                showItems();
                int index2 = Integer.parseInt(IO.readln("Inserisci l'oggetto che vuoi raccogliere\n->"));

                Item item = getItem(index2);
                if(!player.pick(item)){
                    break;
                }
                removeItem(item);
                IO.println("Hai raccolto " + item.getName());
                break;
            default:
                break;
        }
    }

    @Override
    public String toString(){
        return title;
    }

    public String showRoomInfo(){
        StringBuilder sb = new StringBuilder(this.title);
        sb.append("\n").append(this.description).append("\n")
                .append("In questo luogo sono presenti: ")
                .append(getEntityNames()).append("\n")
                .append("Vedi i seguenti oggetti: ")
                .append(getObjectNames());
        return sb.toString(); // ritorno la stringa che sta dentro lo StringBuilder
    }

    public ArrayList<String> getObjectNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Item i : items){
            names.add(i.getName());
        }
        return names;
    }

    public ArrayList<String> getEntityNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Entity e : entities){
            names.add(e.getName());
        }
        return names;
    }

    public void showItems(){
        IO.println("Oggetti che puoi raccogliere:");
        for(int i = 0; i < items.size(); i++){
            System.out.printf("(%s) %s \n", i, items.get(i).getName());
        }
    }

    public void showNpc(){
        IO.println("Npc nella stanza:");
        for(int i = 0; i < entities.size(); i++){
            System.out.printf("(%s) %s \n", i, entities.get(i).getName());
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Entity getEntity(int index){
        return entities.get(index);
    }

    public Item getItem(int index){
        return items.get(index);
    }

    public boolean removeItem(Item item){
        return items.remove(item);
    }

    public static Room getRandomRoom(){
        int num = random.nextInt(7);
        switch (num){
            case 0:
                return new MarketRoom();
            case 1:
                return new TempleRoom();
            case 2:
            case 3:
            case 4:
            case 5:
                return new DangerRoom();
            default:
                return new EmptyRoom();
        }
    }

    public static void showDeadEnd(){
        IO.println("""
                    Non c'è niente in quella direzione...
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                     🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
                    """);
    }

}
