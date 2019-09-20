package com.splitit.persistence;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.splitit.domain.Purchase;
import com.splitit.domain.PurchaseAdapter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PopulateList extends AsyncTask<String, Void, List<Purchase>> {
    private static final String url = "jdbc:mysql://192.168.0.15:3306/purchase_data";
    private static final String user = "abir";
    private static final String pass = "F0xtrot";
    List<Purchase> res = new ArrayList<>();
    ListView listView;
    Activity activity;
    public PopulateList(ListView listView, Activity activity){
        this.listView = listView;
        this.activity = activity;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(activity, "Please wait...", Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    protected List<Purchase> doInBackground(String... params) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            List <Purchase> result = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(params[0]);
            while (rs.next()) {
                result.add( new Purchase(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getDate(4)));
            }
            res = result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


    @Override
    protected  void onPostExecute(List<Purchase> result) {
        ListAdapter adapter = new PurchaseAdapter(activity, result);
        listView.setAdapter(adapter);
    }
}
