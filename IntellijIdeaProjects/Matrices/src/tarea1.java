import java.util.Scanner;

public class tarea1 {
    //Escribir un programa que imprima una X construida a base de la letra X en las diagonales de la matriz y utilizar el carácter guion bajo como relleno.
    // El tamaño de la x se basa en una variable n que indicará el tamaño de la letra para imprimir en una matriz de n x n.
    //El carácter "X" en mayúscula y el guion bajo "_" para los espacios.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un valor para una matriz n x n: ");
        int n=sc.nextInt();
        if(n==0){
            System.err.println("Error: la matriz no debe ser 0");
            System.exit(1);
        }

        String[][] a = new String[n][n];


        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(i==j || (i+j)==a.length-1){
                    a[i][j] = "X";
                }else{
                    a[i][j] = "_";
                }
            }
        }

        for(String[] filas: a){
            for(String el: filas){
                System.out.print(el);
            }
            System.out.println();
        }
    }
}
