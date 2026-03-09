package com.demo.supplier;

import java.util.function.Supplier; // Importing Supplier functional interface

public class MainController {

    static void main() {

        System.out.println("Supplier.............");

        /*
         * Supplier<T> is a Functional Interface present in java.util.function package.
         * It represents a supplier of results.
         *
         * Key Points:
         * 1. It does not take any input parameters.
         * 2. It returns a value of type T.
         * 3. It contains only one abstract method: get()
         * 4. Often used for lazy generation of values.
         */

        // Lambda expression implementing Supplier
        // This Supplier returns a String when get() method is called
        Supplier<String> giveString = () -> "Hello Supplier";

        // Calling get() method to retrieve the supplied value
        System.out.println(giveString.get());

        /*
         * Execution Flow:
         * 1. Lambda expression is assigned to Supplier reference.
         * 2. When get() is invoked, the lambda expression executes.
         * 3. The string "Hello Supplier" is returned.
         * 4. The returned value is printed to the console.
         */

        /*
         * Real-world Use Cases of Supplier:
         *
         * 1. Lazy initialization (create object only when needed)
         * 2. Generating random values
         * 3. Factory methods
         * 4. Logging frameworks
         * 5. Stream API methods like generate()
         */
    }
}

/*
        Method in Supplier Interface
            T get();
                Takes no arguments
                Returns a value
*/