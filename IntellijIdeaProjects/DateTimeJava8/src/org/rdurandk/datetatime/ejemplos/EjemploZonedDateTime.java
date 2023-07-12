package org.rdurandk.datetatime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EjemploZonedDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaLocal = LocalDateTime.parse("2021/09/23 12:45",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        ZoneId newYork = ZoneId.of("America/New_York");
        //ZonedDateTime zoneNy = ZonedDateTime.of(fechaLocal, ZoneOffset.of("-04:00"));
        ZonedDateTime zoneNy = fechaLocal.atZone(ZoneOffset.of("-04:00"));
        System.out.println("Horario de partida en New York = " + zoneNy);

        //ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zoneMadrid = zoneNy.withZoneSameInstant(ZoneOffset.of("+02:00")).plusHours(8);
        System.out.println("Horario de llegada en Madrid = " + zoneMadrid);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
        System.out.println("Detalles del viaje a españa");
        System.out.println("Partida NY: " + f.format(zoneNy));
        System.out.println("Llegada Madrid: " + f.format(zoneMadrid));

        /*Set zonas = ZoneId.getAvailableZoneIds();
        System.out.println("ZONAS HORARIAS");
        zonas.forEach(System.out::println);*/
    }
}
