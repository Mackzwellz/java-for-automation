package com.sperasoft.java_fundamentals.mandatory.task_2;

import java.util.Arrays; // used only in printArray()
import java.util.Random;
import java.util.Scanner;

public class ArraySearch {

    // ask in console
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
        double regularSortingTimeInSeconds = (finishNanoRegular - startNanoRegular) / 1e+9;
        System.out.println("Lookup for int in array using \"for\" loop:\n result is \"" + resultRegular + "\", execution took " + String.format("%.3f", regularSortingTimeInSeconds) + " s.");

        /* Clone initial array (to have clear results), then sort (to be able use binary search) */
        long startNanoBinarySorting = System.nanoTime();
        int[] arrayOfRandomIntsSorted = cloneAndSortArray(arrayOfRandomInts);

        /* Run and benchmark: binary lookup */
        long startNanoBinaryLookup = System.nanoTime();
        boolean resultBinary = findNumberInArrayBinary(arrayOfRandomIntsSorted, numberToSearchFor, 0, arrayOfRandomIntsSorted.length - 1);
        long finishNanoBinaryLookup = System.nanoTime();

        // move constant to top or use TimeUnit (better)

        double binarySortingTimeInSeconds = (startNanoBinaryLookup - startNanoBinarySorting) / 1e+9;
        double binaryLookupTimeInSeconds = (finishNanoBinaryLookup - startNanoBinaryLookup) / 1e+9;
        System.out.println("Lookup using binary search:\n result is \"" + resultBinary + "\", array sorting took "
                + String.format("%.3f", binarySortingTimeInSeconds) + " s, lookup took " + String.format("%.3f", binaryLookupTimeInSeconds) + " s.");

    }

    private static void fillArray(int[] arrayToFill) {

        Random randomGen = new Random();
        for (int i = 0; i < arrayToFill.length; i++) {
            /* restricting RNG */
            arrayToFill[i] = randomGen.nextInt(RNG_CEILING) - RNG_OFFSET;
        }
    }

    private static void printArray(int[] arrayToPrint) {

        System.out.println("Printing array of " + arrayToPrint.length + " elements:");
        System.out.println(Arrays.toString(arrayToPrint));

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

    private static boolean findNumberInArrayBinary(int[] sortedArray, int key, int low, int high) {

        boolean isNumberInArray = false;

        do {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                isNumberInArray = true;
                break;
            }
        } while (low <= high);

        return isNumberInArray;
    }

    private static int[] cloneAndSortArray(int[] arrayToSort) {

        int[] arraySorted = arrayToSort.clone();
        MyQuickSort.sortQ(arraySorted);
        return arraySorted;
    }

    // borrowed code to have reasonably fast sort without using Array.sort()
    public static class MyQuickSort {

        private static int[] array;

        static void sortQ(int[] inputArr) {

            if (inputArr == null || inputArr.length == 0) {
                return;
            }
            array = inputArr;
            int length = inputArr.length;
            quickSort(0, length - 1);
        }

        private static void quickSort(int lowerIndex, int higherIndex) {

            int i = lowerIndex;
            int j = higherIndex;
            // calculate pivot number, I am taking pivot as middle index number
            int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
            // Divide into two arrays
            while (i <= j) {
                /**
                 * In each iteration, we will identify a number from left side which
                 * is greater then the pivot value, and also we will identify a number
                 * from right side which is less then the pivot value. Once the search
                 * is done, then we exchange both numbers.
                 */
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    exchangeNumbers(i, j);
                    //move index to next position on both sides
                    i++;
                    j--;
                }
            }
            // call quickSort() method recursively
            if (lowerIndex < j)
                quickSort(lowerIndex, j);
            if (i < higherIndex)
                quickSort(i, higherIndex);
        }

        private static void exchangeNumbers(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

}
