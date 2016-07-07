package com.example.dagger2sharedmoduleplayground.dagger;

import com.example.dagger2sharedmoduleplayground.services.StringService;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ApplicationModule {

    @Singleton
    @Provides
    StringService provideStringService() {
        return new StringService();
    }
}
