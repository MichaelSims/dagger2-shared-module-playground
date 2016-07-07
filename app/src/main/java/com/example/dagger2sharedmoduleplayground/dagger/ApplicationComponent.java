package com.example.dagger2sharedmoduleplayground.dagger;

import com.example.dagger2sharedmoduleplayground.MainActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity target);
}
