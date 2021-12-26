package com.kennie.example.views.ui.state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.kennie.example.state.two.StateTwoExampleActivity;
import com.kennie.example.views.MainExampleActivity;
import com.kennie.example.views.R;
import com.kennie.example.views.adapter.ExampleStateViewsAdapter;
import com.kennie.example.views.adapter.ExampleViewsAdapter;
import com.kennie.example.views.ui.ExampleCheckViewActivity;
import com.kennie.example.views.ui.ExampleLabelTagLayoutActivity;
import com.kennie.example.views.ui.widget.WidgetExampleActivity;

import java.util.Arrays;
import java.util.List;

/**
 * 演示各种状态切换
 */
public class ExampleStateActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExampleStateViewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_state);

        recyclerView = findViewById(R.id.rv);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.item_state_array));
        adapter = new ExampleStateViewsAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(ExampleStateActivity.this, StateTwoExampleActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}