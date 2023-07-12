import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        SemaforoA semA = new SemaforoA("Los angeles", "San Juan");
        SemaforoB semB = new SemaforoB("Villa maria");
        SemaforoC semC = new SemaforoC("La paradita");


        Thread hilo1 = new Thread(semA);
        hilo1.start();
        Thread hilo2 = new Thread(semB);
        hilo2.start();
        Thread hilo3 = new Thread(semC);
        hilo3.start();


        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\n");
                if(!hilo1.isAlive() && !hilo2.isAlive() && !hilo3.isAlive()){
                    time.cancel();
                }
            }
        },1200,1200);

    }
}
