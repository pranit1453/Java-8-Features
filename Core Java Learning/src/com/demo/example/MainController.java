package com.demo.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainController {
    static void main() {
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = System.out::println;
        Supplier<Integer> supplier = () -> 100;

        if (predicate.test(supplier.get()))
            consumer.accept(function.apply(supplier.get()));

    }
}
