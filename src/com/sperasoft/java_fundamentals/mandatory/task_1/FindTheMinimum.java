package com.sperasoft.java_fundamentals.mandatory.task_1;

import java.util.Scanner;

public class FindTheMinimum {

    public static int findMinOf(int a, int b) {
        return (a < b) ? a : b;
    }

    public static int findMinOf(int a, int b, int c) {
        int lowestIntOf2 = findMinOf(a, b);
        return (c < lowestIntOf2) ? c : lowestIntOf2;
    }

    public static int findMinOf(int a, int b, int c, int d) {
        int lowestIntOf3 = findMinOf(a, b, c);
        return (d < lowestIntOf3) ? d : lowestIntOf3;
    }

    public static void main(String[] args) {

        System.out.println("Input a sequence of 2, 3 or 4 numbers divided by whitespace (e.g. 123 1234 12 1):");

        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();

        String[] splitStringArray = inputString.split(" ");
        int[] parsedStringArray = new int[splitStringArray.length];

        for (int i = 0; i < splitStringArray.length; i++) {
            parsedStringArray[i] = Integer.parseInt(splitStringArray[i]);
        }

        int result = 0;
        switch (parsedStringArray.length) {
            case 2:
                result = findMinOf(parsedStringArray[0], parsedStringArray[1]);
                System.out.println("Lowest of " + parsedStringArray[0] + " and " + parsedStringArray[1] + " is " + result + ".");
                break;
            case 3:
                result = findMinOf(parsedStringArray[0], parsedStringArray[1],
                        parsedStringArray[2]);
                System.out.println("Lowest of " + parsedStringArray[0] + ", " + parsedStringArray[1] + " and " + parsedStringArray[2] + " is " + result + ".");
                break;
            case 4:
                result = findMinOf(parsedStringArray[0], parsedStringArray[1],
                        parsedStringArray[2], parsedStringArray[3]);
                System.out.println("Lowest of " + parsedStringArray[0] + ", " + parsedStringArray[1] + ", " + parsedStringArray[2] + " and " + parsedStringArray[3] + " is " + result + ".");
                break;
            default:
                System.out.println("Invalid argument count. Please input from 2 to 4 arguments.");
                break;
        }

        // Output the final result only if number of arguments is 2, 3 or 4
        if ((parsedStringArray.length > 1) && (parsedStringArray.length < 5)) {
            System.out.print("Lowest of input numbers is " + result + ".\n");
        }
    }
}
