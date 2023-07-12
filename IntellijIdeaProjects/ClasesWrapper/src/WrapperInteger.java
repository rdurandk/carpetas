public class WrapperInteger {
    public static void main(String[] args) {

        int intPrimitivo = 32768;
        Integer intObjeto = Integer.valueOf(intPrimitivo); //Autoboxing
        Integer intObjeto2 = intPrimitivo;
        System.out.println("intObjeto = " + intObjeto);


        int num = intObjeto; //Unboxing  implicita
        System.out.println("num = " + num);
        int num2 = intObjeto.intValue(); //Unboxing de forma explicita
        System.out.println("num2 = " + num2);
        
        String valorTvLcd = "67000";
        Integer valor = Integer.valueOf(valorTvLcd);
        System.out.println("valor = " + valor);

        //si pasamos un int a un short o byte tener cuidado con los limites ya que genera ambiguedad
        Short shortObjeto = intObjeto.shortValue();
        System.out.println("shortObjeto = " + shortObjeto);
        
        Byte byteObjeto = intObjeto.byteValue();
        System.out.println("byteObjeto = " + byteObjeto);
        
        Long longObjeto = intObjeto.longValue();
        System.out.println("longObjeto = " + longObjeto);

    }
}
