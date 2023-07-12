package org.rdurandk.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable{//subject
    protected List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void remover(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(Object obj){
        for(Observer obs:this.observers){
            obs.update(this, obj);
        }
    }
}
