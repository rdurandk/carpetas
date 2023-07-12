package practicahilos.panaderia;

public class PanaderoConsumidor  {
    private String producto;
    private boolean listo=false;//false

    public synchronized void panadero(String masa) {
        while(listo){
            try{
                wait();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        producto = masa;

        System.out.println("Panadero hornea " + this.producto);
        listo = true;
        notify();
    }

    public synchronized void consumidor(){
        while(!listo){
            try{
                wait();
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }

        System.out.println("Consumidor consume el " + this.producto);
        listo = false;
        notify();
    }
}
