public class OperadoresIncrementales {
    public static void main(String[] args) {

        //Pre Incremento
        int i = 1;
        int j = ++i;// i = i+1;

        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println();

        //Post Incremento
        i = 1;
        j = i++;// i = i+1;

        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println();

        //Pre Decremento
        i = 3;
        j = --i;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println();

        //Post Decremento
        i = 4;
        j = i--;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println();
        System.out.println("j = "+(++j));
        System.out.println("j = "+(j++));
    }
    
}
