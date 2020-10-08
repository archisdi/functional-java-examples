package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FP07 {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Boot", "Is", "Cool");

        String course = courses.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining("::"));
        System.out.println(course);

        // split and print
        Arrays.stream(course.split("::")).map(String::toLowerCase).forEach(System.out::println);

        // * Parallelization
        long time = System.currentTimeMillis();
        long sum = LongStream
                .range(0, 100000000)
                .parallel()
                .sum();

        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - time);
    }
}
