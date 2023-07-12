package org.rdurandk.datetatime.ejemplos;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class EjemploDuration2 {
    public static void main(String[] args) throws InterruptedException {

        Instant i1 = Instant.now();
        System.out.println("i1 = " + i1);
        TimeUnit.SECONDS.sleep(3);
        Instant i2 = Instant.now();
        System.out.println("i2 = " + i2);
        Duration tiempo = Duration.between(i1,i2);
        System.out.println("tiempo = " + tiempo);
    }
}
