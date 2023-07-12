package practicahilos;

public class EjemRunnableJava8 {
    public static void main(String[] args) {

        Runnable run1 = ()->{
            for(int i=0;i<10;i++){
                try{
                    Thread.sleep((long)Math.random()*100);
                    System.out.println(i + " - " + Thread.currentThread().getName());
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
            System.out.println("Me voy de viaje a: " + Thread.currentThread().getName());
            System.out.println("Estado: "+Thread.currentThread().getState());
        };

        new Thread(run1, "Alvaro").start();
        new Thread(run1, "Mari").start();
        new Thread(run1, "Mery").start();
        new Thread(run1, "Luz").start();

    }
}
