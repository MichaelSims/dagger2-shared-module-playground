package com.example.dagger2sharedmoduleplayground.dagger;

import android.support.v7.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class PerActivityModule {

    private final AppCompatActivity activity;

    public PerActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }
}
