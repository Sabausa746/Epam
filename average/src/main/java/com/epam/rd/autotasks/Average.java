package com.epam.rd.autotasks;

import java.util.*;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numberStringArr = scanner.nextLine().trim().split(" ");
        List<Integer> numbers = new ArrayList<>();
        StringBuilder nonNumbers = new StringBuilder("Element ");
        boolean print = false;
        for (int i = 0; i < numberStringArr.length - 1; i++) {
            try {
                numbers.add(Integer.parseInt(numberStringArr[i]));
            } catch (NumberFormatException e) {
                nonNumbers.append(i).append(',');
                print = true;
            }
        }
        if(print){
            System.out.println(nonNumbers.substring(0,nonNumbers.length()-1) + " is not a number");
        }

        if (numbers.isEmpty()) {
            System.out.println("Must contain at least 1 number");
            main(new String[]{});
        }
        int size = numbers.size();
        System.out.print(numbers.stream().reduce(0, Integer::sum) / size);

    }
}