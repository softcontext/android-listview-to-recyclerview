package com.example.demo.a7listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.demo.a7listview.MyAdapter.FruitInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity9 extends AppCompatActivity {
    private ListView listView;
    private List<Fruit> fruits = new ArrayList<>();
    {
        fruits.add(new Fruit(R.drawable.apple, "Apple", 1));
        fruits.add(new Fruit(R.drawable.banana, "Banana", FruitInfo.FRUIT_XML_TYPE_RIGHT));
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
        MyAdapter adapter = new MyAdapter(this, fruits);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit f = fruits.get(position);
                int resId = f.getResId();
                // 리소스 관리 객체에게 리소스 아이디로 리소스 이름을 묻는다.
                String name = getResources().getResourceName(resId);
                name = name.split("/")[1];
                Toast.makeText(MainActivity9.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
