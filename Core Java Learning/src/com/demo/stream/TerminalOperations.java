package com.demo.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

    // Entry point (standard signature: public static void main(String[] args))
    static void main() {

        List<Integer> list = Arrays.asList(1, 2, 3);

        /*
         * Terminal Operations
         * -------------------
         * Terminal operations produce a result or side-effect.
         * Once a terminal operation is executed, the stream pipeline is closed.
         */

        // 1. collect()

        /*
         * collect()
         * ---------
         * Used to transform stream elements into a collection.
         */

        list.stream().skip(1).collect(Collectors.toList());

        // Java 16+ simplified version
        list.stream().skip(1).toList();


        // 2. forEach()

        /*
         * forEach()
         * ---------
         * Performs an action on each element of the stream.
         */

        list.stream().forEach(x -> System.out.println(x));


        // 3. reduce()

        /*
         * reduce()
         * --------
         * Combines stream elements into a single value.
         */

        Optional<Integer> optionalInteger = list.stream().reduce(Integer::sum);

        System.out.println(optionalInteger.get());


        // 4. count()

        /*
         * count()
         * -------
         * Counts the number of elements in the stream.
         */

        long count = list.stream().count();


        // 5. anyMatch(), allMatch(), noneMatch()

        /*
         * anyMatch()
         * Returns true if ANY element matches the condition
         */

        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);

        /*
         * allMatch()
         * Returns true if ALL elements match the condition
         */

        boolean b1 = list.stream().allMatch(x -> x > 0);
        System.out.println(b1);

        /*
         * noneMatch()
         * Returns true if NO elements match the condition
         */

        boolean b2 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b2);


        // 6. findFirst() / findAny()

        /*
         * findFirst()
         * Returns first element of the stream
         */

        System.out.println(list.stream().findFirst().get());

        /*
         * findAny()
         * Returns any element (useful for parallel streams)
         */

        System.out.println(list.stream().findAny().get());


        // 7. toArray()

        Object[] array = Stream.of(1, 2, 3).toArray();


        // 8. min() / max()

        /*
         * max()
         * Returns maximum element
         */

        System.out.println("max: " +
                Stream.of(2, 44, 69).max((o1, o2) -> o2 - o1));

        /*
         * min()
         * Returns minimum element
         */

        System.out.println("min: " +
                Stream.of(2, 44, 69).min(Comparator.naturalOrder()));


        // 9. forEachOrdered()

        List<Integer> numbers0 =
                Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println("Using forEach with parallel stream:");

        numbers0.parallelStream()
                .forEach(System.out::println);

        /*
         * forEachOrdered()
         * Maintains order even in parallel streams
         */

        System.out.println("Using forEachOrdered with parallel stream:");

        numbers0.parallelStream()
                .forEachOrdered(System.out::println);



        // Example: Filtering and Collecting Names

        List<String> names =
                Arrays.asList("Anna", "Bob", "Charlie", "David");

        System.out.println(
                names.stream()
                        .filter(x -> x.length() > 3)
                        .toList()
        );



        // Example: Squaring and Sorting Numbers

        List<Integer> numbers =
                Arrays.asList(5, 2, 9, 1, 6);

        System.out.println(
                numbers.stream()
                        .map(x -> x * x)
                        .sorted()
                        .toList()
        );


        // Example: Summing Values

        List<Integer> integers =
                Arrays.asList(1,2,3,4,5);

        System.out.println(
                integers.stream()
                        .reduce(Integer::sum)
                        .get()
        );


        // Example: Counting Occurrences of Character

        String sentence = "Hello world";

        System.out.println(
                sentence.chars()
                        .filter(x -> x == 'l')
                        .count()
        );


        // Stream Reuse Problem

        /*
         * Streams cannot be reused after terminal operation
         */

        Stream<String> stream = names.stream();

        stream.forEach(System.out::println);

        // This will throw exception
        // stream.map(String::toUpperCase).toList();


        /*
         * Stateful vs Stateless operations
         *
         * Stateless:
         * map(), filter()
         *
         * Stateful:
         * sorted(), distinct()
         */
    }
}