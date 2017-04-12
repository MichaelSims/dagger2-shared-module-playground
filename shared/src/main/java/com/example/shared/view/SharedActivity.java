package com.example.shared.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.example.shared.SharedModuleComponentProvider;
import com.example.shared.R;
import com.example.shared.SharedPerActivityComponent;
import com.example.shared.StringServiceApi;
import com.example.shared.ToasterApi;

import javax.inject.Inject;

public abstract class SharedActivity extends AppCompatActivity {

    @Inject StringServiceApi stringService;
    @Inject ToasterApi toasterApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        setContentView(R.layout.activity_shared);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //noinspection ConstantConditions
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                toasterApi.showToast();
            }
        });
        TextView textView = (TextView) findViewById(R.id.shared_text_view);
        //noinspection ConstantConditions
        textView.setText(stringService.getTheBestString());
    }

    private SharedPerActivityComponent component = null;
    protected abstract SharedPerActivityComponent getComponent();

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return getComponent();
    }

}
