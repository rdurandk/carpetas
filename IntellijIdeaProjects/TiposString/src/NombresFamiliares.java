import com.sun.tools.jconsole.JConsoleContext;

import java.util.Scanner;

public class NombresFamiliares {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el primer nombre familiar: ");
        String nombre1 = entrada.nextLine();
        String [] nom1Arreglo = nombre1.split("");
        String captura1 = nom1Arreglo[1].toUpperCase().concat(".").concat(nombre1.substring(nombre1.length()-2));
        System.out.println(captura1);

        System.out.print("Ingrese el segundo nombre familiar: ");
        String nombre2 = entrada.nextLine();
        String [] nom2Arreglo = nombre2.split("");
        String captura2 = nom2Arreglo[1].toUpperCase().concat(".").concat(nombre2.substring(nombre2.length()-2));
        System.out.println(captura2);

        System.out.print("Ingrese el tercer nombre familiar: ");
        String nombre3 = entrada.nextLine();
        String [] nom3Arreglo = nombre3.split("");
        String captura3 = nom3Arreglo[1].toUpperCase().concat(".").concat(nombre3.substring(nombre3.length()-2));
        System.out.println(captura3);

        String union = captura1.concat(captura2).concat(captura3);
        //System.out.println(union);
        String [] unionArreglo = union.split("");
        String text="";
        int contador = 3;
        System.out.println();
        for(int i=0;i<unionArreglo.length;i++){
            if(contador==i){
                text += unionArreglo[i].concat("_");
                contador+=4;
            }else{
                text += unionArreglo[i];
            }

        }
        System.out.println(text);
    }
}
