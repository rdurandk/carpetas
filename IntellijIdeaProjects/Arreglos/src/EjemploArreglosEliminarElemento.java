import java.util.Scanner;

public class EjemploArreglosEliminarElemento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];

        System.out.println("Ingrese 10 elementos");
        for(int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
        }
        //ingrese una posicion sin dejar hueco
        System.out.print("Ingrese una posicion a eliminar: ");
        int pos = sc.nextInt();

        for(int i=pos;i<a.length-1;i++){
            a[i] = a[i+1];
        }

        System.out.println();
        for(int i=0;i<a.length;i++){
            System.out.println("indice " + i + " = " +a[i]);
        }

        System.out.println();
        int[] b = new int[a.length-1];
        System.arraycopy(a,0,b,0,b.length);
        for(int i=0;i<b.length;i++){
            System.out.println("indice " + i + " = " +b[i]);
        }
    }
}
