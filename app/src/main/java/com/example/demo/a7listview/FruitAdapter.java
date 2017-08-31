package com.example.demo.a7listview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> fruits;

    public FruitAdapter(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    static class FruitInfo {
        public static final int FRUIT_XML_TYPE_RIGHT = 0;
        public static final int FRUIT_XML_TYPE_LEFT = 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private ImageView iv;
        private TextView tv;
        public IMyViewHolderClicks mListener;

        public ViewHolder(View view) {
            super(view);
            iv = (ImageView) view.findViewById(R.id.imageView);
            tv = (TextView) view.findViewById(R.id.textView);
        }

        @Override
        public void onClick(View v) {
            if (v instanceof ImageView) {
                mListener.onTomato((ImageView) v);
            } else {
                mListener.onPotato(v);
            }
        }

        public static interface IMyViewHolderClicks {
            public void onPotato(View caller);

            public void onTomato(ImageView callerImage);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        if (viewType == FruitInfo.FRUIT_XML_TYPE_LEFT) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_layout_left, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_layout_right, parent, false);
        }

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Fruit fruit = (Fruit) fruits.get(position);
        holder.iv.setImageResource(fruit.getResId());
        holder.tv.setText(fruit.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                int resId = fruit.getResId();
                String name = context.getResources().getResourceName(resId);
                name = name.split("/")[1];
                Toast.makeText(context, "name=" + name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    @Override
    public int getItemViewType(int position) {
        return ((Fruit) fruits.get(position)).getXmlType();
    }
}
