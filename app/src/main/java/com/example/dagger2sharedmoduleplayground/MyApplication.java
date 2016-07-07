package com.example.dagger2sharedmoduleplayground;

import android.app.Application;
import com.example.dagger2sharedmoduleplayground.dagger.ApplicationComponent;
import com.example.dagger2sharedmoduleplayground.dagger.ApplicationModule;
import com.example.dagger2sharedmoduleplayground.dagger.DaggerApplicationComponent;

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule()).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
