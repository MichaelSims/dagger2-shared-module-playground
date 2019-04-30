package com.example.dagger2sharedmoduleplayground.dagger;

import com.example.dagger2sharedmoduleplayground.services.StringService;
import com.example.shared.BestStringProvider;
import com.example.shared.StringServiceApi;
import com.example.shared.dagger.SharedModule;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

@Module(includes = SharedModule.class, subcomponents = PerActivityComponent.class)
public class ApplicationModule {

    private final AtomicInteger counter = new AtomicInteger(0);

    @Provides
    Integer provideCounterValue() {
        return counter.incrementAndGet();
    }

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
