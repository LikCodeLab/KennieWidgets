package com.kennie.widgets.library;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * 自定义搜索控件SearchView
 */
public class SearchBoxView extends LinearLayout implements ISearchBoxView {


    private TextWatcher textWatcher;
    private OnSearchTextViewClickListener onSearchTextViewClickListener;
    private ISearchBoxView.OnImageViewClickListener onOnClearImageViewClickListener;


    private AppCompatEditText mSearchBoxEt; // 搜索框
    private AppCompatImageView mSearchClearIv; //清除图标
    private AppCompatTextView mSearchTv; // 搜索

    /**
     * 点击搜索后是否自动隐藏虚拟键盘
     */
    private boolean enableAutoHideSoftKey;
    /**
     * 点击了搜索(不是搜索图标)后是否清除EditText的焦点
     */
    private boolean enableClearFocusAfterSearch;

    public SearchBoxView(Context context) {
        super(context);
        init();
    }

    public SearchBoxView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public SearchBoxView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        initViews();
    }

    private void initViews() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout._widget_searchbox_layout, this);
        mSearchBoxEt = rootView.findViewById(R.id.et_search_box);
    }

    @Override
    public void setOnSearchTextViewClickListener(OnSearchTextViewClickListener listener) {

    }

    @Override
    public void setOnClearImageViewClickListener(OnImageViewClickListener listener) {

    }

    /**
     * 获取EditText的内容
     *
     * @return EditText的内容
     */
    @Override
    public String getSearchContent() {
        return mSearchBoxEt.getText().toString().trim();
    }

    /**
     * 设置EditText的内容
     *
     * @param content content
     */
    @Override
    public void setSearchContent(String content) {
        mSearchBoxEt.setText(content);
    }

    @Override
    public EditText getEditText() {
        return mSearchBoxEt;
    }
}
