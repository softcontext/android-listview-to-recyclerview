package com.example.demo.a7listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.demo.a7listview.MyAdapter.FruitInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity10 extends AppCompatActivity {
    private ListView listView;
    private List<Fruit> fruits = new ArrayList<>();
    {
        fruits.add(new Fruit(R.drawable.apple, "Apple", FruitInfo.FRUIT_XML_TYPE_LEFT));
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

    private RecyclerView recyclerView;
    private FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        
        settings();
    }

    private void settings() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        
        fruitAdapter = new FruitAdapter(fruits);

        // 데이터의 개수가 고정일 때 설정하면 보다 빠르다.
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(fruitAdapter);
    }

}
