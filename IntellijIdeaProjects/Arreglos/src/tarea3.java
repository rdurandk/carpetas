import java.util.Scanner;

public class tarea3 {
    //Leer 7 números por teclado para llenar un arreglo y a continuación calcular el promedio
    // de los números positivos, el promedio de los negativos y contar el número de ceros.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[7];
        int numPositivos=0,numNegativos=0,numCeros=0;
        int sumPositivos=0,summNegativos=0;
        System.out.println("Ingrese 7 elementos: ");
        for(int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<a.length;i++){
            if(a[i]>0){
                numPositivos++;
                sumPositivos += a[i];

            }else if(a[i]==0){
                numCeros++;
            }else if(a[i]<0){
                numNegativos++;
                summNegativos += a[i];
            }
        }

        System.out.println("El promedio de los positivos es: " + (double)sumPositivos/numPositivos);
        System.out.println("El promedio de los negativos es: " + (double)summNegativos/numNegativos);
        System.out.println("Cantidad de ceros: " + numCeros);

    }
}
