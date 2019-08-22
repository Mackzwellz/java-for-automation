package com.sperasoft.java_fundamentals.mandatory.task_1;

// Compile and use:
// javac Practice1Minimum.java
// java Practice1Minimum
// Input: 123 1234 12 1

import java.util.Scanner;

public class FindTheMinimum {

    private static int findMinOf(int a, int b) {
        int lowestIntOf2;
        lowestIntOf2 = (a < b) ? a : b;
        System.out.print("Lowest of " + a + " and " + b + " is " + lowestIntOf2
                + ".\n");
        return lowestIntOf2;
    }

    private static int findMinOf(int a, int b, int c) {
        int lowestIntOf2;
        int lowestIntOf3;
        lowestIntOf2 = findMinOf(a, b);
        lowestIntOf3 = (c < lowestIntOf2) ? c : lowestIntOf2;
        System.out.print("Lowest of " + a + ", " + b + " and " + c + " is "
                + lowestIntOf3 + ".\n");
        return lowestIntOf3;
    }

    private static int findMinOf(int a, int b, int c, int d) {
        int lowestIntOf3;
        int lowestIntOf4;
        lowestIntOf3 = findMinOf(a, b, c);
        lowestIntOf4 = (d < lowestIntOf3) ? d : lowestIntOf3;
        System.out.print("Lowest of " + a + ", " + b + ", " + c + " and " + d
                + " is " + lowestIntOf4 + ".\n");
        return lowestIntOf4;
    }

    public static void main(String[] args) {

        System.out.println("Input a sequence of 2, 3 or 4 numbers divided by whitespace:");

        // Reading input from user. Console works only whe using "Terminal" in IDEA
        // https://stackoverflow.com/questions/5287538/how-can-i-get-the-user-input-in-java
        // https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/

        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();

        String[] splitStringArray = inputString.split(" ");
        int[] parsedStringArray = new int[splitStringArray.length];

        for (int i = 0; i < splitStringArray.length; i++) {
            parsedStringArray[i] = Integer.parseInt(splitStringArray[i]);
        }

        int result = 0;
        switch (parsedStringArray.length) {
            case 2:
                result = findMinOf(parsedStringArray[0], parsedStringArray[1]);
                break;
            case 3:
                result = findMinOf(parsedStringArray[0], parsedStringArray[1],
                        parsedStringArray[2]);
                break;
            case 4:
                result = findMinOf(parsedStringArray[0], parsedStringArray[1],
                        parsedStringArray[2], parsedStringArray[3]);
                break;
            default:
                System.out.print("Invalid argument count. Please input from 2 to 4 arguments.\n");
                break;
        }

        // Output the final result only if number of arguments is 2, 3 or 4
        if ((parsedStringArray.length > 1) & (parsedStringArray.length < 5)) {
            System.out.print("Lowest of input numbers is " + result + ".\n");
        }
    }
}