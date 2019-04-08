package com.rajendramishra.swipeable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SideOrders extends AppCompatActivity {
    Spinner spinner1,spinner2;
    Button b1,b2;
    TextView textView1,textView2;
    TextView price1,price2;
    DataBaseHelperAddCart mydb;
    String name,price,quantity;
    Boolean result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_orders);
        mydb=new DataBaseHelperAddCart(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SideOrders.this,CheckOut.class));
            }
        });
        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        price1=findViewById(R.id.price1);
        price2=findViewById(R.id.price2);
        String[] number_of_item={"0","1","2","3","4","5"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
    }
    public void addToCart(View view)
    {
        int id =view.getId();
        switch (id)
        {
            case R.id.b1:
                name=textView1.getText().toString().trim();
                price=price1.getText().toString().trim();
                quantity=spinner1.getSelectedItem().toString();
                if(quantity=="0") {
                    Toast.makeText(this, "please add atleast one quantity", Toast.LENGTH_SHORT).show();
                    result = false;
                }
                else
                    result = mydb.insertData(name,price,quantity);
                break;
            case R.id.b2:
                name=textView2.getText().toString().trim();
                price=price2.getText().toString().trim();
                quantity=spinner2.getSelectedItem().toString();
                if(quantity=="0") {
                    Toast.makeText(this, "please add atleast one quantity", Toast.LENGTH_SHORT).show();
                    result = false;
                }
                else
                    result = mydb.insertData(name,price,quantity);
                break;


        }
        if (result==true)
        {
            Toast.makeText(this, "Added To Cart", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Failed to Add To Cart", Toast.LENGTH_SHORT).show();
    }
}
