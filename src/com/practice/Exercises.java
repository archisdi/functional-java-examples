package com.practice;

import java.util.List;
import java.util.function.Function;

public class Exercises {
    public static void main(String[] args) {
        // * 1
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        PrintOdd(numbers, i -> i * i * i);

        // * 2
        List<String> courses = List.of("Spring", "Boot", "Is", "Cool");
        PrintString(courses);

    }

    private static void PrintString(List<String> strings) {
        strings.stream()
                .filter(item -> item.length() >= 4)
//                .filter(item -> item.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void PrintOdd(List<Integer> numbers, Function<Integer, Integer> mapper) {
        numbers.stream()
                .filter(item -> item % 2 != 0)
                .map(mapper)
                .forEach(System.out::println);
    }
}
