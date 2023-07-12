public class EjemploString {
    public static void main(String[] args) {
        String curso = "Programación Java";
        String curso2 = new String("Programación Java");
        boolean esIgual = curso==curso2;
        boolean esIgual2 = curso.equals(curso2);
        System.out.println(esIgual);
        System.out.println(esIgual2);

        String curso3 = "Programación Java";
        esIgual = curso == curso3;
        System.out.println(esIgual);
    }

}
