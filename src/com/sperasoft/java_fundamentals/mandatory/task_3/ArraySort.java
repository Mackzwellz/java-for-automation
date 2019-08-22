package com.sperasoft.java_fundamentals.mandatory.task_3;

/* Compile and use:
javac Practice3ArraySort.java
java Practice3ArraySort
input "10000" in console

change CEILING and OFFSET constants if you need to have different values in array
*/


import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class ArraySort {

    /*
     * Constants to be used for RNG in fillArray() method
     * https://stackoverflow.com/questions/66066/what-is-the-best-way-to-
     * implement-constants-in-java
     */
    private static final int RNG_CEILING = 80000;
    private static final int RNG_OFFSET = 40000;

    public static void main(String[] mainArgs) {

        // https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/
        System.out.println("Input a number that will determine how many elements will be in array:");
        int arraySize = Integer.parseInt(System.console().readLine());

        /* Create and fill an array based on input size */
        int[] arrayOfRandomInts = new int[arraySize];
        fillArray(arrayOfRandomInts);

        //System.out.print( "\nInitial array:\n" );
        //printArray( arrayOfRandomInts );
        //System.out.println( "===========================" );

        /* Clone, sort and measure */
        cloneAndBubbleOptSortArray(arrayOfRandomInts);
        cloneAndInsertSortArray(arrayOfRandomInts);
        cloneAndDefaultSortArray(arrayOfRandomInts);

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

    /*
     * Sorting algorithms reference:
     * http://www.algomation.com/algorithm/bubble-sort-optimized - live graph of
     * sort iterations
     * http://www.algomation.com/player?algorithm=545ebe9d01f03a02007b1019
     * (insertion sort) https://www.geeksforgeeks.org/sorting-algorithms/ - lots
     * of links and info http://www.java2novice.com/java-sorting-algorithms/
     * https://brilliant.org/wiki/sorting-algorithms/ - great site
     * https://www.javatpoint.com/sorting-algorithms
     * https://java2blog.com/sorting-algorithms-java/
     */

    private static void cloneAndBubbleOptSortArray(int[] arrayOfRandomInts) {
        int[] arraySorted = arrayOfRandomInts.clone();

        Instant startInstant = Instant.now();

        doBubbleSort(arraySorted);

        Instant finishInstant = Instant.now();
        System.out.print("Sorted using BubbleOptSort. ");
        System.out.print("Execution took "
                + Duration.between(startInstant,
                finishInstant).toNanos()
                + " ns.\n");
        //printArray( arraySorted );
    }

    private static void cloneAndInsertSortArray(int[] arrayOfRandomInts) {
        int[] arraySorted = arrayOfRandomInts.clone();

        Instant startInstant = Instant.now();

        doInsertionSort(arraySorted);

        Instant finishInstant = Instant.now();
        System.out.print("Sorted using InsertSort. ");
        System.out.print("Execution took "
                + Duration.between(startInstant,
                finishInstant).toNanos()
                + " ns.\n");
        //printArray( arraySorted );
    }

    private static void cloneAndDefaultSortArray(int[] arrayOfRandomInts) {
        int[] arraySortedDefault = arrayOfRandomInts.clone();

        Instant startInstant = Instant.now();

        Arrays.sort(arraySortedDefault);

        Instant finishInstant = Instant.now();

        System.out.print("Sorted using Arrays.sort. ");
        System.out.print("Execution took "
                + Duration.between(startInstant,
                finishInstant).toNanos()
                + " ns.\n");
        //printArray( arraySortedDefault );
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
