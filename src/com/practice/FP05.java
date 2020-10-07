package com.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int score;
    private int students;

    public Course(String name, String category, int score, int students) {
        this.name = name;
        this.category = category;
        this.score = score;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", score=" + score +
                ", students=" + students +
                '}';
    }
}


public class FP05 {
    public static void main(String[] args) {
        List<String> courseNames = List.of("Java", "Nodejs", "Golang", "Haskel", "Swift", "Ruby", "Python");

//        Function<String, Course> courseBuilder =
//                name -> new Course(name, "programming", 4, 500);

        List<Course> courses = courseNames.stream()
                .map(FP05::courseBuilder)
                .collect(Collectors.toList());

        boolean allGreater = courses.stream()
                .allMatch(course -> course.getName().length() > 4);
                // .noneMatch()
                // .anyMatch()

        // custom course comparator
        Comparator<Course> courseComparator = Comparator
                .comparing(Course::getScore)
                .thenComparing(Course::getStudents)
                .reversed();

        // sorting with class method
        courses.stream()
                .sorted(courseComparator)
                .skip(2) // skip the first 2 courses
                .limit(3) // only takes 3 courses
                .forEach(System.out::println);

        System.out.println("---");

        // filter until
        courses.stream()
                .takeWhile(course -> course.getScore() > 4)
                // .dropWhile()
                .forEach(System.out::println);

        System.out.println("---");

        // get mix or max value from courses with defined comparator
        Optional<Course> course = courses
                .stream()
                .max(courseComparator);
                // .min(courseComparator);
                // .findFirst() // if multiple found, return the first one
                // .findAny() // if multiple found, randomly choose and return
                // .orElse(new Course()) // if none found, create new course
        System.out.println(course.isPresent() ? course.get() : "no course found");

        int totalStudent = courses.stream()
                .mapToInt(Course::getStudents)
                .sum();
                // .average()
                // .count()
        System.out.println(totalStudent);

        Map<String, List<Course>> hmCourse = course.stream()
                .collect(Collectors.groupingBy(Course::getCategory));
        System.out.println(hmCourse);

        Map<String, Long> courseCount = course.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
        System.out.println(courseCount);
    }

    public static Course courseBuilder(String name) {
        return new Course(
                name,
                "programming",
                new Random().nextInt(10),
                new Random().nextInt(100)
        );
    }
}
