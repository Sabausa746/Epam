package com.epam.rd.autotasks.meetautocode;

import java.time.Clock;
import java.util.Scanner;

public class ElectronicWatch {
    static final int SECSINMINS = 60;
    static final int SECSINHOURS = 3600;
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int seconds = nextInt(scanner.nextLine());

        int hours = seconds / SECSINHOURS;
        hours = hours % 24;
        seconds = seconds % SECSINHOURS;
        int minutes = seconds / SECSINMINS;
        seconds = seconds % SECSINMINS;

        System.out.printf("%d:%02d:%02d%n",hours, minutes, seconds);
        scanner.close();

    }
    static int nextInt(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println("Please input an int");
            nextInt(scanner.nextLine());
        }
        return 0;
    }
}
