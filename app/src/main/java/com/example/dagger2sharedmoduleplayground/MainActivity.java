package com.example.dagger2sharedmoduleplayground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.dagger2sharedmoduleplayground.services.StringService;
import com.example.shared.view.SharedActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject StringService stringService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplication()).getApplicationComponent().inject(this);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.the_best_string);
        //noinspection ConstantConditions
        textView.setText(stringService.getTheBestString());
        View button = findViewById(R.id.go_to_shared_activity);
        //noinspection ConstantConditions
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SharedActivity.class));
            }
        });
    }
}
