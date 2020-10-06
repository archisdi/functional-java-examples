package com.practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Structured {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,54,33,2,332);
        int sum = addListFunctional(numbers);
        List<Integer> doubles = doubleNumbers(numbers);

        System.out.println(sum);
        System.out.println(doubles);
    }

    private static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(i -> i * i)
                .collect(Collectors.toList()); // get value to list with collectors
    }

    private static int sum(Integer aggregate, Integer nextValue) {
        return aggregate + nextValue;
    }

    private static int addListFunctional(List<Integer> numbers) {
        // FP02Structured::sum
        // Comparator.comparing -> custom comparator with lambda
        // sorted and distinct is returning Stream<T>
        return numbers
                .stream()
                .sorted(Comparator.naturalOrder()) // sort elements, can use custom comparator
                .distinct() // unique filter
                .reduce(0, Integer::sum);
    }

    private static int addListStructured(List<Integer> numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }
}
