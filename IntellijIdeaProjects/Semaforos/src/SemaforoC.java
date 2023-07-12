public class SemaforoC implements Runnable{
    private String direccion1;
    public SemaforoC(String direccion1){
        this.direccion1 = direccion1;
    }

    @Override
    public void run() {
        try {
            for (int i=0;i<5;i++){
                Thread.sleep(1000);
                System.out.println("Semaforo C: " + this.direccion1);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
