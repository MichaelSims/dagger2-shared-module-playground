package com.example.shared;

import com.example.shared.view.SharedActivity;

import javax.inject.Provider;

public interface SharedModuleComponent<T extends ScopedComponentBuilder> {
    Provider<T> getSharedScopedComponentBuilderProvider();
}
