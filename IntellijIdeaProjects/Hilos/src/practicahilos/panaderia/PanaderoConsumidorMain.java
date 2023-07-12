package practicahilos.panaderia;

public class PanaderoConsumidorMain {
    public static void main(String[] args) {
        PanaderoConsumidor pc = new PanaderoConsumidor();
        Panadero panadero = new Panadero(pc);
        Consumidor consumidor = new Consumidor(pc);
        new Thread(panadero).start();
        new Thread(consumidor).start();
    }
}
