import java.util.Scanner;

public class tarea1 {
    // Ordenar el arreglo de la forma último primero, etc
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        System.out.println("Ingrese 10 numeros");
        for(int i=0;i<a.length;i++){
            a[i]= sc.nextInt();
        }

        int[] b= new int[10];
        int aux=0;
        for(int i=0;i<a.length/2;i++){
            b[aux++] = a[a.length-1-i];
            b[aux++] = a[i];
        }

        System.out.println("Nuevo arreglo: ");
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}
