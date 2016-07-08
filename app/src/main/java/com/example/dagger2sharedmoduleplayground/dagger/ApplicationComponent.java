package com.example.dagger2sharedmoduleplayground.dagger;

import com.example.dagger2sharedmoduleplayground.MainActivity;
import com.example.shared.SharedModuleInjector;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent extends SharedModuleInjector {
    void inject(MainActivity target);
}
