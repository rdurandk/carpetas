public class SemaforoA implements Runnable{
    private String direccion1;
    private String direccion2;
    public SemaforoA(String direccion1, String direccion2){
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
    }
    @Override
    public void run() {
        try {

            for (int i=0;i<5;i++){
                Thread.sleep(1000);
                System.out.println("SemaforoA: " + this.direccion1);
                System.out.println("SemaforoA: " + this.direccion2);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
