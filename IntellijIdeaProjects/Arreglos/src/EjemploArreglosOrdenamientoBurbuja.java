import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class EjemploArreglosOrdenamientoBurbuja {
    public static void arregloInverso(String[] arreglo){
        int total2 = arreglo.length;
        int total = arreglo.length;
        for(int i=0;i<total2;i++){
            String actual = arreglo[i];
            String inverso = arreglo[total-1-i];
            arreglo[i] = inverso;
            arreglo[total-1-i] = actual;
            total2--;
        }
    }

    public static Object[] sortBurbuja(Object[] arreglo){
        int total = arreglo.length;
        int contador=0;

        //object y comparable son de forma generico son herencias padres
        for(int i=0;i<total-1;i++){

            for(int j=0;j<total-1-i;j++){
                if( ((Comparable)arreglo[j+1]).compareTo(arreglo[j]) < 0 ){//si productos[i] es menor que productos[j]

                    Object auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = auxiliar;

                }
                contador++;
            }
        }

        System.out.println("contador = " + contador);
        System.out.println("====Usando for ====");
        for(int i=0;i<total;i++){
            System.out.println("para indice " + i + " : " + arreglo[i]);
        }
        return arreglo;
    }
    public static void main(String[] args) {



        String[] productos = {"Kingston","Samsung galaxy","Disco Duro SSD",
                "Macbook Air","Chromecast","Asus Notebook","Pc Gamer", "Bicicleta Oxford"};
        //String[] productos = {"Kingston","Samsung galaxy","Disco Duro SSD"};

        /*
        String palabra1 = productos[0];
        String palabra2 = productos[2];
        System.out.println(palabra1 + " ; "+palabra2);
        int num = palabra1.compareTo(palabra2);
        System.out.println(num);
        if(num<0){
            System.out.println("Palabra 1 es menor que palabra 2");
        }else{
            if(num==0){
                System.out.println("son iguales");
            }else{
                System.out.println("Palabra 1 es mayor que palabra 2");
            }
        }*/

        /*
        int total = productos.length;
        int contador = 0;

        for(int i=0;i<total-1;i++){


            for(int j=0;j<total-1-i;j++){
                if(productos[j+1].compareTo(productos[j]) < 0){//si productos[i] es menor que productos[j]

                    String auxiliar = productos[j];
                    productos[j] = productos[j+1];
                    productos[j+1] = auxiliar;

                }
                contador++;
            }
        }
        System.out.println("contador = " + contador);
        */


        //para revertir
        Object[] products2 = sortBurbuja(productos);
        Collections.reverse(Arrays.asList(products2));//para ponerlo al reves
        System.out.println("====Usando for 2 ====");
        for(int i=0;i<productos.length;i++){
            System.out.println("para indice " + i + " : " + products2[i]);
        }

        //Arrays.sort(productos); // asignara de manera alfabetica sus valores
        //arregloInverso(productos);
        //Collections.reverse(Arrays.asList(productos));



        Integer [] numeros = new Integer[4];

        numeros[0] = 10;
        numeros[1] = 7;
        numeros[2] = 35;
        numeros[3] = -1;

        System.out.println();
        sortBurbuja(numeros);
    }
}
