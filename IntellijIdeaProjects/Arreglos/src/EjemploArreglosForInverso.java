import java.util.Arrays;

public class EjemploArreglosForInverso {
    public static void main(String[] args) {

        //String[] productos = new String[7];
        String[] productos = {"Kingston","Samsung galaxy","Disco Duro SSD",
                "Macbook Air","Chromecast","Asus Notebook","Pc Gamer"};
        int total = productos.length;

        /*productos[0] = "Kingston";
        productos[1] = "Samsung galaxy";
        productos[2] = "Disco Duro SSD";
        productos[3] = "Macbook Air";
        productos[4] = "Chromecast";
        productos[5] = "Asus Notebook";
        productos[6] =  "Pc Gamer";*/

        Arrays.sort(productos); // asignara de manera alfabetica sus valores

        System.out.println("====Usando for ====");
        for(int i=0;i<total;i++){
            System.out.println("para indice " + i + " : " + productos[i]);
        }

        System.out.println("====Usando for inverso ====");
        for(int i=0;i<total;i++){
            System.out.println("para i = " + (total-1-i) + " valor: " + productos[total-1-i]);
        }

        System.out.println("====Usando for inverso 2 ====");
        for(int i= total-1;i>=0;i--){
            System.out.println("para i = " + i + " valor: " + productos[i]);
        }

    }
}
