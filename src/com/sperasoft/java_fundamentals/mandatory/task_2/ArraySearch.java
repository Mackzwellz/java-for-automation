package com.sperasoft.java_fundamentals.mandatory.task_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraySearch {

    private static final int RNG_CEILING = 800000;
    private static final int RNG_OFFSET = 400000;

    /* Note: for some reason, running this program from terminal produces finer results than using "Run" in IDE. */

    public static void main(String[] mainArgs) {

        System.out.println("Input a sequence of 2 numbers, divided by whitespace (e.g. 1000000 399999).");
        System.out.println("First determines array size, second is the number to search for in array:");

        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        int numberToSearchFor = scan.nextInt();
        scan.close();

        int[] arrayOfRandomInts = new int[arraySize];
        fillArray(arrayOfRandomInts);

        /* Run and benchmark: regular lookup */
        long startNanoRegular = System.nanoTime();
        boolean resultRegular = findNumberInArrayRegular(arrayOfRandomInts, numberToSearchFor);
        long finishNanoRegular = System.nanoTime();
        double regularSortingTimeInSeconds = ( finishNanoRegular - startNanoRegular ) / 1e+9;
        System.out.println("Lookup for int in array using \"for\" loop:\n result is \"" + resultRegular + "\", execution took " + String.format("%.3f", regularSortingTimeInSeconds) + " s.");

        /* Clone initial array (to have clear results), then sort (to be able use binary search) */
        long startNanoBinarySorting = System.nanoTime();
        int[] arrayOfRandomIntsSorted = cloneAndSortArray(arrayOfRandomInts);

        /* Run and benchmark: binary lookup */
        long startNanoBinaryLookup = System.nanoTime();
        boolean resultBinary = findNumberInArrayBinary(arrayOfRandomIntsSorted, numberToSearchFor);
        long finishNanoBinaryLookup = System.nanoTime();
        double binarySortingTimeInSeconds = (startNanoBinaryLookup - startNanoBinarySorting) / 1e+9;
        double binaryLookupTimeInSeconds = (finishNanoBinaryLookup - startNanoBinaryLookup) / 1e+9;
        System.out.println("Lookup using binary search:\n result is \"" + resultBinary + "\", array sorting took "
                + String.format("%.3f", binarySortingTimeInSeconds) + " s, lookup took " +String.format("%.3f", binaryLookupTimeInSeconds) + " s.");

    }

    private static int[] fillArray(int[] arrayToFill) {

        Random randomGen = new Random();
        for (int i = 0; i < arrayToFill.length; i++) {
            /* restricting RNG */
            arrayToFill[i] = randomGen.nextInt(RNG_CEILING) - RNG_OFFSET;
        }
        /* return statement is not used, maybe it should be removed along with method type? int[] -> void */
        return arrayToFill;
    }

    private static void printArray(int[] arrayToPrint) {

        System.out.println("Printing array of " + arrayToPrint.length
                + " elements:");
        // System.out.println(Arrays.toString(arrayToPrint));
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.print("Element " + i + " : " + arrayToPrint[i]
                    + ".\n");
        }
    }

    private static boolean findNumberInArrayRegular(int[] arrayToSearchIn,
                                                    int numberToSearchFor) {
        boolean isNumberInArray = false;

        for (int value : arrayToSearchIn) {
            if (value == numberToSearchFor) {
                isNumberInArray = true;
                break;
            }
        }

        return isNumberInArray;
    }

    private static boolean findNumberInArrayBinary(int[] arrayToSearchIn,
                                                   int numberToSearchFor) {
        boolean isNumberInArray = false;

        int bsResult = Arrays.binarySearch(arrayToSearchIn,
                numberToSearchFor);
        if (bsResult > 0) {
            isNumberInArray = true;
        }
        return isNumberInArray;
    }

    private static int[] cloneAndSortArray(int[] arrayToSort) {
        int[] arraySorted = arrayToSort.clone();
        Arrays.sort(arraySorted);
        return arraySorted;
    }


}
