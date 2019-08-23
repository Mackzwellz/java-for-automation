package com.sperasoft.java_fundamentals.mandatory.task_3;

import java.util.Arrays; // used only in printArray()
import java.util.Random;
import java.util.Scanner;

public class ArraySort {

    private static final int RNG_CEILING = 80000;
    private static final int RNG_OFFSET = 40000;

    /* Note: for some reason running this program from terminal produces finer results than using "Run" in IDE. */

    public static void main(String[] mainArgs) {

        System.out.println("Input a number that will determine how many elements will be in array (e.g. 10000):");

        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        scan.close();

        int[] arrayOfRandomInts = new int[arraySize];
        fillArray(arrayOfRandomInts);

        cloneAndBubbleOptSortArray(arrayOfRandomInts);
        cloneAndInsertSortArray(arrayOfRandomInts);

    }

    private static void fillArray(int[] arrayToFill) {

        Random randomGen = new Random();
        for (int i = 0; i < arrayToFill.length; i++) {
            /* restricting RNG */
            arrayToFill[i] = randomGen.nextInt(RNG_CEILING) - RNG_OFFSET;
        }
    }

    private static void printArray(int[] arrayToPrint) {

        System.out.println("Printing array of " + arrayToPrint.length
                + " elements:");
        System.out.println(Arrays.toString(arrayToPrint));
    }

    private static void cloneAndBubbleOptSortArray(int[] arrayOfRandomInts) {

        int[] arraySorted = arrayOfRandomInts.clone();

        long startTimer = System.nanoTime();
        doBubbleSort(arraySorted);
        long finishTimer = System.nanoTime();
        double sortingTimeInSeconds = ( finishTimer - startTimer ) / 1e+9;

        System.out.print("Sorted using BubbleOptSort. ");
        System.out.print("Execution took " + String.format("%.3f", sortingTimeInSeconds) + " s.\n");
    }

    private static void cloneAndInsertSortArray(int[] arrayOfRandomInts) {
        int[] arraySorted = arrayOfRandomInts.clone();

        long startTimer = System.nanoTime();
        doInsertionSort(arraySorted);
        long finishTimer = System.nanoTime();
        double sortingTimeInSeconds = ( finishTimer - startTimer ) / 1e+9;

        System.out.print("Sorted using InsertSort. ");
        System.out.print("Execution took " + String.format("%.3f", sortingTimeInSeconds) + " s.\n");
    }

    /* http://www.java2novice.com/java-sorting-algorithms/insertion-sort/ */
    private static void doInsertionSort(int[] input) {
        int temp;
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
    }

    /* https://stackoverflow.com/questions/16195092/optimized-bubble-sort-java */
    private static void doBubbleSort(int[] arrA) {
        boolean isSwapped;
        int size = arrA.length;
        for (int i = 0; i < size - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                // check the adjacent elements
                if (arrA[j] > arrA[j + 1]) {
                    // swap the elements
                    int temp = arrA[j];
                    arrA[j] = arrA[j + 1];
                    arrA[j + 1] = temp;
                    isSwapped = true;
                }
            }
            // check if any swapping occurred in last iteration
            // if yes then break the loop, array is sorted at this point
            if (!isSwapped) {
                break;
            }
        }
    }
}
