package io.github.mackzwellz.jfa.objects.mandatory.obj_task_3;

import java.util.Arrays;
import java.util.Scanner;

public class DogDemo {

    public static String[] getDogInputFromConsole() {
        System.out.println("Input amount of dogs to generate and list of names for the dogs divided by whitespace (e.g. 10 DogName1 Dogname2):");
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        return inputString.split(" ");
    }

    public static void main(String[] args) {
        String[] dogInput;
        if (args.length > 0) {
            dogInput = args;
        } else {
            dogInput = getDogInputFromConsole();
        }

        Dog[] dogs = new Dog[Integer.parseInt(dogInput[0])];

        for (int i = 0; i < dogs.length; i++) {
            try {
                dogs[i] = new Dog(dogInput[i + 1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Caught ArrayIndexOutOfBoundsException using index [" + i + 1 + "] from input array," +
                        "assuming user didn't input enough names. Creating a dog with a random name.");
                dogs[i] = new Dog();
            }
        }

        System.out.println("\nSorted dogs:");
        Arrays.sort(dogs);
        for (Dog d : dogs) {
            d.logCurrentDog();
        }
    }
}
