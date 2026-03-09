package com.demo.bi;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class MainController {

    // Entry point of the program
    // Standard signature: public static void main(String[] args)
    static void main() {

        /*
         * BiPredicate<T, U>
         * -----------------
         * Takes two input arguments
         * Returns boolean (true / false)
         *
         * Abstract Method:
         * boolean test(T t, U u);
         */

        // Checks if sum of two numbers is EVEN
        BiPredicate<Integer, Integer> biPredicate =
                (x, y) -> (x + y) % 2 == 0;


        /*
         * BiConsumer<T, U>
         * ----------------
         * Accepts two input arguments
         * Does not return any value
         *
         * Abstract Method:
         * void accept(T t, U u);
         */

        BiConsumer<Integer, String> biConsumer =
                (x, y) -> {
                    System.out.println("Integer: " + x);
                    System.out.println("String: " + y);
                };


        /*
         * BiFunction<T, U, R>
         * -------------------
         * Takes two input arguments
         * Returns a result
         *
         * Abstract Method:
         * R apply(T t, U u);
         */

        // Concatenates two strings and returns length
        BiFunction<String, String, Integer> biFunction =
                (x, y) -> (x + y).length();


        /*
         * Using BiPredicate
         * If condition is true, then execute BiConsumer
         */

        if (biPredicate.test(5, 5)) {
            biConsumer.accept(10, "Hello");
        }


        /*
         * Using BiFunction
         */

        int res = biFunction.apply("Java", "Lambda");

        System.out.println("Length: " + res);


        /*
         * BinaryOperator<T>
         * -----------------
         * Special type of BiFunction
         *
         * It extends:
         * BiFunction<T, T, T>
         *
         * Meaning:
         * Input1 type = Input2 type = Output type
         */

        // Using BiFunction
        BiFunction<Integer, Integer, Integer> biFun = Integer::sum;

        // Using BinaryOperator
        BinaryOperator<Integer> binaryOperator = Integer::sum;

        System.out.println(biFun.apply(2, 2));
        System.out.println(binaryOperator.apply(2, 2));
    }
}