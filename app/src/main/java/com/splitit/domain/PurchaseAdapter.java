package com.splitit.domain;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.splitit.R;

import java.util.ArrayList;
import java.util.List;

public class PurchaseAdapter extends BaseExpandableListAdapter {

    Activity context;
    List <Purchase> purchases;
    private static LayoutInflater inflater = null;

    public PurchaseAdapter(Activity context, List<Purchase> purchases){
        this.context = context;
        this.purchases = purchases;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


//    public int getCount() {
//        return purchases.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return purchases.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View itemView = view;
//        itemView = (itemView == null) ? inflater.inflate(R.layout.list_item, null): itemView;
//        TextView name = itemView.findViewById(R.id.name);
//        TextView price = itemView.findViewById(R.id.purchase_price);
//        TextView date = itemView.findViewById(R.id.date_out);
//        Purchase purchase = purchases.get(i);
//        name.setText(purchase.getPurchaseName());
//        price.setText(Integer.toString(purchase.getPrice()));
//        date.setText(purchase.getDate().toString());
//        return itemView;
//    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View itemView = view;
        itemView = (itemView == null) ? inflater.inflate(R.layout.list_item, null): itemView;
        TextView name = itemView.findViewById(R.id.name);
        TextView price = itemView.findViewById(R.id.purchase_price);
        TextView date = itemView.findViewById(R.id.date_out);
        Purchase purchase = purchases.get(i);
        name.setText(purchase.getPurchaseName());
        price.setText(Integer.toString(purchase.getPrice()));
        date.setText(purchase.getDate().toString());
        return itemView;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
