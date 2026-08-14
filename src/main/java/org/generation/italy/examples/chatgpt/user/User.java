package org.generation.italy.examples.chatgpt.user;

public class User {
    private String name;
    private static int cont = 0;

    // COMPLETA TU LA CLASSE
    public User(String name) {
        this.name = name;
        cont += 1; // oppure "cont++"
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getTotalUsers (){
        return cont;
    }
}
