package io.github.mackzwellz.jfa.b_objects.mandatory.obj_task_2;

import java.util.Scanner;

public class ClockDemo {

    public static void main(String[] args) {
        System.out.println("\nFirst clock, ticking up:");
        int[] clock1values = getClockInputFromConsole(1);
        Clock firstClock = new Clock(clock1values[0]);
        //Clock firstClock = new Clock(12471);
        for (int i = 0; i < 10; i++) {
            firstClock.tick();
            firstClock.logCurrentTime();
        }

        int[] clock2values = getClockInputFromConsole(3);
        System.out.println("\nSecond clock, ticking down:");
        Clock secondClock = new Clock(clock2values[0],clock2values[1],clock2values[2]);
        //Clock secondClock = new Clock(23, 59, 56);
        for (int i = 0; i < 10; i++) {
            secondClock.tickDown();
            secondClock.logCurrentTime();
        }

        System.out.println("\nBoth clocks:");
        firstClock.logCurrentTime();
        secondClock.logCurrentTime();

        System.out.println("\nAdd 2 to 1 and check both:");
        firstClock.addClock(secondClock);
        firstClock.logCurrentTime();
        secondClock.logCurrentTime();

        System.out.println("\nCreate 3rd clock by subtracting 2 from 1 and check all:");
        Clock thirdClock = firstClock.subtractClock(secondClock);
        firstClock.logCurrentTime();
        secondClock.logCurrentTime();
        thirdClock.logCurrentTime();
    }

    public static int[] getClockInputFromConsole(int n) {
        if (n==1) {
            System.out.println("Input 1 number (e.g. 76535) to be used as seconds since midnight for a clock:");
        } else {
            System.out.println("Input a sequence of 3 numbers divided by whitespace (e.g. 23 24 25) to be used as hh,mm,ss for a clock:");
        }
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        String[] splitStringArray = inputString.split(" ");
        int[] parsedStringArray = new int[splitStringArray.length];
        for (int i = 0; i < splitStringArray.length; i++) {
            parsedStringArray[i] = Integer.parseInt(splitStringArray[i]);
        }
        return parsedStringArray;
    }
}
