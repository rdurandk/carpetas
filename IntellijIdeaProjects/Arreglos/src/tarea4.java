import java.util.Scanner;

public class tarea4 {
    //Para la tarea se debe crear un arreglo con 10 elementos (enteros en el rango de 1 a 9).
    // Escriba un programa que imprima el número que tiene más ocurrencias en el arreglo y
    // también imprimir la cantidad de veces que aparece en el arreglo.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[10];

        for(int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
        }
        int ocurrencias=1;
        int auxOcurrencia=0;
        int mayorOcurrencia=0;
        for(int i=0;i<a.length-1;i++) {
            ocurrencias = 1;
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j]){
                    ocurrencias++;
                }
            }
            if(mayorOcurrencia<ocurrencias){
                mayorOcurrencia = ocurrencias;
                auxOcurrencia = a[i];

            }
        }
        System.out.println("La mayor ocurrencias es: " + mayorOcurrencia);
        System.out.println("El elemento que mas se repite es: " + auxOcurrencia);
    }
}
