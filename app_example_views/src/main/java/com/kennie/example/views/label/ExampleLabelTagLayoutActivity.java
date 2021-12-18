package com.kennie.example.views.label;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kennie.example.views.R;
import com.kennie.example.views.label.drawable.CircleDrawable;
import com.kennie.example.views.label.drawable.MultiCircleDrawable;
import com.kennie.views.label.LabelTagLayout;
import com.kennie.views.label.LabelTagView;

/**
 * @项目名 KennieProject
 * @类名称 ExampleLabelTagLayoutActivity
 * @类描述
 * @创建人 Administrator
 * @修改人
 * @创建时间 2021/12/18 2:04
 */
public class ExampleLabelTagLayoutActivity extends AppCompatActivity {

    private final String[] mTagWords = new String[]{
            "不同边框形状的标签", "单选和多选标签", "可编辑的标签", "动画效果的换一换标签",
            "TagView的一些其它用途", "水平反向排列(RTL)"
    };
    private LabelTagLayout mTagLayout;

    private LabelTagView mTagView;
    private LabelTagView mTagMultiCircle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_label_tag_layout);
        mTagLayout = (LabelTagLayout) findViewById(R.id.tag_layout);
        mTagLayout.setTags(mTagWords);
        mTagLayout.setTagClickListener(new LabelTagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text, @LabelTagView.TagMode int tagMode) {
                if (mTagWords[0].equals(text)) {
                    startActivity(new Intent(ExampleLabelTagLayoutActivity.this, TagShapeActivity.class));
                } else if (mTagWords[1].equals(text)) {
                    startActivity(new Intent(ExampleLabelTagLayoutActivity.this, TagChoiceActivity.class));
                } else if (mTagWords[2].equals(text)) {
                    startActivity(new Intent(ExampleLabelTagLayoutActivity.this, TagEditActivity.class));
                } else if (mTagWords[3].equals(text)) {
                    startActivity(new Intent(ExampleLabelTagLayoutActivity.this, TagChangeActivity.class));
                } else if (mTagWords[4].equals(text)) {
                    startActivity(new Intent(ExampleLabelTagLayoutActivity.this, TagViewActivity.class));
                } else if (mTagWords[5].equals(text)) {
                    startActivity(new Intent(ExampleLabelTagLayoutActivity.this, TagReverseActivity.class));
                }
            }
        });

        mTagView = (LabelTagView) findViewById(R.id.tag_view);
        mTagView.setDecorateIcon(new CircleDrawable());
        mTagMultiCircle = (LabelTagView) findViewById(R.id.tag_multi_circle);
        mTagMultiCircle.setDecorateIcon(new MultiCircleDrawable());
    }
}
