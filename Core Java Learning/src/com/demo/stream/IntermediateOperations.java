package com.demo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {

    // Entry point (standard signature should be: public static void main(String[] args))
    static void main() {

        /*
         * Intermediate Operations
         * -----------------------
         * Intermediate operations transform a stream into another stream.
         *
         * Key Characteristics:
         * 1. They are LAZY
         * 2. They do not execute until a TERMINAL operation is called
         * 3. They return another stream
         */

        // 1. filter()

        List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Ghanshyam", "Akshit");

        /*
         * filter()
         * --------
         * Used to select elements that match a condition.
         */

        Stream<String> filteredStream = list.stream()
                .filter(x -> x.startsWith("A"));

        // No filtering happens here because there is no terminal operation yet.

        long res = list.stream()
                .filter(x -> x.startsWith("A"))
                .count(); // Terminal operation

        System.out.println(res);


        // 2. map()

        /*
         * map()
         * -----
         * Transforms each element of the stream.
         */

        Stream<String> stringStream = list.stream()
                .map(String::toUpperCase);


        // 3. sorted()

        /*
         * sorted()
         * --------
         * Sorts elements in natural order
         */

        Stream<String> sortedStream = list.stream().sorted();

        /*
         * sorted(Comparator)
         * ------------------
         * Custom sorting using comparator
         */

        Stream<String> sortedStreamUsingComparator =
                list.stream().sorted((a, b) -> a.length() - b.length());


        // 4. distinct()

        /*
         * distinct()
         * ----------
         * Removes duplicate elements
         */

        System.out.println(
                list.stream()
                        .filter(x -> x.startsWith("A"))
                        .distinct()
                        .count()
        );


        // 5. limit()

        /*
         * limit(n)
         * --------
         * Limits the stream to first n elements
         */

        System.out.println(
                Stream.iterate(1, x -> x + 1)
                        .limit(100)
                        .count()
        );


        // 6. skip()

        /*
         * skip(n)
         * -------
         * Skips first n elements
         */

        System.out.println(
                Stream.iterate(1, x -> x + 1)
                        .skip(10)
                        .limit(100)
                        .count()
        );


        // 7. peek()

        /*
         * peek()
         * ------
         * Performs an action on each element as it flows through the stream.
         * Mostly used for debugging.
         */

        Stream.iterate(1, x -> x + 1)
                .skip(10)
                .limit(100)
                .peek(System.out::println)
                .count();


        // 8. flatMap()

        /*
         * flatMap()
         * ---------
         * Used when stream elements are themselves collections.
         *
         * It flattens nested structures into a single stream.
         */

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );

        // Accessing element normally
        System.out.println(listOfLists.get(1).get(1));

        /*
         * Flatten nested lists into one stream
         */

        System.out.println(
                listOfLists.stream()
                        .flatMap(x -> x.stream())
                        .map(String::toUpperCase)
                        .toList()
        );


        /*
         * Example with sentences
         */

        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatMap is useful"
        );

        System.out.println(
                sentences.stream()
                        .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                        .map(String::toUpperCase)
                        .toList()
        );
    }
}