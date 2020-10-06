package com.practice;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,54,33,2,332);
//        printNumberListStructured(numbers);
        printNumberListFunctional(numbers);
        printNumberListSquared(numbers);
    }

    private static void print(Integer number) {
        System.out.println(number);
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    private static void printNumberListStructured(List<Integer> numbers) {
        // focus on how to loop the numbers
        for (Integer i: numbers) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    private static void printNumberListFunctional(List<Integer> numbers) {
        // focus on what to do to the numbers
        // FP01Structured::isEven => method reference
        numbers.stream() // convert numbers into streams
                .filter(number -> number % 2 == 0) // lambda expression
                .forEach(System.out::println);
    }

    private static void printNumberListSquared(List<Integer> numbers) {
        numbers.stream()
                .map(i -> i * i) // change every value of element in list
                .forEach(System.out::println);
    }
}
