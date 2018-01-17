package com.gorkemgok.hasan.guice;

import com.gorkemgok.hasan.guice.generator.MyObjectIdGenerator;
import com.gorkemgok.hasan.guice.generator.MyObjectIncrementalIdGenerator;
import com.gorkemgok.hasan.guice.generator.MyObjectUUIDGenerator;

public class Main {

    public static void main(String[] args) {
        int idGeneratorType = 0;
        if (args.length > 0) {
            idGeneratorType = Integer.valueOf(args[0]);
        }

        MyObjectIdGenerator myObjectIdGenerator;
        if (idGeneratorType == 0) {
            myObjectIdGenerator = new MyObjectUUIDGenerator();
        }else{
            myObjectIdGenerator = new MyObjectIncrementalIdGenerator();
        }

        MyObjectRunner myObjectRunner = new MyObjectRunner();
        MyQueue myQueue = new MyQueue(myObjectRunner);
        MyObjectManager myObjectManager = new MyObjectManager(myQueue);

        new Thread(myQueue).start();

        MyObject myObject1 = new MyObject(myObjectIdGenerator);
        myObjectManager.send(myObject1);
    }
}
