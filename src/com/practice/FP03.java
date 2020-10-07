package com.practice;

import java.util.List;
import java.util.Random;
import java.util.function.*;

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

        // takes one input and not return anything
        // Consumer<Integer> print = System.out::println;
        Consumer<Integer> print = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println(number);
            }
        };

        // takes two input with same type and returns a value with also the same type
        // BinaryOperator<Integer> sum = Integer::sum;
        BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer prev, Integer next) {
                return prev + next;
            }
        };

        // No input and return something
        // Supplier<Integer> randomInteger = () -> new Random().nextInt(100);
        Supplier<Integer> randomInteger = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(100);
            }
        };
        System.out.println(randomInteger.get());

        // takes one input and returns a value with the same type
        // UnaryOperator<Integer> multiple = x -> x * 2;
        UnaryOperator<Integer> multiple = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 3;
            }
        };
        System.out.println(multiple.apply(2));

        // takes two params and returns boolean
        BiPredicate<Integer, String> biPredicate = (nbr, str) -> {
            return nbr < 10 && str.length() > 5;
        };
        System.out.println(biPredicate.test(5, "archie isdiningrat"));

        // takes two params and return a defined type
        BiFunction<Integer, String, Boolean> biFunction = (nbr, str) -> {
            return nbr < 10 && str.length() > 5;
        };
        System.out.println(biFunction.apply(5, "archie isdiningrat"));

        // takes two params and return void
        BiConsumer<Integer, String> biConsumer = (nbr, str) -> {
            System.out.println(nbr < 10 && str.length() > 5);
        };
        biConsumer.accept(5, "archie isdiningrat");

        numbers.stream().filter(isEven).map(squared).forEach(print);
        Integer reduce = numbers.stream().reduce(0, sum);
        System.out.println(reduce);

        // * etc in java.util.function
    }
}
