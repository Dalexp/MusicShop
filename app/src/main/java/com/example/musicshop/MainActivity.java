package com.example.musicshop;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity=0;
    Spinner spinner;
    ArrayList <String> spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap <String,Double> goodsMap;
    String goodsName;
    double price;
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText=findViewById(R.id.editText);

        createSpinner();

        createMap();

    }
    @Nullable
    void createSpinner(){
        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList<>();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createMap(){
        goodsMap = new HashMap<>();
        goodsMap.put("guitar",500.0);
        goodsMap.put("drums",800.0);
        goodsMap.put("keyboard",1200.0);
    }

    public void increaseQuantity(View view) {
        quantity+=1;
        if(quantity>9){
            quantity=9;
        }
        String operation=""+quantity;
        String operationPrice="" + quantity * price;

        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText(operation);

        TextView priceTextView=findViewById(R.id.priceTextView);
        priceTextView.setText(operationPrice);
    }

    public void decreaseQuantity(View view) {
        quantity-=1;
        if(quantity<0){
            quantity=0;
        }
        String operation=""+quantity;
        String operationPrice="" + quantity * price;

        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText(operation);

        TextView priceTextView=findViewById(R.id.priceTextView);
        priceTextView.setText(operationPrice);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String operationPrice="" + quantity * price;

        goodsName=spinner.getSelectedItem().toString();
        price = goodsMap.get(goodsName);

        TextView priceTextView=findViewById(R.id.priceTextView);
        priceTextView.setText(operationPrice);

        ImageView goodsImageView=findViewById(R.id.guitarImage);

        switch (goodsName)
        {
            case "guitar":
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
            case "drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;
            case "keyboard":
                goodsImageView.setImageResource(R.drawable.keyboard);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCart(View view) {

        Order order =new Order();

        order.userName=userNameEditText.getText().toString();

        order.goodsName = goodsName;

        order.quantity=quantity;
        
        order.orderPrice=quantity*price;

    }
}
