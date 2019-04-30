package com.example.dagger2sharedmoduleplayground.dagger;

import com.example.shared.SharedModuleComponent;
import dagger.Component;

import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent extends SharedModuleComponent<PerActivityComponent.Builder> {
    Provider<PerActivityComponent.Builder> getSharedScopedComponentBuilderProvider();
}
