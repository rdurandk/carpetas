import javax.swing.*;

public class EstanqueGasolina {
    public static void main(String[] args) {
        double medidaActual;

        medidaActual = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese medida actual"));

        if(medidaActual == 70 ){
            System.out.println("Estanque lleno");
        }else if(medidaActual >= 60 && medidaActual<70){
            System.out.println("Estanque casi lleno");
        }else if(medidaActual >= 40 && medidaActual < 60){
            System.out.println("Estanque  3/4");
        }else if(medidaActual >= 35 && medidaActual < 40){
            System.out.println("Medio Estanque");
        }else if(medidaActual >= 20 && medidaActual < 35){
            System.out.println("Suficiente");
        }else if(medidaActual >= 1 && medidaActual < 20){
            System.out.println("Insuficiente");
        }

    }
}
