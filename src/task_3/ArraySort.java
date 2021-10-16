package task_3;

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
import java.util.Scanner;

public class ArraySort {

    /*
    * Constants to be used for RNG in fillArray() method
    * https://stackoverflow.com/questions/66066/what-is-the-best-way-to-implement-constants-in-java
    */
    private static final int RNG_CEILING = 80000;
    private static final int RNG_OFFSET = 40000;

    public static void main(String[] mainArgs) {

        // Reading input from user. Console works only whe using "Terminal" in IDEA
        // https://stackoverflow.com/questions/5287538/how-can-i-get-the-user-input-in-java
        // https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/

        System.out.println("Input a number that will determine how many elements will be in array (e.g. 10000):");
        Scanner scan = new Scanner(System.in);

        /* Parse inputs */
        int arraySize = scan.nextInt();
        scan.close();

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


    /* Time measurement:
    * https://stackoverflow.com/questions/1712205/current-time-in-microseconds-in-java
    * https://www.baeldung.com/java-measure-elapsed-time
    * https://howtodoinjava.com/java/date-time/execution-elapsed-time/
    * https://www.techiedelight.com/measure-elapsed-time-execution-time-java/
    *
    * Note: for some reason running this program from terminal produces finer results than using "Run" in IDE.
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
        int[] arraySorted = arrayOfRandomInts.clone();

        Instant startInstant = Instant.now();

        Arrays.sort(arraySorted);

        Instant finishInstant = Instant.now();

        System.out.print("Sorted using Arrays.sort. ");
        System.out.print("Execution took "
                + Duration.between(startInstant,
                finishInstant).toNanos()
                + " ns.\n");
        printArray( arraySorted );
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
