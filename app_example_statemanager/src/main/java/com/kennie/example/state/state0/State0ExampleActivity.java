package com.kennie.example.state.state0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kennie.example.state.R;
import com.kennie.views.statemanager.state0.StateLayout0;

public class State0ExampleActivity extends AppCompatActivity {

    private StateLayout0 state0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state0_example);
        state0 = findViewById(R.id.state0);
        state0.show();
        state0.setIcon(R.drawable._icon_vector_state_error);
        state0.setHint(R.string._state_network_error);

    }
}