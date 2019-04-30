package com.example.dagger2sharedmoduleplayground;

import com.example.dagger2sharedmoduleplayground.dagger.PerActivityComponent;
import com.example.dagger2sharedmoduleplayground.dagger.PerActivityModule;
import com.example.shared.view.SharedActivity;


public class SharedActivityWithScopedComponent extends SharedActivity {
    private PerActivityComponent component = null;

    @Override
    protected PerActivityComponent getComponent() {
        if (component == null) {
            Object lastCustomNonConfigurationInstance = getLastCustomNonConfigurationInstance();
            if (lastCustomNonConfigurationInstance == null) {
                component = ((MyApplication) getApplication())
                        .getApplicationComponent()
                        .getSharedScopedComponentBuilderProvider().get()
                        .perActivityModule(new PerActivityModule(this)).build();
            } else {
                component = (PerActivityComponent) lastCustomNonConfigurationInstance;
            }
        }
        return component;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return getComponent();
    }
}
