package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FP06 {
    public static void main(String[] args) {
        // * Primitive Stream
        int[] numbers = { 1,2,3,4,5 };
        int sum = Arrays.stream(numbers).sum();

        // other options
        IntStream.of(numbers).forEach(System.out::println);

        // custom iterator
        List<Integer> res = IntStream.iterate(1, e -> e + 2)
                .limit(10)
                .peek(System.out::println)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(res);
    }
}
