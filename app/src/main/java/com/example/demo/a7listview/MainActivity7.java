package com.example.demo.a7listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class MainActivity7 extends AppCompatActivity {
    private ListView listView;
    private List<Fruit> fruits = new ArrayList<>();
    {
        fruits.add(new Fruit(R.drawable.apple, "Apple"));
        fruits.add(new Fruit(R.drawable.banana, "Banana"));
        fruits.add(new Fruit(R.drawable.coconut, "Coconut"));
        fruits.add(new Fruit(R.drawable.kiwi, "Kiwi"));
        fruits.add(new Fruit(R.drawable.lemon, "Lemon"));
        fruits.add(new Fruit(R.drawable.orange, "Orange"));
        fruits.add(new Fruit(R.drawable.strawberry, "Strawberry"));
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
                Toast.makeText(MainActivity7.this, name, Toast.LENGTH_SHORT).show();
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
            Log.w("XXX", parent.toString());
            ViewHolder holder = null;

            if (convertView == null) {
//                LayoutInflater inflater = (LayoutInflater) getSystemService(
//                        Context.LAYOUT_INFLATER_SERVICE);

                /**
                 * root=parent 에서 parent의 실체는 리스트뷰이다.
                 * attachToRoot=true 인 경우, 생성된 레이아웃 뷰의 부모로 루트를 지정한다.
                 * attachToRoot=false 인 경우, 루트에 대한 LayoutParams 값 세트를 제공하는 객체로만 사용한다.
                 * 사용하지 않는 경우는 null을 입력한다.
                 */
                convertView = LayoutInflater.from(MainActivity7.this)
                        .inflate(R.layout.list_layout, parent, false);

                holder = new ViewHolder();
                holder.iv = (ImageView) convertView.findViewById(R.id.imageView);
                holder.tv = (TextView) convertView.findViewById(R.id.textView);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.iv.setImageResource(((Fruit) getItem(position)).getResId());
            holder.tv.setText(((Fruit) getItem(position)).getName());

            return convertView;
        }

        class ViewHolder {
            ImageView iv;
            TextView tv;
        }
    }
}
