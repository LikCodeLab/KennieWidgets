package com.kennie.example.tagflow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kennie.views.tagflow.tag2.SmallTagView;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名 KennieViews
 * @类名称 ItemAdapter
 * @类描述
 * @创建人 Administrator
 * @修改人
 * @创建时间 2021/12/23 22:27
 */
public class ItemAdapter extends BaseAdapter {


    List<String> tags = new ArrayList<>();
    {
        tags.add("数学");
        tags.add("这是一个很长很长很长很长很长很长很长的Tag");
        tags.add("语文");
        tags.add("化学");
        tags.add("生物");
        tags.add("化学");
        tags.add("历史");
    }


    List<String> tags2 = new ArrayList<>();

    {
        tags2.add("历史");
        tags2.add("生物");
        tags2.add("语文");
    }

    List<String> tags3 = new ArrayList<>();{
        tags3.add("化学");
        tags3.add("物理");
        tags3.add("音乐");
    }


    public ItemAdapter() {

    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tagView = convertView.findViewById(R.id.tag);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        int x = position % 3;

        switch (x){
            case 0:
                viewHolder.tagView.setTags(tags);
                break;
            case 1:
                viewHolder.tagView.setTags(tags2);
                break;
            case 2:
                viewHolder.tagView.setTags(tags3);
                break;
        }
        return convertView;
    }

    static class ViewHolder {

        SmallTagView tagView;
    }
}
