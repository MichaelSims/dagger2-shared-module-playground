package com.example.shared.dagger;

import com.example.shared.BestStringProvider;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class SharedModule {
    @Provides
    @Singleton
    BestStringProvider provideBestStringProvider() {
        return new BestStringProvider("Make america great again");
    }
}
