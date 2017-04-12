package com.example.shared;

public interface ScopedComponentBuilder<T extends SharedPerActivityComponent> {
    T build();
}
