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

public class OatMealPorridge extends AppCompatActivity {
    Spinner spinner1,spinner2,spinner3;
    Button b1,b2,b3;
    TextView textView1,textView2,textView3;
    TextView price1,price2,price3;
    DataBaseHelperAddCart mydb;
    String name,price,quantity;
    Boolean result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oat_meal_porridge);
        mydb=new DataBaseHelperAddCart(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OatMealPorridge.this,CheckOut.class));
            }
        });
        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner3=(Spinner)findViewById(R.id.spinner3);
        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        textView3=findViewById(R.id.text3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        price1=findViewById(R.id.price1);
        price2=findViewById(R.id.price2);
        price3=findViewById(R.id.price3);
        String[] number_of_item={"0","1","2","3","4","5"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter3=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
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
            case R.id.b3:
                name=textView3.getText().toString().trim();
                price=price3.getText().toString().trim();
                quantity=spinner3.getSelectedItem().toString();
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
