package com.epam.rd.autotasks;

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double d = pow(b, 2) - 4 * a * c;

        if (d < 0) {
            System.out.println("no roots");
        }

        if (d == 0) {
            System.out.println((b * -1) / (2 * a));
        }

        if (d > 0){
            double x1 = (-b + sqrt(d)) / (2 * a);
            double x2 = (-b - sqrt(d)) /( 2 * a);

            System.out.printf("%f %f",x1,x2);
        }

    }

}