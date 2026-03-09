package com.demo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    static void main() {
        // Intermediate Operations transform a stream into another stream
        // They are lazy, meaning they don't execute until a terminal operation is invoked

        List<String> list = List.of("Pranit", "Pranav", "Pratik", "Prem", "Prakash", "Prem");

        // 1. Filter
        Stream<String> stream = list.stream().filter(x -> x.startsWith("P") && x.toLowerCase().endsWith("t"));
        // no filtering at this point

        long res = list.stream().filter(x -> x.startsWith("P") && x.toLowerCase().endsWith("t")).count();
        System.out.println(res);

        // 2. Map
        List<String> updateList = list.stream().map(String::toUpperCase).toList();
        updateList.forEach(System.out::println);

        // 3. Sorted
        Stream<String> sorted = list.stream().sorted();
        Stream<String> sortedWithComparator = list.stream().sorted((a, b) -> a.length() - b.length());

        sorted.forEach(System.out::println);
        sortedWithComparator.forEach(System.out::println);

        // 4. distinct
        System.out.println(list.stream().filter(x -> x.startsWith("P")).distinct().count());

        // 5. limit
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

        // 6. skip
        System.out.println(Stream.generate(() -> 1).skip(10).limit(100).count());


    }
}
