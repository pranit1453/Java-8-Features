package com.demo.function;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MainController {

    // Entry point of the program
    // Standard signature: public static void main(String[] args)
    static void main() {

        System.out.println("Function.............");

        /*
         * Function<T, R>
         * ----------------
         * Function is a Functional Interface introduced in Java 8.
         *
         * T → Input type
         * R → Return type
         *
         * Abstract Method:
         * R apply(T t);
         *
         * It takes one input and produces one output.
         */

        // Lambda expression that doubles the number
        Function<Integer, Integer> doubleIt = x -> 2 * x;

        // Lambda expression that triples the number
        Function<Integer, Integer> tripleIt = x -> 3 * x;

        // Calling apply() method
        // apply() executes the function logic
        System.out.println(doubleIt.apply(100)); // 200
        System.out.println(tripleIt.apply(100)); // 300


        /*
         * andThen()
         * ---------
         * First executes doubleIt
         * Then executes tripleIt on the result
         *
         * Formula:
         * tripleIt(doubleIt(x))
         */

        System.out.println(doubleIt.andThen(tripleIt).apply(20));

        /*
         * Execution:
         * doubleIt(20) = 40
         * tripleIt(40) = 120
         */


        /*
         * compose()
         * ---------
         * First executes tripleIt
         * Then executes doubleIt
         *
         * Formula:
         * doubleIt(tripleIt(x))
         */

        System.out.println(doubleIt.compose(tripleIt).apply(20));

        /*
         * Execution:
         * tripleIt(20) = 60
         * doubleIt(60) = 120
         */


        /*
         * identity()
         * ----------
         * Static method in Function interface
         * Returns the same value passed to it
         *
         * Useful when we want no transformation
         */

        Function<Integer, Integer> identity = Function.identity();

        System.out.println(identity.apply(5)); // Output: 5


        /*
         * UnaryOperator
         * -------------
         * UnaryOperator is a special type of Function
         *
         * It extends Function<T,T>
         * Input and Output types are the same
         */

        // Using Function
        Function<Integer, Integer> fun = x -> x * x * x;

        // Using UnaryOperator
        UnaryOperator<Integer> unaryOperator = x -> x * x * x;

        /*
         * Both are doing the same operation
         * because UnaryOperator extends Function<T,T>
         */
    }
}