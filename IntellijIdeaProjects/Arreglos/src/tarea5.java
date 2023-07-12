import java.util.Scanner;

public class tarea5 {
    //Escribir un programa que recorra un arreglo y genere un histograma en base a los valores de este.
    //
    //El arreglo debe contener 12 elementos que corresponden a números enteros de rango 1 al 6.
    //
    //Un histograma es una representación gráfica (de puntos o barra) de que tanto un elemento aparece en un
    // conjunto de datos, es decir debe mostrar la frecuencia para todos los números del 1 al 6, incluso si no
    // están presente en el arreglo.
    //Por ejemplo para el arreglo {4, 3, 4, 6, 6, 4, 1, 4, 5, 4, 1, 1} el histograma debería ser:
    //
    //1: ***
    //2:
    //3: *
    //4: *****
    //5: *
    //6: **

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] a = new int[12];
        int element;
        for(int i=0;i<a.length;i++){
            do{
                System.out.print("Ingrese un elemento[1-6] en la posicion " + (i+1)+ ": ");
                 element = sc.nextInt();
            }while(element<1 || element>6);
            a[i] = element;        }

        String[] b = new String[6];

        for(int i=1;i<=6;i++){
            String aterisco = "";
            for(int j=0;j<a.length;j++){
                if(i==a[j]){
                    aterisco+="*";
                }
            }
            b[i-1] = aterisco;
        }

        for(int i=0;i<b.length;i++){
            System.out.println((i+1)+": "+ b[i]);
        }
    }
}
