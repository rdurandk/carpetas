import java.util.Scanner;

public class tarea2 {
    //Escribir un programa para una matriz de n x n e imprima en ella una silla (o letra h minúscula) construida a base del numero 1 y utilizar
    // el numero 0 como espacio. El tamaño de la silla se basa en una variable n que indicará el tamaño de la figura a imprimir en una matriz de n x n.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un valor para una matriz n x n: ");
        int n = sc.nextInt();
        if(n==0){
            System.err.println("Error: el valor no puede ser 0");
            System.exit(-1);
        }

        int[][] a = new int[n][n];
        double x = Math.ceil((float)(a.length-1)/2);
        System.out.println();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(j==0 || x==i || (i>x&&(a.length-1)==j)){
                    a[i][j] = 1;

                }

            }
        }

        for(int[] filas: a){
            for(int el: filas){
                System.out.print(el);
            }
            System.out.println();
        }

    }
}
