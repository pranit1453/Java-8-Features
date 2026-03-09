package com.demo.parallelstream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class MainController {

    // Entry point of the program
    // Standard signature should be: public static void main(String[] args)
    static void main() {

        /*
         * Parallel Stream
         * ----------------
         * A type of stream that allows parallel processing of elements.
         * Multiple threads process parts of the stream simultaneously.
         *
         * Benefits:
         * - Faster processing for large datasets
         * - Uses multiple CPU cores
         *
         * Drawbacks:
         * - Overhead for small tasks
         * - Order of execution may change
         */

        // Measure execution time of sequential stream
        long startTime = System.currentTimeMillis();

        // Create numbers from 1 to 20000
        List<Integer> list = Stream.iterate(1, x -> x + 1)
                .limit(20000)
                .toList();

        /*
         * Sequential Stream
         * -----------------
         * Processes elements one by one using a single thread
         */

        List<Long> factorialsList = list.stream()
                .map(MainController::factorial)
                .toList();

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken with sequential stream: "
                + (endTime - startTime) + " ms");


        /*
         * Parallel Stream
         * ----------------
         * Uses multiple threads from ForkJoinPool
         * to process elements simultaneously
         */

        startTime = System.currentTimeMillis();

        factorialsList = list.parallelStream()
                .map(MainController::factorial)
                .toList();

        // You can convert back to sequential
        // .sequential()

        endTime = System.currentTimeMillis();

        System.out.println("Time taken with parallel stream: "
                + (endTime - startTime) + " ms");


        /*
         * Parallel streams are best for:
         * - CPU intensive operations
         * - Large datasets
         * - Independent tasks
         */




        /*
         * Cumulative Sum Example
         *
         * Input:
         * [1, 2, 3, 4, 5]
         *
         * Expected Output:
         * [1, 3, 6, 10, 15]
         */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // AtomicInteger is used to safely update values across threads
        AtomicInteger sum = new AtomicInteger(0);

        /*
         * Sequential stream is used here because
         * cumulative sum depends on previous results.
         */

        List<Integer> cumulativeSum = numbers.stream()
                .sequential()
                .map(sum::addAndGet)
                .toList();

        System.out.println("Expected cumulative sum: [1, 3, 6, 10, 15]");
        System.out.println("Actual result with parallel stream: " + cumulativeSum);

    }


    /*
     * Factorial Method
     * ----------------
     * Calculates factorial of a number
     */

    private static long factorial(int n) {

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}