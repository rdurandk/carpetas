package practicahilos;

public class NombreHilo extends Thread{
    public NombreHilo(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Se inicia el metodo del hilo " + this.getName());;
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(10);
                System.out.println(this.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Finaliza el hilo");
    }
}
