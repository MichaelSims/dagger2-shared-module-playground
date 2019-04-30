package com.example.shared;

import javax.inject.Provider;

public interface SharedModuleComponent<T extends ScopedComponentBuilder> {
    Provider<T> getSharedScopedComponentBuilderProvider();
}
