package com.practice;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        printNumberListStructured(List.of(1,2,3,4,5,54,33,2,332));
    }

    private static void printNumberListStructured(List<Integer> numbers) {
        // how to loop the numbers
        for (Integer i: numbers) {
            System.out.println(i);
        }
    }
}
