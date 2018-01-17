package com.gorkemgok.hasan.guice;

import com.google.inject.Inject;
import com.gorkemgok.hasan.guice.generator.MyObjectIdGenerator;

public class MyObject {

    private final String name;

    @Inject
    public MyObject(MyObjectIdGenerator idGenerator) {
        this.name = idGenerator.generateId();
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
