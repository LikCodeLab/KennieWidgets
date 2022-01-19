package com.kennie.example.widgets;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kennie.lib.widgets.tv.CountDownTextView;


/**
 * 演示Widgets
 */
public class WidgetExampleActivity extends AppCompatActivity implements View.OnClickListener{

    private CountDownTextView cv_register_countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_example);
        cv_register_countdown = findViewById(R.id.cv_register_countdown);
        cv_register_countdown.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.cv_register_countdown) {
            cv_register_countdown.setTotalTime(10);
            cv_register_countdown.start();
        }
    }
}