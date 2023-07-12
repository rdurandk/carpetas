package org.rdurandk.archivos.ejemplos;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String input = "1,2,3,4,5";
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter(",");

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println(number);
        }
        scanner.close();
    }
}
