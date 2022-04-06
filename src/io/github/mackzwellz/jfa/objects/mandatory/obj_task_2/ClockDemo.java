package io.github.mackzwellz.jfa.objects.mandatory.obj_task_2;

import java.util.Scanner;

public class ClockDemo {
    public static void main(String[] args) {
        System.out.println("First clock, ticking up:");
        Clock firstClock = new Clock(12471);
        firstClock.logCurrentTime();
        for (int i = 0; i < 10; i++) {
            firstClock.tick();
            firstClock.logCurrentTime();
        }


//        System.out.println("Input a sequence of 3 numbers divided by whitespace (e.g. 23 24 25) to be used as hh,mm,ss for second clock:");
//        Scanner scan = new Scanner(System.in);
//        String inputString = scan.nextLine();
//        String[] splitStringArray = inputString.split(" ");
//        int[] parsedStringArray = new int[splitStringArray.length];
//        for (int i = 0; i < splitStringArray.length; i++) {
//            parsedStringArray[i] = Integer.parseInt(splitStringArray[i]);
//        }
//
//        System.out.println("Second clock, ticking down:");
//        Clock secondClock = new Clock(parsedStringArray[0],parsedStringArray[1],parsedStringArray[2]);

                System.out.println("Second clock, ticking down:");
        Clock secondClock = new Clock(24,0, 5);
        secondClock.logCurrentTime();
        for (int i = 0; i < 10; i++) {
            secondClock.tickDown();
            secondClock.logCurrentTime();
        }

        System.out.println("Both clocks:");
        firstClock.logCurrentTime();
        secondClock.logCurrentTime();

        System.out.println("Add 2 to 1 and check both:");
        firstClock.addClock(secondClock);
        firstClock.logCurrentTime();
        secondClock.logCurrentTime();

        System.out.println("Create 3rd clock by subtracting 2 from 1 and check all:");
        Clock thirdClock = firstClock.subtractClock(secondClock);
        thirdClock.logCurrentTime();
        firstClock.logCurrentTime();
        secondClock.logCurrentTime();
    }
}
