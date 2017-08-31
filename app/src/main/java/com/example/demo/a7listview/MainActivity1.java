package com.example.demo.a7listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {
    private ListView listView;
    private List<String> fruits = new ArrayList<>();
    {
        fruits.add("kiwi");
        fruits.add("banana");
        fruits.add("melon");
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
        ListAdapter adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, fruits);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = fruits.get(position);
                Toast.makeText(MainActivity1.this, title, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
