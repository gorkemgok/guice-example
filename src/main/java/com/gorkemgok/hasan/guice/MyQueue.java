package com.gorkemgok.hasan.guice;

import com.google.inject.Inject;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.lang.String.format;


public class MyQueue implements Runnable{

    private final Queue<MyObject> queue;

    private final MyObjectRunner myObjectRunner;

    @Inject
    public MyQueue(MyObjectRunner myObjectRunner) {
        this.myObjectRunner = myObjectRunner;
        this.queue = new ConcurrentLinkedQueue<MyObject>();
    }

    public void put(MyObject myObject){
        System.out.println(format("Added to queue %s", myObject));
        queue.add(myObject);
    }

    public void runOne(){
        MyObject myObject;
        if ((myObject = queue.poll()) != null) {
            myObjectRunner.execute(myObject);
        }else{
            System.out.println("No object to execute");
        }
    }

    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOne();
            }
        }, 1000, 1000);
    }
}
