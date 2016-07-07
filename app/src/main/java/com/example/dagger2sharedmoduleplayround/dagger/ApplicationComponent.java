package com.example.dagger2sharedmoduleplayround.dagger;

import com.example.dagger2sharedmoduleplayround.MainActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity target);
}
