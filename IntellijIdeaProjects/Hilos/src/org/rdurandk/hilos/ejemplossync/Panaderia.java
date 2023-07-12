package org.rdurandk.hilos.ejemplossync;
public class Panaderia {
    private String pan;
    private boolean disponible;//por defecto false
    public synchronized void hornear(String masa){
        while(disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.pan = masa;
        System.out.println("Panadero hornea: " + this.pan);
        this.disponible = true;
        notify();//notifica si ya esta listo el proceso
    }
    public synchronized String consumir(){
        while(!disponible){
            try {
                wait();//espera hasta que sea notificado
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Cliente consume:" + this.pan);
        this.disponible = false;
        return pan;
    }
}
