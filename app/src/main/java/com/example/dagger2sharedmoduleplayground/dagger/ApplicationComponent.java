package com.example.dagger2sharedmoduleplayground.dagger;

import com.example.dagger2sharedmoduleplayground.MainActivity;
import com.example.shared.SharedModuleComponent;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent extends SharedModuleComponent {
    void inject(MainActivity target);
}
