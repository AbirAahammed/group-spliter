package com.splitit.domain;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.splitit.R;

import java.util.ArrayList;

public class PurchaseAdapter extends BaseAdapter {

    Activity context;
    ArrayList <Purchase> purchases;
    private static LayoutInflater inflater = null;

    public PurchaseAdapter(Activity context, ArrayList<Purchase> purchases){
        this.context = context;
        this.purchases = purchases;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public int getCount() {
        return purchases.size();
    }

    @Override
    public Object getItem(int i) {
        return purchases.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        itemView = (itemView == null) ? inflater.inflate(R.layout.list_item, null): itemView;
        TextView name = itemView.findViewById(R.id.Name);
        TextView price = itemView.findViewById(R.id.Price);
        Purchase purchase = purchases.get(i);
        name.setText(purchase.getPurchaseName());
        name.setText(purchase.getPrice());
        return itemView;
    }
}
