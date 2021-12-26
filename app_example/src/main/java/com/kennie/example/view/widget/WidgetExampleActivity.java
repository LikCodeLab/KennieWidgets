package com.kennie.example.view.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.kennie.example.view.R;
import com.kennie.views.widget.CountDownView;

public class WidgetExampleActivity extends AppCompatActivity implements View.OnClickListener{

    private CountDownView cv_register_countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_example);
        cv_register_countdown = findViewById(R.id.cv_register_countdown);
        cv_register_countdown.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.cv_register_countdown) {
            cv_register_countdown.setTotalTime(10);
            cv_register_countdown.start();
        }
    }
}