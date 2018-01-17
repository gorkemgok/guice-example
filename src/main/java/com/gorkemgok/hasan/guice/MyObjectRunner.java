package com.gorkemgok.hasan.guice;

import static java.lang.String.format;

public class MyObjectRunner {

    public void execute(MyObject myObject){
        System.out.println(format("Executed my object %s", myObject));
    }
}
