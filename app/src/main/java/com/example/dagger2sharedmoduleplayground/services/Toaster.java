package com.example.dagger2sharedmoduleplayground.services;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.example.dagger2sharedmoduleplayground.dagger.PerActivity;
import com.example.shared.StringServiceApi;
import com.example.shared.ToasterApi;

import javax.inject.Inject;
import java.util.Locale;

@PerActivity
public class Toaster implements ToasterApi{

    private final StringServiceApi stringServiceApi;
    private final AppCompatActivity activity;
    private final Integer generation;

    @Inject
    public Toaster(StringServiceApi stringServiceApi, AppCompatActivity activity, Integer generation) {
        this.stringServiceApi = stringServiceApi;
        this.activity = activity;
        this.generation = generation;
    }

    @Override
    public void showToast() {
        Toast.makeText(activity, String.format(Locale.US, "%d %s", generation, stringServiceApi.getTheBestString()), Toast.LENGTH_LONG).show();
    }
}
