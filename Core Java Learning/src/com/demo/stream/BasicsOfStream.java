package com.demo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BasicsOfStream {
    static void main() {
        // Creating Streams

        // 1. From Collections
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> s1 = list.stream();

        // 2. From Arrays
        String[] array = {"a", "b", "c"};
        Stream<String> s2 = Arrays.stream(array);

        // 3. Using stream.of()
        Stream<String> s3 = Stream.of("a", "b", "c", "d");

        // 4. Infinite Stream
        Stream<Integer> generate = Stream.generate(() -> 1);
        Stream<Integer> iterate = Stream.iterate(1, (x) -> x + 1);

        // can control infinite stream with limit.....
    }
}
