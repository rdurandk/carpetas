public class EjemploStringMetodosArreglos {
    public static void main(String[] args) {
        
       
        String trabalenguas = "trabalenguas";
        System.out.println("trabalenguas.toCharArray() = " + trabalenguas.toCharArray());

        char[] arreglo = trabalenguas.toCharArray();
        int largo = arreglo.length;
        System.out.println(largo);
        for (char arr:arreglo
             ) {
            System.out.println(arr);
        }

        System.out.println();
        String [] arreglo2 = trabalenguas.split("a");
        for (String arr:arreglo2
             ) {
            System.out.println(arr);
        }

        System.out.println();
        String archivo = "alguna.imagen.pdf";
        String [] archivostr = archivo.split("\\.");
        for (String arr: archivostr
             ) {
            System.out.println(arr);
        }
        System.out.println("extension: "+ archivostr[archivostr.length-1]);
    }
}
