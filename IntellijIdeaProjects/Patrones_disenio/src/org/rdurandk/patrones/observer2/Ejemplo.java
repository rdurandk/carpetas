package org.rdurandk.patrones.observer2;

public class Ejemplo {
    public static void main(String[] args) {
        Usuario user = new Usuario("Alex");
        Usuario user2 = new Usuario("Abel");
        Usuario user3 = new Usuario("Ana");
        Usuario user4 = new Usuario("Jasmin");
        ChatGrupal chatG = new ChatGrupal("Grupo 2 - 'Ing de Software'");
        chatG.addObserver(user);
        chatG.addObserver(user2);
        chatG.addObserver(user3);
        chatG.addObserver(user4);
        chatG.sendMessage("Hola a todos como estais");
    }
}
