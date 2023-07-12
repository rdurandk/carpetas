import java.util.Arrays;

public class EjemploArreglos {
    public static void main(String[] args) {

        String[] productos = new String[7];
        productos[0] = "Kingston";
        productos[1] = "Samsung galaxy";
        productos[2] = "Disco Duro SSD";
        productos[3] = "Macbook Air";
        productos[4] = "Chromecast";
        productos[5] = "Asus Notebook";
        productos[6] =  "Pc Gamer";

        Arrays.sort(productos); // asignara de manera alfabetica sus valores

        String prod6 = productos[5];
        String prod7 = productos[6];
        System.out.println("productos[0] = " + productos[0]);
        System.out.println("productos[1] = " + productos[1]);
        System.out.println("productos[2] = " + productos[2]);
        System.out.println("productos[3] = " + productos[3]);
        System.out.println("productos[4] = " + productos[4]);
        System.out.println(prod6);
        System.out.println(prod7);



        System.out.println();
        int [] numeros = new int[4];

        //por defecto los objetos de la clase wrapper Integer son 0
        numeros[0] = 10;
        numeros[1] = 7;
        numeros[2] = 35;
        numeros[3] = -1;

        Arrays.sort(numeros);

        int i = numeros[0];
        int j = numeros[1];
        int k = numeros[2];

        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        System.out.println(numeros[3]);
    }
}
