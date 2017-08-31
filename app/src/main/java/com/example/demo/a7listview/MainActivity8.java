package com.example.demo.a7listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity8 extends AppCompatActivity {
    private ListView listView;
    private List<Fruit> fruits = new ArrayList<>();
    {
        fruits.add(new Fruit(R.drawable.apple, "Apple", 1));
        fruits.add(new Fruit(R.drawable.banana, "Banana", 0));
        fruits.add(new Fruit(R.drawable.coconut, "Coconut", 1));
        fruits.add(new Fruit(R.drawable.kiwi, "Kiwi", 0));
        fruits.add(new Fruit(R.drawable.lemon, "Lemon", 1));
        fruits.add(new Fruit(R.drawable.orange, "Orange", 0));
        fruits.add(new Fruit(R.drawable.strawberry, "Strawberry", 1));
        fruits.add(new Fruit(R.drawable.apple, "Apple", 0));
        fruits.add(new Fruit(R.drawable.banana, "Banana", 1));
        fruits.add(new Fruit(R.drawable.coconut, "Coconut", 0));
        fruits.add(new Fruit(R.drawable.kiwi, "Kiwi", 1));
        fruits.add(new Fruit(R.drawable.lemon, "Lemon", 0));
        fruits.add(new Fruit(R.drawable.orange, "Orange", 1));
        fruits.add(new Fruit(R.drawable.strawberry, "Strawberry", 0));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰 내부에 여러 뷰를 갖는 컨테이너에 뷰를 추가할 때 Adapter를 사용한다.
        listView = (ListView) findViewById(R.id.listView);

        settings();
    }

    private void settings() {
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit f = fruits.get(position);
                int resId = f.getResId();
                // 리소스 관리 객체에게 리소스 아이디로 리소스 이름을 묻는다.
                String name = getResources().getResourceName(resId);
                name = name.split("/")[1];
                Toast.makeText(MainActivity8.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        // 사용해야 하는 아이템의 디자인 복수인 경우 2개의 메소드를 추가로 재정의한다.
        @Override
        public int getItemViewType(int position) {
            return fruits.get(position).getXmlType();
        }

        @Override
        public int getViewTypeCount() {
            return 2;
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
                if (fruit.getXmlType() == 1) {
                    convertView = LayoutInflater.from(MainActivity8.this)
                            .inflate(R.layout.list_layout_left, parent, false);
                } else {
                    convertView = LayoutInflater.from(MainActivity8.this)
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
}
