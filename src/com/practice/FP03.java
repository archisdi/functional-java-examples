package com.practice;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,54,33,2,332);

        // * Functional Interfaces

        // Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };

        // Function<Integer, Integer> squared = x -> x * x;
        Function<Integer, Integer> squared = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * number;
            }
        };

        // Consumer<Integer> print = System.out::println;
        Consumer<Integer> print = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println(number);
            }
        };

        // BinaryOperator<Integer> sum = Integer::sum;
        BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer prev, Integer next) {
                return prev + next;
            }
        };

        numbers.stream()
                .filter(isEven)
                .map(squared)
                .forEach(print);

        Integer reduce = numbers.stream().reduce(0, sum);
        System.out.println(reduce);
    }
}
