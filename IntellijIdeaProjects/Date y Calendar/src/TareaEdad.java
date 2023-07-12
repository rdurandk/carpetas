import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class TareaEdad {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese un fecha de nacimiento con formato yyyy-MM-dd:");
            String fechaNacimiento = scanner.next();

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaStr = df.parse(fechaNacimiento);
            Date fechaActual = new Date();

            long fechaStrMili = fechaStr.getTime();
            long fechaActualMili = fechaActual.getTime();
            double edad = Math.floor((fechaActualMili - fechaStrMili)/31536000000d);
            System.out.println("Usted tiene "+ edad + " años");
            //no cuenta con años bisiestos para ello tendria que ser mas grande el programa
        }catch (ParseException e){
            System.err.println("Ocurrio un error en el parseo: " + e.getMessage());
        }
    }
}
