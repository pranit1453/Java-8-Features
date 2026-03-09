package com.demo.predicate;

import java.util.function.Predicate; 

public class MainController {

    
    static void main() {

        // Printing heading
        System.out.println("Predicate.............");

        /*
         * Predicate<T>
         * -------------
         * Predicate is a Functional Interface introduced in Java 8.
         *
         * Purpose:
         * It is used to evaluate a condition (true or false).
         *
         * Key Points:
         * 1. Takes one input parameter.
         * 2. Returns boolean (true / false).
         * 3. Mostly used for filtering conditions.
         *
         * Abstract Method:
         * boolean test(T t);
         */

        // Predicate to check whether a number is EVEN
        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        // Calling test() method
        // test() evaluates the condition and returns true or false
        System.out.println(isEven.test(4));  // true


        /*
         * Predicate Example with Strings
         */

        // Checks if word starts with "A" OR contains "a"
        Predicate<String> isWordStartWithLetterA =
                x -> x.startsWith("A") || x.contains("a");

        // Checks if word ends with letter "t"
        // toLowerCase() ensures case-insensitive comparison
        Predicate<String> isWordEndsWithLetterT =
                x -> x.toLowerCase().endsWith("t");

        /*
         * Combining Predicates using AND
         *
         * .and() method returns a new predicate that represents
         * logical AND of two predicates
         */

        Predicate<String> and =
                isWordStartWithLetterA.and(isWordEndsWithLetterT);

        // Testing the combined predicate

        System.out.println(and.test("Amit"));      // true
        // starts with A + ends with t

        System.out.println(and.test("Prakash"));   // false
        // contains 'a' but does NOT end with 't'
    }
}