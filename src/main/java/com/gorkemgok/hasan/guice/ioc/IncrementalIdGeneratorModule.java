package com.gorkemgok.hasan.guice.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.gorkemgok.hasan.guice.generator.MyObjectIdGenerator;
import com.gorkemgok.hasan.guice.generator.MyObjectIncrementalIdGenerator;

public class IncrementalIdGeneratorModule extends AbstractModule {
    protected void configure() {
        bind(MyObjectIdGenerator.class).to(MyObjectIncrementalIdGenerator.class).in(Singleton.class);
    }
}
