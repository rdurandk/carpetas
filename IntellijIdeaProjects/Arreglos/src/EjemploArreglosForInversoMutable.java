import java.util.Arrays;
import java.util.Collections;

public class EjemploArreglosForInversoMutable {
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
    public static void main(String[] args) {


        String[] productos = {"Kingston","Samsung galaxy","Disco Duro SSD",
                "Macbook Air","Chromecast","Asus Notebook","Pc Gamer"};
        int total = productos.length;


        Arrays.sort(productos); // asignara de manera alfabetica sus valores
        arregloInverso(productos);
        //Collections.reverse(Arrays.asList(productos));
        System.out.println("====Usando for ====");
        for(int i=0;i<total;i++){
            System.out.println("para indice " + i + " : " + productos[i]);
        }

    }
}
