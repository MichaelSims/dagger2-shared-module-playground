package com.example.dagger2sharedmoduleplayground.dagger;

import com.example.dagger2sharedmoduleplayground.services.StringService;
import com.example.shared.BestStringProvider;
import com.example.shared.StringServiceApi;
import com.example.shared.dagger.SharedModule;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(includes = SharedModule.class)
public class ApplicationModule {

    @Singleton
    @Provides
    StringService provideStringService(BestStringProvider bestStringProvider) {
        return new StringService(bestStringProvider);
    }

    @Provides
    StringServiceApi provideStringServiceAsGeneralType(StringService stringService) {
        return stringService;
    }
}
