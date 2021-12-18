package com.kennie.example.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.kennie.example.views.label.ExampleLabelTagLayoutActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @项目名 KennieViews
 * @类名称 MainExampleActivity
 * @类描述
 * @创建人 Administrator
 * @修改人
 * @创建时间 2021/12/18 14:46
 */
public class MainExampleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExampleViewsAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.item_array));
        adapter = new ExampleViewsAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainExampleActivity.this, ExampleCheckViewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainExampleActivity.this, ExampleLabelTagLayoutActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });


    }
}
