package practicahilos.panaderia;

public class Consumidor implements Runnable{

    private PanaderoConsumidor pc ;
    public Consumidor(PanaderoConsumidor pc){
        this.pc = pc;
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            pc.consumidor();
        }
    }
}
