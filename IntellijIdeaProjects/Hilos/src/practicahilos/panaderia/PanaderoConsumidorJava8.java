package practicahilos.panaderia;

import java.util.concurrent.TimeUnit;

public class PanaderoConsumidorJava8 {
    public static void main(String[] args) {
        PanaderoConsumidor pc = new PanaderoConsumidor();
        Runnable run1 = ()->{
            for(int i=0;i<10;i++){
                pc.panadero("Pansiwo n°" + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable run2 = ()->{
            for(int i=0;i<10;i++){
                pc.consumidor();
            }
        };
        new Thread(run2).start();
        new Thread(run1).start();


    }
}
