import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion2b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];

        System.out.println("Ingrese 10 elementos");
        for(int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
        }

        System.out.print("Ingrese una posicion: ");
        int pos = sc.nextInt();
        System.out.print("Ingrese un elemento: ");
        int element = sc.nextInt();
        int ultimo;

        ultimo = a[a.length-1];
        for(int i=a.length-1;i>pos;i--){
            a[i] = a[i-1];
        }

        a[pos] = element;

        System.out.println();
        for(int i=0;i<a.length;i++){
            System.out.println("indice " + i + " = " +a[i]);
        }

        System.out.println();
        int[] b = new int[a.length+1];
        System.arraycopy(a,0,b,0,b.length-1);
        b[b.length-1] = ultimo;
        for(int i=0;i<b.length;i++){
            System.out.println("indice " + i + " = " +b[i]);
        }
    }
}
