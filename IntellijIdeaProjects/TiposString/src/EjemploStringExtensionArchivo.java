public class EjemploStringExtensionArchivo {
    public static void main(String[] args) {
        String archivo = "alguna_imagen.jpg";
        System.out.println("archivo.length() = " + archivo.length());
        System.out.println("archivo extension= " + archivo.substring(archivo.lastIndexOf(".")+1));

    }
}
