package com.splitit.presentation;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.splitit.R;
import com.splitit.domain.Purchase;
import com.splitit.persistence.AddPurchase;
import com.splitit.persistence.PopulateList;

public class AddNewPurchaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_purchase);
        Button button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText price = findViewById(R.id.value_price);
                EditText name = findViewById(R.id.value_purchase_name);
                AddPurchase pop = new AddPurchase(AddNewPurchaseActivity.this, new Purchase(name.getText().toString(),Integer.parseInt(price.getText().toString())));
                pop.execute();
            }
        });
    }
}
