package com.demo.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class MainController {

    // Entry point (standard signature should be: public static void main(String[] args))
    static void main() {

        /*
         * Collectors
         * ----------
         * Collectors is a utility class in java.util.stream package.
         *
         * It provides many methods used with stream().collect()
         * to transform stream elements into collections, maps, strings, or statistics.
         */

        // 1. Collecting to a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        List<String> res = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(res);


        // 2. Collecting to a Set
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        Set<Integer> set = nums.stream()
                .collect(Collectors.toSet());

        System.out.println(set);


        // 3. Collecting to a Specific Collection

        /*
         * toCollection()
         * Allows collecting into a specific collection type
         */

        ArrayDeque<String> collect =
                names.stream()
                        .collect(Collectors.toCollection(ArrayDeque::new));


        // 4. Joining Strings

        /*
         * joining()
         * Concatenates elements into a single string
         */

        String concatenatedNames =
                names.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.joining(", "));

        System.out.println(concatenatedNames);


        // 5. Summarizing Data

        /*
         * summarizingInt()
         * Produces statistics like:
         * count, sum, min, average, max
         */

        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);

        IntSummaryStatistics stats =
                numbers.stream()
                        .collect(Collectors.summarizingInt(x -> x));

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());


        // 6. Calculating Average

        Double average =
                numbers.stream()
                        .collect(Collectors.averagingInt(x -> x));

        System.out.println("Average: " + average);


        // 7. Counting Elements

        Long count =
                numbers.stream()
                        .collect(Collectors.counting());

        System.out.println("Count: " + count);


        // 8. Grouping Elements

        /*
         * groupingBy()
         * Groups elements based on a key
         */

        List<String> words =
                Arrays.asList("hello", "world", "java", "streams", "collecting");

        // Group by word length
        System.out.println(
                words.stream().collect(Collectors.groupingBy(String::length))
        );

        // Join words of same length
        System.out.println(
                words.stream().collect(Collectors.groupingBy(
                        String::length,
                        Collectors.joining(", ")
                ))
        );

        // Count words by length
        System.out.println(
                words.stream().collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                ))
        );

        // Custom Map implementation
        TreeMap<Integer, Long> treeMap =
                words.stream().collect(
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,
                                Collectors.counting()
                        )
                );

        System.out.println(treeMap);


        // 9. Partitioning Elements

        /*
         * partitioningBy()
         * Splits elements into two groups (true / false)
         */

        System.out.println(
                words.stream()
                        .collect(Collectors.partitioningBy(x -> x.length() > 5))
        );


        // 10. Mapping and Collecting

        /*
         * mapping()
         * Applies transformation before collecting
         */

        System.out.println(
                words.stream().collect(
                        Collectors.mapping(
                                x -> x.toUpperCase(),
                                Collectors.toList()
                        )
                )
        );


        // 11. toMap()

        /*
         * Converts stream elements into a Map
         */

        List<String> fruits =
                Arrays.asList("Apple", "Banana", "Cherry");

        System.out.println(
                fruits.stream().collect(
                        Collectors.toMap(
                                x -> x.toUpperCase(),
                                x -> x.length()
                        )
                )
        );


        // Example: Counting word occurrences

        String sentence = "hello world hello java world";

        System.out.println(
                Arrays.stream(sentence.split(" "))
                        .collect(Collectors.groupingBy(
                                x -> x,
                                Collectors.counting()
                        ))
        );


        // Example: Partition even and odd numbers

        List<Integer> l2 =
                Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(
                l2.stream()
                        .collect(Collectors.partitioningBy(x -> x % 2 == 0))
        );


        // Example: Summing values from a Map

        Map<String, Integer> items = new HashMap<>();

        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);

        // Using reduce
        System.out.println(items.values().stream().reduce(Integer::sum));

        // Using collector
        System.out.println(
                items.values().stream()
                        .collect(Collectors.summingInt(x -> x))
        );


        // Example: Counting duplicate words

        List<String> words2 =
                Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        System.out.println(
                words2.stream()
                        .collect(Collectors.toMap(
                                k -> k,
                                v -> 1,
                                (x, y) -> x + y
                        ))
        );
    }
}