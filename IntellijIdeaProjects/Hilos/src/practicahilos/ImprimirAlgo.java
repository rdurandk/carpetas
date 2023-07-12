package practicahilos;
import static practicahilos.EjemSincronizacion.imprimirAlgo;
public class ImprimirAlgo implements Runnable{

    private String algo1;
    private String algo2;
    public ImprimirAlgo(String algo1, String algo2){
        this.algo1 = algo1;
        this.algo2 = algo2;
    }


    @Override
    public void run() {
        imprimirAlgo(algo1, algo2);
    }
}
