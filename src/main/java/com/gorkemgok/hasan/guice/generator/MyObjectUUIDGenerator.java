package com.gorkemgok.hasan.guice.generator;

import java.util.UUID;

public class MyObjectUUIDGenerator implements MyObjectIdGenerator{

    public String generateId(){
        return UUID.randomUUID().toString();
    }
}
