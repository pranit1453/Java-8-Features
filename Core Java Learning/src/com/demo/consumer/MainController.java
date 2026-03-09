package com.demo.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MainController {

    // Entry point of the program
    // Standard signature: public static void main(String[] args)
    static void main() {

        System.out.println("Consumer.............");

        /*
         * Consumer<T>
         * ------------
         * Consumer is a Functional Interface introduced in Java 8.
         *
         * Purpose:
         * It consumes (accepts) data but does NOT return any value.
         *
         * Abstract Method:
         * void accept(T t);
         *
         * Key Points:
         * 1. Takes one input parameter
         * 2. Returns nothing (void)
         * 3. Used when we just want to perform an action (print, save, update)
         */

        // Lambda version
        // Consumer<Integer> print = x -> System.out.println(x);

        // Method Reference version
        Consumer<Integer> print = System.out::println;

        // Calling accept() method
        print.accept(10);


        /*
         * Example with List
         */

        // Creating list of integers
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        /*
         * Consumer that accepts a List<Integer>
         * and prints all elements
         */
        Consumer<List<Integer>> data = x -> {
            for (int i : x)
                System.out.print(i + " ,");
        };

        // Passing the list to consumer
        data.accept(arr);

        System.out.println();


        /*
         * Using multiple Consumers with andThen()
         */

        // First consumer prints the value
        Consumer<Integer> val = x -> System.out.println("Value: " + x);

        // Second consumer prints the square of value
        Consumer<Integer> square = x -> System.out.println("Square: " + (x * x));

        /*
         * andThen()
         * ---------
         * Executes consumers sequentially
         *
         * First val
         * Then square
         */
        val.andThen(square).accept(10);
    }
}