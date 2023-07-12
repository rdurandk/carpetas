public class WrapperOperadoresRelacionales {
    public static void main(String[] args) {

        Integer num1 = Integer.valueOf(1000);
        Integer num2 = num1;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("Son el mismo objeto? " + (num1 == num2));

        num2 = 1000; //tiene otra instancia del valor

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        // el signo == compara por instancia del valor, ademas sera igual por instancia hasta el numero 127
        System.out.println("Son el mismo objeto? " + (num1 == num2));

        System.out.println("tienen el mismo valor? " + (num1.equals(num2))); //equals compara solo por el valor
        System.out.println("tienen el mismo valor? " + (num1.intValue() == num2.intValue()));

        num2 = 500;
        boolean condicion = num1 > num2;
        System.out.println("condicion = " + condicion);

        boolean condicion2 = num1.intValue() < num2.intValue();
        System.out.println("condicion2 = " + condicion2);
    }
}
