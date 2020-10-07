package com.practice;

import java.util.List;
import java.util.function.Predicate;

public class FP04 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,54,33,2,332);

        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        Predicate<Integer> oddPredicate = x -> x % 2 != 0;

        // * Duplication !
        // numbers.stream().filter(evenPredicate).forEach(System.out::println);
        // numbers.stream().filter(oddPredicate).forEach(System.out::println);

        // * Behavior Parameterization
        filterAndPrint(numbers, evenPredicate);
        filterAndPrint(numbers, oddPredicate);
    }

    public static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
