package com.example.dagger2sharedmoduleplayground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.dagger2sharedmoduleplayground.dagger.PerActivityComponent;
import com.example.dagger2sharedmoduleplayground.dagger.PerActivityModule;
import com.example.dagger2sharedmoduleplayground.services.StringService;
import com.example.dagger2sharedmoduleplayground.services.Toaster;
import com.example.shared.view.SharedActivity;

import javax.inject.Inject;
import javax.inject.Provider;

public class MainActivity extends AppCompatActivity {

    @Inject StringService stringService;
    @Inject Provider<PerActivityComponent.Builder> builderProvider;
    @Inject Toaster toaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //((MyApplication) getApplication()).getApplicationComponent().inject(this);
        getComponent().inject(this);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.the_best_string);
        //noinspection ConstantConditions
        textView.setText(stringService.getTheBestString());
        View button = findViewById(R.id.go_to_shared_activity);
        //noinspection ConstantConditions
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SharedActivityWithScopedComponent.class));
            }
        });
        View showToastButton = findViewById(R.id.show_toast);
        showToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toaster.showToast();
            }
        });
    }


    private PerActivityComponent component = null;
    PerActivityComponent getComponent() {
        if (component == null) {
            Object lastCustomNonConfigurationInstance = getLastCustomNonConfigurationInstance();
            if (lastCustomNonConfigurationInstance == null) {
                component = ((MyApplication) getApplication()).getApplicationComponent().getSharedScopedComponentBuilderProvider().get().perActivityModule(new PerActivityModule(this)).build();
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
