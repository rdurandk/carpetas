import java.lang.reflect.Method;

public class EjemploMetodoGetClass {
    public static void main(String[] args) {
        
        String texto = "Hola que tal!";
        
        Class strClass = texto.getClass();

        System.out.println("strClass.getName() = " + strClass.getName());
        System.out.println("strClass.getSimpleName() = " + strClass.getSimpleName());
        System.out.println("strClass.getPackageName() = " + strClass.getPackageName());
        System.out.println("strClass.getClass() = " + strClass);
        
        for(Method metodo: strClass.getMethods()){
            System.out.println("metodo.getName() = " + metodo.getName());
        }

        System.out.println();
        Integer num = 34;
        Class intClass = num.getClass();
        Class objClass = intClass.getSuperclass().getSuperclass();
        System.out.println("intClass.getSuperclass() = " + intClass.getSuperclass());
        System.out.println("intClass.getName() = " + intClass.getName());
        System.out.println("intClass.getSimpleName() = " + intClass.getSimpleName());
        System.out.println("intClass.getSuperclass().getSuperclass() = " + objClass);

        for(Method metodo: intClass.getMethods()){
            System.out.println("metodo.getName() = " + metodo.getName());
        }

    }
}
