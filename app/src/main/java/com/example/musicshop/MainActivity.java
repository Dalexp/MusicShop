package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void increaseQuantity(View view) {
        quantity+=1;
        if(quantity>9){
            quantity=9;
        }
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText(""+ quantity);
    }

    public void decreaseQuantity(View view) {
        quantity-=1;
        if(quantity<0){
            quantity=0;
        }
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);
    }
}
