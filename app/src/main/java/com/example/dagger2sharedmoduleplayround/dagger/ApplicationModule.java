package com.example.dagger2sharedmoduleplayround.dagger;

import com.example.dagger2sharedmoduleplayround.services.StringService;
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
