package com.kennie.example.views.label;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kennie.example.views.R;
import com.kennie.example.views.label.utils.TagWordFactory;
import com.kennie.example.views.label.utils.ToastUtils;
import com.kennie.views.label.LabelTagLayout;
import com.kennie.views.label.LabelTagView;

public class TagChangeActivity extends AppCompatActivity implements LabelTagView.OnTagLongClickListener {

    private LabelTagLayout mTagLayout1;
    private LabelTagLayout mTagLayout2;
    private LabelTagLayout mTagLayout3;
    private LabelTagView mTagDel;
    private LabelTagView mTagAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_label_tag_change);
        initView();
    }

    private void initView() {
        mTagLayout1 = (LabelTagLayout) findViewById(R.id.tag_layout_1);
        mTagLayout2 = (LabelTagLayout) findViewById(R.id.tag_layout_2);
        mTagLayout3 = (LabelTagLayout) findViewById(R.id.tag_layout_3);
        mTagDel = (LabelTagView) findViewById(R.id.tag_del);
        mTagAdd = (LabelTagView) findViewById(R.id.tag_add);
        mTagLayout1.setTagClickListener(new LabelTagView.OnTagClickListener() {
            boolean isChange = false;

            @Override
            public void onTagClick(int position, String text, @LabelTagView.TagMode int tagMode) {
                if (tagMode == LabelTagView.MODE_CHANGE) {
                    if (isChange) {
                        mTagLayout1.updateTags(TagWordFactory.TAG_WORD);
                    } else {
                        mTagLayout1.updateTags(TagWordFactory.TAG_WORD_2);
                    }
                    isChange = !isChange;
                } else {
                    ToastUtils.showToast(text);
                }
            }
        });
        mTagLayout2.setTagClickListener(new LabelTagView.OnTagClickListener() {
            boolean isChange = false;

            @Override
            public void onTagClick(int position, String text, @LabelTagView.TagMode int tagMode) {
                if (tagMode == LabelTagView.MODE_CHANGE) {
                    if (isChange) {
                        mTagLayout2.updateTags(TagWordFactory.TAG_WORD);
                    } else {
                        mTagLayout2.updateTags(TagWordFactory.TAG_WORD_2);
                    }
                    isChange = !isChange;
                } else {
                    ToastUtils.showToast(text);
                }
            }
        });
        mTagLayout3.setTagClickListener(new LabelTagView.OnTagClickListener() {
            boolean isChange = false;

            @Override
            public void onTagClick(int position, String text, @LabelTagView.TagMode int tagMode) {
                if (tagMode == LabelTagView.MODE_CHANGE) {
                    if (isChange) {
                        mTagLayout3.updateTags(TagWordFactory.TAG_WORD);
                    } else {
                        mTagLayout3.updateTags(TagWordFactory.TAG_WORD_2);
                    }
                    isChange = !isChange;
                } else {
                    ToastUtils.showToast(text);
                }
            }
        });
        mTagLayout1.setTagLongClickListener(this);
        mTagLayout2.setTagLongClickListener(this);
        mTagLayout3.setTagLongClickListener(this);

        mTagAdd.setTagClickListener(new LabelTagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text, @LabelTagView.TagMode int tagMode) {
                String word = TagWordFactory.provideTagWord();
                mTagLayout1.addTag(word);
                mTagLayout2.addTag(word);
                mTagLayout3.addTag(word);
            }
        });
        mTagDel.setTagClickListener(new LabelTagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text, @LabelTagView.TagMode int tagMode) {
                mTagLayout1.deleteTag(0);
                mTagLayout2.deleteTag(0);
                mTagLayout3.deleteTag(0);
            }
        });

        mTagLayout1.setTags(TagWordFactory.TAG_WORD);
        mTagLayout2.setTags(TagWordFactory.TAG_WORD);
        mTagLayout3.setTags(TagWordFactory.TAG_WORD);
    }

    @Override
    public void onTagLongClick(int position, String text, @LabelTagView.TagMode int tagMode) {
        ToastUtils.showToast("长按:" + text);
    }

}
