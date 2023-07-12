import javax.swing.*;

public class NombreMasLargo {
    public static void main(String[] args) {
        String nombreCompleto1, nombreCompleto2, nombreCompleto3;

        nombreCompleto1 = JOptionPane.showInputDialog(null, "Ingrese el primer nombre completo");
        nombreCompleto2 = JOptionPane.showInputDialog(null, "Ingrese el segundo nombre completo");
        nombreCompleto3 = JOptionPane.showInputDialog(null, "Ingrese el tercer nombre completo");

        String[] nombreApellido1 = nombreCompleto1.split(" ");
        String nombre1 = nombreApellido1[0];

        String[] nombreApellido2 = nombreCompleto2.split(" ");
        String nombre2 = nombreApellido2[0];

        String[] nombreApellido3 = nombreCompleto3.split(" ");
        String nombre3 = nombreApellido3[0];

        String nombremasLargo;
        nombremasLargo = (nombre1.length() > nombre2.length()) ? nombre1 : nombre2;
        nombremasLargo = (nombremasLargo.length() > nombre3.length()) ? nombremasLargo : nombre3;

        if(nombreCompleto1.contains(nombremasLargo)){
            System.out.println(nombreCompleto1 + " tiene el nombre mas largo");
        }else if(nombreCompleto2.contains(nombremasLargo)){
            System.out.println(nombreCompleto2 + " tiene el nombre mas largo");
        }else if(nombreCompleto3.contains(nombremasLargo)){
            System.out.println(nombreCompleto3 + " tiene el nombre mas largo");
        }
    }
}
