import java.util.Scanner;
public class tarea2 {
    //Escriba un programa que imprima el número más alto de un arreglo de 7 elementos (de rango 11 a 99), por ejemplo {14, 33, 15, 36, 78, 21, 43}, si se repite un valor considerar uno solo.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[7];
        int element = 0; //elemento que registraremos por teclado y pasara a ser evaluado
        boolean numeroRepetido = false; // para ver si se repite un elemento
        System.out.println("Ingrese elementos de ");
        for(int i=0;i<a.length;i++){

            do{
                System.out.print("Ingrese elemento(rangos: 11-99) en la posicion: " +(i+1) +": ");
                element= sc.nextInt();
                numeroRepetido=false;
                int cont=i;
                while(cont>=0 && numeroRepetido==false){
                    if(a[cont] == element){
                        numeroRepetido=true;
                    }
                    cont--;
                }
            }while((element>99 || element<11) || (numeroRepetido==true));
            a[i] = element;
        }
        System.out.println("El arreglo es: ");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

        int mayor = a[0];
        for(int i=0;i<a.length;i++){
             mayor = mayor>a[i] ?mayor : a[i];
        }

        System.out.println("El numero mayor del arreglo es: " + mayor);

    }
}
