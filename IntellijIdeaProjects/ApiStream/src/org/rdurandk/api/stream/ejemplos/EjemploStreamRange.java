package org.rdurandk.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamRange {
    public static  void main(String[] args) {

        IntStream num = IntStream.range(5, 20)
                .peek(System.out::println);

        //Integer resultado = num.reduce(0, (a,b) -> a+b);
        //int resultado = num.sum();//disponible en un IntStream
        //nota num solo permite hacer un operador terminal por eso se implemente Intsummarystatistics
        IntSummaryStatistics stats = num.summaryStatistics();
        System.out.println("max: " + stats.getMax());
        System.out.println("min: " + stats.getMin());
        System.out.println("suma: " + stats.getSum());
        System.out.println("promedio: " + stats.getAverage());
        System.out.println("total: " + stats.getCount());
    }
}
