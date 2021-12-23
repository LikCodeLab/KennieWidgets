package com.kennie.example.tagflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.kennie.views.tagflow.tag2.SmallTagView;

import java.util.ArrayList;
import java.util.List;


public class SmallTagViewActivity extends AppCompatActivity {

    private SmallTagView mSmallTagView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_tag_view);

        SmallTagView mSmallTagView = findViewById(R.id.tag);

        List<String> tags = new ArrayList<>();

        tags.add("数学");
        tags.add("这是一个很长很长很长很长很长很长很长的Tag");
        tags.add("语文");
        tags.add("化学");
        tags.add("生物");
        tags.add("化学");
        tags.add("历史");
        mSmallTagView.setTags(tags);

        SmallTagView tagView2 = findViewById(R.id.tag2);
        tagView2.setTags(tags);


        ListView listView = findViewById(R.id.listView);

        ItemAdapter adapter = new ItemAdapter();

        listView.setAdapter(adapter);

    }
}