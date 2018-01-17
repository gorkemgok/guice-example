package com.gorkemgok.hasan.guice.generator;

public class MyObjectIncrementalIdGenerator implements MyObjectIdGenerator {

    private static int count;

    public String generateId() {
        return String.valueOf(count++);
    }
}
