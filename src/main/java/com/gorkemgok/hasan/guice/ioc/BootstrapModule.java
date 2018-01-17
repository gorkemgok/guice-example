package com.gorkemgok.hasan.guice.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.gorkemgok.hasan.guice.MyObjectFactory;
import com.gorkemgok.hasan.guice.MyObjectManager;
import com.gorkemgok.hasan.guice.MyObjectRunner;
import com.gorkemgok.hasan.guice.MyQueue;
import com.gorkemgok.hasan.guice.generator.MyObjectIdGenerator;

public class BootstrapModule extends AbstractModule {

    private final String[] args;

    public BootstrapModule(String[] args) {
        this.args = args;
    }

    protected void configure() {
        int idGeneratorType = 0;
        if (args.length > 0) {
            idGeneratorType = Integer.valueOf(args[0]);
        }

        MyObjectIdGenerator myObjectIdGenerator;
        if (idGeneratorType == 0) {
            install(new UUIDGeneratorModule());
        }else{
            install(new IncrementalIdGeneratorModule());
        }

        bind(MyObjectManager.class).in(Singleton.class);
        bind(MyObjectRunner.class).in(Singleton.class);
        bind(MyQueue.class).in(Singleton.class);
        bind(MyObjectFactory.class).in(Singleton.class);
    }
}
