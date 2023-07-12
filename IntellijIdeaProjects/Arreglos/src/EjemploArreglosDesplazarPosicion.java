import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];

        System.out.println("Ingrese 10 elementos");
        for(int i=0;i<a.length;i++){
            a[i] = sc.nextInt();

        }

        int aux;
        aux = a[a.length-1];
        for(int i=a.length-1;i>0.;i--){

               a[i] = a[i-1];
        }
        a[0] = aux;

        System.out.println();
        for(int i=0;i<a.length;i++){
            System.out.println("indice " + i + " = " +a[i]);
        }

    }
}
