package com.gorkemgok.hasan.guice;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class MyObjectFactory {

    private final Provider<MyObject> provider;

    @Inject
    public MyObjectFactory(Provider<MyObject> provider) {
        this.provider = provider;
    }

    public MyObject get(){
        return provider.get();
    }
}
