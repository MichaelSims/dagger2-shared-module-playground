package com.example.dagger2sharedmoduleplayround;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.dagger2sharedmoduleplayround.services.StringService;

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
    }
}
