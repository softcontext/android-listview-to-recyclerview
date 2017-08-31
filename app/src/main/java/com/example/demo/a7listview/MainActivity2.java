package com.example.demo.a7listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ListView listView;
    private List<Integer> fruits = new ArrayList<>();
    {
        fruits.add(R.drawable.apple);
        fruits.add(R.drawable.banana);
        fruits.add(R.drawable.coconut);
        fruits.add(R.drawable.kiwi);
        fruits.add(R.drawable.lemon);
        fruits.add(R.drawable.orange);
        fruits.add(R.drawable.strawberry);
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
        // 이미지뷰 처리는 ArrayAdapter로 처리할 수 없다.
//        ListAdapter adapter = new ArrayAdapter<Integer>(
//                this, android.R.layout.simple_list_item_1, fruits);

        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int resId = fruits.get(position);
                // 리소스 관리 객체에게 리소스 아이디로 리소스 이름을 묻는다.
                String name = getResources().getResourceName(resId);
                name = name.split("/")[1];
                Toast.makeText(MainActivity2.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyAdapter extends BaseAdapter{

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
            ImageView iv = new ImageView(MainActivity2.this);
            iv.setImageResource((Integer) getItem(position));

            return iv;
        }
    }
}
