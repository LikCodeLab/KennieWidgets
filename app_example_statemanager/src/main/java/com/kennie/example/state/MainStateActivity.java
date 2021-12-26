package com.kennie.example.state;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.kennie.example.state.adapter.MainAdapter;
import com.kennie.example.state.state0.State0ExampleActivity;
import com.kennie.example.state.state1.State1ExampleActivity;
import com.kennie.example.state.state2.State2ExampleActivity;


import java.util.Arrays;
import java.util.List;

public class MainStateActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_state);
        recyclerView = findViewById(R.id.rv);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.state_main_array));
        adapter = new MainAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainStateActivity.this, State0ExampleActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainStateActivity.this, State1ExampleActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainStateActivity.this, State2ExampleActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}