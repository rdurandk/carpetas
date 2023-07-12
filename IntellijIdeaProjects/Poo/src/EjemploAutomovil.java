import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {

        Automovil subaru = new Automovil("Subaru","Impreza");
        Motor motorSubaru = new Motor(2.0,TipoMotor.BENCINA);
        subaru.setMotor(motorSubaru);
        subaru.setEstanque(new Estanque());//por defecto 40
        subaru.setColor(Color.BLANCO);
        //subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda = new Automovil("Mazda","BT-50",Color.ROJO,new Motor(3.0,TipoMotor.DIESEL));
        mazda.setEstanque(new Estanque(45));
        System.out.println("mazda.getFabricante() = " + mazda.getFabricante());
        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS
                ,new Motor(4.0,TipoMotor.DIESEL),new Estanque(50));
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS
                ,new Motor(3.5, TipoMotor.BENCINA),new Estanque(50));
        Automovil auto = new Automovil();
        Date fecha = new Date();
        System.out.println("son iguales: " + (nissan==nissan2));
        System.out.println("son iguales con equals: " + (nissan.equals(nissan2)));
        System.out.println("son iguales con equals: " + (auto.equals(nissan2)));
        System.out.println("son iguales con equals: " + (auto.equals(fecha)));
        System.out.println(nissan);//implicita el toString
        System.out.println(nissan.toString());

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(subaru.acelerar(3000));
        System.out.println(subaru.frenar());

        System.out.println(mazda.acelerarFrenar(4000));
        System.out.println("Kilometros por litro: " + subaru.calcularConsumo(300,0.6f));
        System.out.println("Kilometros por litro: " + subaru.calcularConsumo(300,60));
        System.out.println("Kilometros por litro: " + nissan.calcularConsumo(300,60));
    }
}
