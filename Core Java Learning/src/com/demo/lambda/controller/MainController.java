package com.demo.lambda.controller;


import com.demo.lambda.service.IAddService;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    static void main() throws InterruptedException {

        // IAddService service = (a,b)-> a+b;
        IAddService service = Integer::sum;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            int sum = 7 * i;
            list.add(sum);
        }

        int result = service.add(list.getFirst(), list.getLast());
        System.out.println(result);

        Thread thread = new Thread(() -> {
            System.out.println("Thread is running with reference to lambda expression");
        });
        thread.start();
        thread.join();
    }
}
