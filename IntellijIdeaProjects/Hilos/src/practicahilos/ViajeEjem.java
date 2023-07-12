package practicahilos;

public class ViajeEjem implements Runnable{

    private String nombre;
    public ViajeEjem(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try{
                Thread.sleep((long)Math.random()*100);
                System.out.println(i + " - " + this.nombre);
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }
        System.out.println("Me voy de viaje a: " + this.nombre);
    }
}
