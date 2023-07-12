import java.util.Scanner;

public class BuscarNumeroMenor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros a comparar");
        int numComparar = sc.nextInt();

        if(numComparar<10){
            System.out.println("como minimo se compara 10 numeros");
        }else{
            int numero;
            int numMenor=0;
            for(int i=0;i<numComparar;i++){
                if(i==0){
                    System.out.println("Ingrese el numero: " + (i+1));
                    numMenor = sc.nextInt();
                }else {
                    System.out.println("Ingrese el numero " + (i + 1));
                    numero = sc.nextInt();
                    numMenor = (numMenor<numero) ? numMenor : numero;
                }
            }

            System.out.println("El menor numero es: " + numMenor);
            if(numMenor<10){
                System.out.println("El número menor es menor que 10!");
            }else{
                System.out.println("El numero menor es igual o mayor que 10!");
            }
        }
    }

}
