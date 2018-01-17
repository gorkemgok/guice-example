package com.gorkemgok.hasan.guice;

import com.google.inject.Inject;

public class Runner {

    private final MyQueue myQueue;

    private final MyObjectFactory myObjectFactory;

    private final MyObjectManager myObjectManager;

    @Inject
    public Runner(MyQueue myQueue, MyObjectFactory myObjectFactory, MyObjectManager myObjectManager) {
        this.myQueue = myQueue;
        this.myObjectFactory = myObjectFactory;
        this.myObjectManager = myObjectManager;
    }

    public void run(){
        new Thread(myQueue).start();

        for (int i = 0; i < 10; i++) {
            MyObject myObject = myObjectFactory.get();
            myObjectManager.send(myObject);

        }
    }
}
