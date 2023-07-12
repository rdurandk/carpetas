import java.util.Scanner;

public class AreaDeCuadrado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el radio del cuadrado: ");
        double r = sc.nextDouble();

        double area;
        area = Math.PI*Math.pow(r,2);
        System.out.println("El area del circulo es: " + Math.floor(area));
    }
}
