import javax.swing.*;
import java.util.Scanner;

public class MostrarOrdenadosDosNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1,num2,mayor,menor;

        num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese primer numero"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese segundo numero"));

        mayor = (num1>num2) ?  num1 : num2;
        menor = (num1>num2) ?  num2 : num1;

        System.out.println("El numero mayor es: " +  mayor);
        System.out.println("El numero menor es: " +  menor);
    }
}
