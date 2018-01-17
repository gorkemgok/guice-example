package com.gorkemgok.hasan.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.gorkemgok.hasan.guice.ioc.BootstrapModule;

public class MainGuiceMinimal {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BootstrapModule(args));
        Runner runner = injector.getInstance(Runner.class);
        runner.run();
    }
}
