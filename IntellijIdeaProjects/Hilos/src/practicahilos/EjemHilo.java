package practicahilos;

public class EjemHilo {
    public static void main(String[] args) {
        new Thread(new NombreHilo("Alex")).start();
        new Thread(new NombreHilo("Silvia")).start();
        new Thread(new NombreHilo("Jessica")).start();
    }
}
