package com.gorkemgok.hasan.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.gorkemgok.hasan.guice.generator.MyObjectIdGenerator;
import com.gorkemgok.hasan.guice.ioc.BootstrapModule;

public class MainGuice {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BootstrapModule(args));
        MyObjectManager myObjectManager = injector.getInstance(MyObjectManager.class);
        MyQueue myQueue = injector.getInstance(MyQueue.class);
        MyQueue myQueue2 = injector.getInstance(MyQueue.class);
        MyObjectFactory myObjectFactory = injector.getInstance(MyObjectFactory.class);

        if (myQueue.equals(myQueue2)){
            System.out.println("Same Object");
        }

        new Thread(myQueue).start();

        for (int i = 0; i < 10; i++) {
            MyObject myObject = myObjectFactory.get();
            myObjectManager.send(myObject);

        }
    }
}
