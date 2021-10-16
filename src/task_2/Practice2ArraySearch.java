package task_2;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Practice2ArraySearch {

    /* Constants to be used for RNG in fillArray() method
    https://stackoverflow.com/questions/66066/what-is-the-best-way-to-implement-constants-in-java
     */
    private static final int RNG_CEILING = 80000;
    private static final int RNG_OFFSET = 40000;

    /* Time measurement:
    https://stackoverflow.com/questions/1712205/current-time-in-microseconds-in-java
    https://www.baeldung.com/java-measure-elapsed-time
    https://howtodoinjava.com/java/date-time/execution-elapsed-time/
    https://www.techiedelight.com/measure-elapsed-time-execution-time-java/
     */

    public static void main( String[] mainArgs ) {
        /* Compile and use:
        javac Practice2ArraySearch.java
        java Practice2ArraySearch 100000 39999 (~50/50 true/false, noticeable nanoseconds difference)
        change CEILING and OFFSET above if you need to test different values
        */

        /* Parse inputs */
        int arraySize = Integer.parseInt( mainArgs[0] );
        int numberToSearchFor = Integer.parseInt( mainArgs[1] );

        /* Create and fill an array based on input size */
        int[] arrayOfRandomInts = new int[arraySize];
        fillArray( arrayOfRandomInts );

        /* Output each element of created array to console */
        // printArray( arrayOfRandomInts );

        /* Run and benchmark: regular lookup */
        //long startNanoRegular = System.nanoTime();
        Instant startInstantRegular = Instant.now();
        boolean resultRegular = findNumberInArrayRegular( arrayOfRandomInts, numberToSearchFor );
        Instant finishInstantRegular = Instant.now();
        //long finishNanoRegular = System.nanoTime();

        /* Output execution duration */
        //System.out.println( "Regular value lookup result is \"" + resultRegular + "\", execution took " + ( finishNanoRegular - startNanoRegular ) + " ns." )
        /* finish + output in one string */
        // System.out.println( "Regular value lookup result is \"" + resultRegular + "\", execution took " + Duration.between( start, Instant.now() ).toNanos() + " ns." );

        System.out.println( "Lookup for int in array using \"for\" loop:\n result is \"" + resultRegular + "\", execution took " + Duration.between( startInstantRegular, finishInstantRegular ).toNanos() + " ns." );

        /* Clone initial array (to have clear results), then sort (to be able use binary search) */
        long startNanoBinarySorting = System.nanoTime();
        Instant startInstantBinarySorting = Instant.now();
        int[] arrayOfRandomIntsSorted = cloneAndSortArray( arrayOfRandomInts );
        //Arrays.sort( arrayOfRandomInts );

        /* Run and benchmark: binary lookup */
        //long startNanoBinaryLookup = System.nanoTime();
        Instant startInstantBinaryLookup = Instant.now();
        boolean resultBinary = findNumberInArrayBinary( arrayOfRandomIntsSorted, numberToSearchFor );
        Instant finishInstantBinaryLookup = Instant.now();
        //long finishNanoBinaryLookup = System.nanoTime();
        System.out.println( "Lookup using binary search:\n result is \"" + resultBinary + "\", array sorting took " + Duration.between( startInstantBinarySorting, startInstantBinaryLookup ).toNanos()
                + " ns, lookup took " + Duration.between( startInstantBinaryLookup, finishInstantBinaryLookup ).toNanos() + " ns." );

        /* To debug cloning functionality (does not matter for primitive types) */
        /*
        arrayOfRandomIntsSorted[19] = 32222;
        printArray(arrayOfRandomInts);
        printArray(arrayOfRandomIntsSorted);
        */

    }

    /* Fill and print array: https://www.javamex.com/tutorials/java/arrays_2.shtml */
    private static int[] fillArray( int[] arrayToFill ) {

        Random randomGen = new Random();
        for ( int i = 0; i < arrayToFill.length; i++ ) {
            /* restricting RNG */
            arrayToFill[i] = randomGen.nextInt( RNG_CEILING ) - RNG_OFFSET;
        }
        /* return statement is not used, maybe it should be removed along with method type? int[] -> void */
        return arrayToFill;
    }

    private static void printArray( int[] arrayToPrint ) {

        System.out.println( "Printing array of " + arrayToPrint.length
                + " elements:" );
        // System.out.println(Arrays.toString(arrayToPrint));
        for ( int i = 0; i < arrayToPrint.length; i++ ) {
            System.out.print( "Element " + i + " : " + arrayToPrint[i]
                    + ".\n" );
        }
    }

    /*
    Value lookup in array examples:
    https://stackoverflow.com/questions/1128723/how-do-i-determine-whether-an-array-contains-a-particular-value-in-java
    https://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/
    https://www.mkyong.com/java/java-check-if-array-contains-a-certain-value/
     */

    private static boolean findNumberInArrayRegular( int[] arrayToSearchIn,
                                                     int numberToSearchFor ) {
        boolean isNumberInArray = false;

        /* thanks code analysis, because there was regular "for" loop instead of "foreach" and no "break;" statement */
        for (int value : arrayToSearchIn) {
            if (value == numberToSearchFor) {
                isNumberInArray = true;
                break;
            }
        }

        return isNumberInArray;
    }

    private static boolean findNumberInArrayBinary( int[] arrayToSearchIn,
                                                    int numberToSearchFor ) {
        boolean isNumberInArray = false;

        int bsResult = Arrays.binarySearch( arrayToSearchIn,
                numberToSearchFor );
        if ( bsResult > 0 ) {
            isNumberInArray = true;
        }
        return isNumberInArray;
    }

    /* Object cloning
    https://www.journaldev.com/753/java-copy-array-array-copy-java
    https://stackoverflow.com/questions/46145826/why-clone-is-the-best-way-for-copying-arrays
    http://geekexplains.blogspot.com/2008/06/what-is-cloning-how-clone-method-works.html
     */

    private static int[] cloneAndSortArray( int[] arrayToSort ) {
        //int[] arraySorted = Arrays.copyOf( arrayToSort, arrayToSort.length ); // clone is better
        int[] arraySorted = arrayToSort.clone();
        Arrays.sort( arraySorted );
        return arraySorted;
    }

}
