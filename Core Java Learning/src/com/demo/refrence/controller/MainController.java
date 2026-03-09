package com.demo.refrence.controller;

import com.demo.refrence.model.MobilePhone;

import java.util.Arrays;
import java.util.List;

public class MainController {

    // Entry point of the program
    // Note: Standard main signature should be public static void main(String[] args)
    static void main() {

        // ---------------------------
        // Method Reference Example
        // ---------------------------

        // Creating a List of student names
        List<String> students = Arrays.asList("Raj", "Ram", "Pranit");

        /*
         * Lambda Expression Version
         * forEach method iterates each element and prints it
         */
        // students.forEach(x -> System.out.println(x));

        /*
         * Method Reference Version
         * System.out::println is a reference to the println() method
         *
         * It means:
         * For each element in the list, call System.out.println(element)
         *
         * Syntax:
         * ClassName::methodName
         */
        students.forEach(System.out::println);


        // ---------------------------
        // Constructor Reference Example
        // ---------------------------

        // List of mobile brand names
        List<String> names = Arrays.asList("OPPO", "POCO", "VIVO");

        /*
         * Lambda Version
         *
         * For each name in the list,
         * create a new MobilePhone object
         */
        /*
        List<MobilePhone> mobilePhoneList = names.stream()
                .map(x -> new MobilePhone(x))
                .collect(Collectors.toList());
        */

        /*
         * Constructor Reference Version
         *
         * MobilePhone::new refers to the constructor of MobilePhone class
         *
         * It means:
         * For each string value, create a new MobilePhone object
         */
        List<MobilePhone> mobilePhoneList = names.stream()
                .map(MobilePhone::new)
                .toList();   // Converts Stream to List

        // Printing MobilePhone objects
        mobilePhoneList.forEach(System.out::println);
    }
}

/*
        Method Reference --- ClassName::methodName
        Static Method Reference --- ClassName::staticMethod (Math::abs)
        Instance Method Reference --- object::methodName (System.out::println)
        Instance Method of Arbitrary Object --- ClassName::methodName (String::toUpperCase)
        Constructor Reference --- x -> new MobilePhone(x) same as MobilePhone::new
*/