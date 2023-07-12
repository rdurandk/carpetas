import java.util.Scanner;

public class MultiplicarDosEnterosSinSimbolo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer numero: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        int num2 = sc.nextInt();

        boolean esPositivo = num1 > 0;
        boolean esPositivo2 = num2 > 0;

        int x2; //tomara los valores absolutos de los numeros


        if(esPositivo2){
            x2 = num2;
        }else{
            x2 = -(num2);
        }

        int producto=0;
        for(int i=0;i<x2;i++){
                producto = (producto) + (num1);
        }

        if((!esPositivo && !esPositivo2) || (!esPositivo2)) {
            producto = -(producto);
        }
        System.out.println("El resultado es: " + producto);

    }
}
