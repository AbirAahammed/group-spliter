package com.splitit.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.splitit.R;
import com.splitit.domain.Purchase;
import com.splitit.domain.PurchaseAdapter;
import com.splitit.persistence.PurchaseList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    PurchaseList purchaseList = new PurchaseList();
    private List<Purchase> purchases = new ArrayList<>();
    private PurchaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListView();
    }

    public void populateListView() {
        listView =  findViewById(R.id.nameList);
        purchases = purchaseList.getPurchaseList();
        adapter = new PurchaseAdapter(this, purchases);
        listView.setAdapter(adapter);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this,);
    }
}
