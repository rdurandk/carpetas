import java.sql.SQLOutput;
import java.util.Scanner;

public class Mostrar20Notas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int cantidadNotas = 20;
        int contadorMayores = 0;
        int contadorMenores = 0;
        int contadorIgualUno = 0;
        double sumaMayores = 0;
        double sumaMenores = 0;
        double notaAcumulada=0;
        System.out.println("Introduzca notas entre 1-7");
        for(int i=0;i<cantidadNotas;i++){
            System.out.print("Ingrese la nota "+(i+1)+": ");
            double nota = sc.nextDouble();
            notaAcumulada += nota;

            if((nota <= 7) && (nota >= 5)){
                sumaMayores += nota;
                contadorMayores++;
            }else if((nota <= 4) && (nota >=1)){
                sumaMenores += nota;
                contadorMenores++;
            }

            if(nota == 1){
                contadorIgualUno++;
            }
            if((nota==0) || (nota<0) || (nota>7)){ //si ingresa una nota 0 o superior a 7
                System.out.println("Error finalizando el programa");
                break;
            }

            if(i==(cantidadNotas-1)){

                System.out.println("El promedio de las notas mayores a 5 es: " + (sumaMayores / contadorMayores));
                System.out.println("El promedio de las notas menores o igual a 4 es: "+ (sumaMenores/contadorMenores));
                System.out.println("La cantidad de notas iguales a 1 es: " + contadorIgualUno);
                System.out.println("El promedio de todas las notas finales es: " + (notaAcumulada/cantidadNotas));
            }
        }

    }
}
