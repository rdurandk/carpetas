package practicahilos.panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{

    private PanaderoConsumidor pc;
    public Panadero(PanaderoConsumidor pc){
        this.pc = pc;
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            pc.panadero("pan n°"+ i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
