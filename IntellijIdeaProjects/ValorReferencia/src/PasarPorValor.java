public class PasarPorValor {
    public static void main(String[] args) {

        int i = 10;

        System.out.println("iniciamos el método main con i = " + i);
        test(i);
        System.out.println("Finaliza el método main con el valor de i (se mantiene igual) = " + i);
        //nose modifica ya que los tipos de datos primitivos y clases wrappers son inmutables
    }

    public static void test(int i){
        System.out.println("Iniciamos el método test con i = " + i);
        i = 35;
        System.out.println("Finaliza el método test con i = " + i);
    }
}
