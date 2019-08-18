package com.splitit.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.splitit.R;
import com.splitit.domain.Purchase;
import com.splitit.domain.PurchaseAdapter;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Purchase> purchases = new ArrayList<>();
    private PurchaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListView();
    }

    public void populateListView() {
        listView =  findViewById(R.id.listViewPurchases);
        purchases.add(new Purchase(1,"Veggi", 34, new Date()));
        purchases.add(new Purchase(2,"meat", 34, new Date()));
        purchases.add(new Purchase(3,"rice", 34, new Date()));
        purchases.add(new Purchase(4,"chicken", 34, new Date()));
        purchases.add(new Purchase(5,"duck", 34, new Date()));
        purchases.add(new Purchase(6,"eto", 34, new Date()));
        purchases.add(new Purchase(7,"beef", 34, new Date()));
        adapter = new PurchaseAdapter(this, purchases);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "Click to item: " + i, Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
