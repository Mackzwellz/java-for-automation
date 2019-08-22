package com.sperasoft.java_fundamentals.mandatory.task_1;

public class FindTheMinimum {

    private static int findMinOf2(int a, int b) {
        int lowestIntOf2;
        lowestIntOf2 = (a < b) ? a : b;
        System.out.print("Lowest of " + a + " and " + b + " is " + lowestIntOf2
                + ".\n");
        return lowestIntOf2;
    }

    private static int findMinOf3(int a, int b, int c) {
        int lowestIntOf2;
        int lowestIntOf3;
        lowestIntOf2 = findMinOf2(a, b);
        lowestIntOf3 = (c < lowestIntOf2) ? c : lowestIntOf2;
        System.out.print("Lowest of " + a + ", " + b + " and " + c + " is "
                + lowestIntOf3 + ".\n");
        return lowestIntOf3;
    }

    private static int findMinOf4(int a, int b, int c, int d) {
        int lowestIntOf3;
        int lowestIntOf4;
        lowestIntOf3 = findMinOf3(a, b, c);
        lowestIntOf4 = (d < lowestIntOf3) ? d : lowestIntOf3;
        System.out.print("Lowest of " + a + ", " + b + ", " + c + " and " + d
                + " is " + lowestIntOf4 + ".\n");
        return lowestIntOf4;
    }

    public static void main(String[] mainArgs) {
        // Compile and use:
        // javac Practice1Minimum.java
        // java Practice1Minimum 123 1234 12 1

        int x = mainArgs.length;
        int[] parsedMain = new int[x];
        int result = 0;

        for (int i = 0; i < x; i++) {
            parsedMain[i] = Integer.parseInt(mainArgs[i]);
        }

        switch (x) {
            case 2:
                result = findMinOf2(parsedMain[0], parsedMain[1]);
                break;
            case 3:
                result = findMinOf3(parsedMain[0], parsedMain[1],
                        parsedMain[2]);
                break;
            case 4:
                result = findMinOf4(parsedMain[0], parsedMain[1],
                        parsedMain[2], parsedMain[3]);
                break;
            default:
                System.out.print("Invalid argument count. Please input from 2 to 4 arguments.\n");
                break;
        }

        // Output the final result only if number of arguments is 2, 3 or 4
        if ((x > 1) & (x < 5)) {
            System.out.print("Lowest of input numbers is " + result + ".\n");
        }
    }
}