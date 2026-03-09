package com.demo.stream;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperations {
    static void main() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // 1. collect / toList()
        System.out.println(list.stream().skip(1).toList());

        // 2. forEach
        list.stream().forEach(System.out::println);

        // 3. reduce combines elements to produce a single unit
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);

        // 4. count

        // 5. anyMatch, allMatch, noneMatch

        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);

        boolean b1 = list.stream().allMatch(x -> x > 0);
        System.out.println(b1);
        boolean b2 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b2);

        // 6. findFirst, findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // example
        List<String> names = Arrays.asList("Anna", "Bob", "Joe", "Charlie", "David");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());

        // squaring and sorting numbers
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers.stream().map(x -> x * x).sorted((x, y) -> x - y).toList());

        // Summing Values
        List<Integer> sums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sums.stream().reduce(Integer::sum).get());

        // Counting Occurrences of Character
        String sentence = "Hello World";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());
    }
}
