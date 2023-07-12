package org.rdurandk.patrones.observer2;

import java.util.ArrayList;
import java.util.List;

public class ChatGrupal {//observable(subject)
    private String nombre;
    private List<Observer> observers = new ArrayList<>();
    public ChatGrupal(String nombre) {
        this.nombre = nombre;
    }

    public void addObserver(Observer user){
        this.observers.add(user);
    }
    public void sendMessage(String mensaje){
        for(Observer user:this.observers){
            user.update(mensaje);
        }
    }
}
