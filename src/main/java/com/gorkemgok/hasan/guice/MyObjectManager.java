package com.gorkemgok.hasan.guice;

import com.google.inject.Inject;

import static java.lang.String.*;

public class MyObjectManager {

    private final MyQueue myQueue;

    @Inject
    public MyObjectManager(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    public void send(MyObject myObject){
        System.out.println(format("Sent to MyQueue Manager %s", myObject));
        myQueue.put(myObject);
    }
}
