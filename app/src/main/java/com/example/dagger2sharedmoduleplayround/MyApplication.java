package com.example.dagger2sharedmoduleplayround;

import android.app.Application;
import com.example.dagger2sharedmoduleplayround.dagger.ApplicationComponent;
import com.example.dagger2sharedmoduleplayround.dagger.ApplicationModule;
import com.example.dagger2sharedmoduleplayround.dagger.DaggerApplicationComponent;

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
