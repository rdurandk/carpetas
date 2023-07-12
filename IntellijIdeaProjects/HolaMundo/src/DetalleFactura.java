import java.util.Scanner;

public class DetalleFactura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la factura: ");
        String descripcion = sc.nextLine();

        System.out.print("Ingrese el precio 1: ");
        double precio1 = sc.nextDouble();

        System.out.print("Ingrese el precio 2: ");
        double precio2 = sc.nextDouble();

        double precioBruto = precio1+precio2;
        double impuesto = 0.19;
        String impuestostr = String.valueOf(impuesto*100+"%");
        double total = precioBruto + (precioBruto*impuesto);

        System.out.println("La factura de "+descripcion+ " tiene un total bruto de "+precioBruto+" con impuesto de "+ impuestostr+
                " y el monto despues del impuesto es "+total);
    }
}
