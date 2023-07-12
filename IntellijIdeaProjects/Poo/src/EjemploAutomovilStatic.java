import java.util.Date;

public class EjemploAutomovilStatic {
    public static void main(String[] args) {
        Automovil subaru = new Automovil("Subaru","Impreza");
        Motor motorSubaru = new Motor(2.0,TipoMotor.BENCINA);
        subaru.setMotor(motorSubaru);
        subaru.setEstanque(new Estanque());//por defecto 40
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda = new Automovil("Mazda","BT-50",Color.ROJO
                ,new Motor(3.0,TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        System.out.println(mazda.getEstanque().getCapacidad());
        System.out.println("mazda.getFabricante() = " + mazda.getFabricante());

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS
                ,new Motor(4.0,TipoMotor.DIESEL),new Estanque(50));
        nissan.setTipo(TipoAutomovil.PICKUP);
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS
                ,new Motor(3.5,TipoMotor.BENCINA),new Estanque(50));
        nissan2.setColor(Color.AMARILLO);
        nissan2.setTipo(TipoAutomovil.PICKUP);
        Automovil.setColorPatente(Color.AZUL);

        Automovil auto = new Automovil();

        //Automovil.colorPatente = "Verde";
        Automovil.setColorPatente(Color.AZUL);
        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());

        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());
        System.out.println("Automovil.calcularConsumoEstatico(300,60) = " + Automovil.calcularConsumoEstatico(300,60));
        System.out.println("Automovil.VELOCIDAD_MAX_CARRETERA: "+Automovil.VELOCIDAD_MAX_CARRETERA);
        System.out.println("Automovil.VELOCIDAD_MAX_CIUDAD: "+Automovil.VELOCIDAD_MAX_CIUDAD);

        System.out.println();
        TipoAutomovil tipoSubaru = subaru.getTipo();
        System.out.println("tipoSubare = " + tipoSubaru.getNombre());
        System.out.println("tipoSubaru.getDescripcion() = " + tipoSubaru.getDescripcion());

        System.out.println(mazda.calcularConsumo(300,70));
    }
}
