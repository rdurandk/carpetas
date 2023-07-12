import java.util.Arrays;

public class EjemploArreglosFor {
    public static void main(String[] args) {

        String[] productos = new String[7];
        int total = productos.length;

        productos[0] = "Kingston";
        productos[1] = "Samsung galaxy";
        productos[2] = "Disco Duro SSD";
        productos[3] = "Macbook Air";
        productos[4] = "Chromecast";
        productos[5] = "Asus Notebook";
        productos[6] =  "Pc Gamer";

        Arrays.sort(productos); // asignara de manera alfabetica sus valores

        System.out.println("====Usando for ====");
        for(int i=0;i<total;i++){
            System.out.println("para indice " + i + " : " + productos[i]);
        }

        System.out.println("====Usando foreach====");
        for(String prod: productos){
            System.out.println("prod = " + prod);
        }
        System.out.println("===Usando while===");
        int i=0;
        while(i<total){
            System.out.println("para indice " + i + " : " + productos[i]);
            i++;
        }
        System.out.println("===Usando dowhile===");
        int j=0;
        do{
            System.out.println("para indice " + j + " : " + productos[j]);
            j++;
        }while(j<total);


        System.out.println();
        int [] numeros = new int[10];
        int totalNumeros = numeros.length;
        for(int k=0;k<totalNumeros;k++){
            numeros[k] = k*3;
        }
        for(int k=0;k<totalNumeros;k++){
            System.out.println("numeros = " + numeros[k]);
        }

    }
}
