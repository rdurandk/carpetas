package practicahilos;

public class EjemRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeEjem("Rio de Janeiro")).start();
        new Thread(new ViajeEjem("Miami")).start();
        new Thread(new ViajeEjem("California")).start();
        new Thread(new ViajeEjem("Paris")).start();
    }
}
