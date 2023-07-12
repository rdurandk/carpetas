import javax.swing.*;

public class OperadoresAritmetico {
    public static void main(String[] args) {
        int i = 5, j = 4;

        int suma = i+j;
        System.out.println("suma = " + suma);
        System.out.println("i+j = " + i+j);//precedencia de operadores
        System.out.println("i+j = "+(i+j));

        int resta = i-j;
        System.out.println("resta = " + resta);
        System.out.println("i-j = " + (i-j));
        
        int multi = i * j;
        System.out.println("multiplicacion = " + multi);
        
        int div = i/j;
        float div2 = (float)i/j; //casting de i y j
        System.out.println("div = " + div);
        System.out.println("div2 = " + div2);

        int resto = i%j;
        System.out.println("resto = " + resto);
        resto = 8%5;
        System.out.println("resto = " + resto);

        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
        if(numero%2==0){
            System.out.println("es par");
        }else{
            System.out.println("es impar");
        }

    }
}
