package com.example.dagger2sharedmoduleplayground.dagger;

import com.example.dagger2sharedmoduleplayground.MainActivity;
import com.example.shared.ScopedComponentBuilder;
import com.example.shared.SharedPerActivityComponent;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = PerActivityModule.class)
public interface PerActivityComponent extends SharedPerActivityComponent {
    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder extends ScopedComponentBuilder<PerActivityComponent> {
        PerActivityComponent build();
        Builder perActivityModule(PerActivityModule module);
    }
}
