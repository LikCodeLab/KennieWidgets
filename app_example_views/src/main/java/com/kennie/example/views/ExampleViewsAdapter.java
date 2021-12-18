package com.kennie.example.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

/**
 * @项目名 KennieViews
 * @类名称 ExampleViewsAdapter
 * @类描述
 * @创建人 Administrator
 * @修改人
 * @创建时间 2021/12/18 14:40
 */
public class ExampleViewsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ExampleViewsAdapter() {
        super(android.R.layout.simple_list_item_1);
    }

    public ExampleViewsAdapter(@Nullable List<String> data) {
        super(android.R.layout.simple_list_item_1, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, String str) {
        holder.setText(android.R.id.text1, str);
    }
}
