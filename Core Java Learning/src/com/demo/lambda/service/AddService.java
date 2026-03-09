package com.demo.lambda.service;


public class AddService implements IAddService{

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
