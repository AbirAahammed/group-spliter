package com.splitit.persistence;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.splitit.R;
import com.splitit.domain.Purchase;
import com.splitit.domain.PurchaseAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddPurchase extends AsyncTask<String, Void, String> {
    private static final String url = "jdbc:mysql://192.168.0.15:3306/purchase_data";
    private static final String user = "abir";
    private static final String pass = "F0xtrot";
    List<Purchase> res = new ArrayList<>();
    Activity activity;
    Purchase purchase;
    public AddPurchase(Activity activity, Purchase purchase){
        this.activity = activity;
        this.purchase = purchase;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            String stmt = String.format("INSERT INTO purchases\n" +
                    "(purchase_title, price, purchase_date)\n" +
                    "VALUES('%s', %d , NOW())",purchase.getPurchaseName(), purchase.getPrice());
            st.executeUpdate(stmt);
            return "SUCCESS";
        } catch (Exception e){
            Log.e("ERROR", e.getMessage());
            return "FAILURE";
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(activity, "Please wait...", Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    protected  void onPostExecute(String string) {
        new Activity().setContentView(R.layout.activity_main);
    }


}
