import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion3b {
    public static void main(String[] args) {

        int[] a = new int[7];
        int numero, posicion;

        Scanner s = new Scanner(System.in);

        for(int i = 0; i < a.length; i++){
            System.out.print("Ingrese un número: ");
            a[i] = s.nextInt();
        }
        System.out.println();
        //System.out.println("valor: "+a[6]);
        System.out.println("Ingrese un número a insertar:");
        numero = s.nextInt();

        posicion = 0;
        while(posicion < 6 && numero > a[posicion]){
            posicion++;
        }

        int ultimo = a[a.length-1];
        for(int i = a.length - 2; i >= posicion; i--){
            a[i+1] = a[i];
        }

        System.out.println("El nuevo arreglo ordenado:");
        for(int i = 0; i < a.length; i++){
            System.out.println(i + " => " + a[i]);
        }

        System.out.println();
        int[] b = new int[a.length+1];
        System.arraycopy(a,0,b,0,b.length-1);

        if(numero>ultimo){
            b[b.length-1] = numero;

        }else{
            b[posicion] = numero;
            b[b.length-1] = ultimo;
        }
        for(int i = 0; i < b.length; i++){
            System.out.println(i + " => " + b[i]);
        }
    }
}
