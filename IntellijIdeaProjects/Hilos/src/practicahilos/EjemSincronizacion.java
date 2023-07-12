package practicahilos;

public class EjemSincronizacion {
    public static void main(String[] args) {
        new Thread(new ImprimirAlgo("Hola ", "que tal")).start();
        new Thread(new ImprimirAlgo("Muchas gracias", " amigo")).start();
        new Thread(new ImprimirAlgo("Quien eres", " tu")).start();
    }

    public synchronized static void imprimirAlgo(String algo1, String algo2){
        System.out.print(algo1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(algo2);
    }
}
