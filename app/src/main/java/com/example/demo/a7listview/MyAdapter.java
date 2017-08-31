package com.example.demo.a7listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Fruit> fruits;

    public MyAdapter(Context context, List<Fruit> fruits) {
        this.context = context;
        this.fruits = fruits;
    }

    static class FruitInfo {
        public static final int FRUIT_XML_TYPE_RIGHT = 0;
        public static final int FRUIT_XML_TYPE_LEFT = 1;
        public static final int FRUIT_XML_TYPE_COUNT = 2;
    }

    // 사용해야 하는 아이템의 디자인 복수인 경우 2개의 메소드를 추가로 재정의한다.
    @Override
    public int getItemViewType(int position) {
        return fruits.get(position).getXmlType();
    }

    @Override
    public int getViewTypeCount() {
        return FruitInfo.FRUIT_XML_TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return fruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Fruit fruit = (Fruit) getItem(position);

        if (convertView == null) {
            if (fruit.getXmlType() == FruitInfo.FRUIT_XML_TYPE_LEFT) {
                convertView = LayoutInflater.from(context)
                        .inflate(R.layout.list_layout_left, parent, false);
            } else {
                convertView = LayoutInflater.from(context)
                        .inflate(R.layout.list_layout_right, parent, false);
            }

            holder = new ViewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.imageView);
            holder.tv = (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.iv.setImageResource(fruit.getResId());
        holder.tv.setText(fruit.getName());

        return convertView;
    }

    class ViewHolder {
        ImageView iv;
        TextView tv;
    }
}
