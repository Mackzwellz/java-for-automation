package com.sperasoft.java_fundamentals.mandatory.task_4;

import java.util.Scanner;

public class CountSymbolOccurrence {

    public static void main(String[] args) {

        String stringToSearchIn = "_1_234561_2345_16asdfaaddssa\n" +
                "#~`!`~ ノಠ益ಠノ彡┻━┻ Angry Table-flIp\t" +
                "`~!@#$%^&*(){}[]/\\<>?.,\"\"'':;_-+=№|\n" +
                "√Ω≈ç∫∞§…¬å∑± a \n" +
                "\uD83D\uDC69\uD83C\uDFFF 1238 ＝═⚌﹦ https://аррӏе.com\n";

        System.out.println(stringToSearchIn);
        System.out.println("Input a symbol to search for in above text:");

        Scanner scan = new Scanner(System.in);
        char symbolToSearchFor = scan.next().charAt(0);
        scan.close();

        findAndCountSymbolInString(stringToSearchIn, symbolToSearchFor);
    }

    private static void findAndCountSymbolInString(String stringToSearchIn,
                                                   char symbolToSearchFor) {
        int numberOfOccurrences = 0;

        for (int i = 0; i < stringToSearchIn.length(); i++) {
            if (stringToSearchIn.charAt(i) == symbolToSearchFor) {
                numberOfOccurrences++;
            }
        }
            System.out.println("Symbol \"" + symbolToSearchFor + "\" is found " + numberOfOccurrences + " times in above text.");

    }
}
