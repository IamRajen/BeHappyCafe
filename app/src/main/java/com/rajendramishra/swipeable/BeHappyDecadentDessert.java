package com.rajendramishra.swipeable;

import android.content.Context;
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

public class BeHappyDecadentDessert extends AppCompatActivity {

    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;
    TextView price1,price2,price3,price4,price5,price6,price7,price8,price9;
    DataBaseHelperAddCart mydb;
    String name,price,quantity;
    Boolean result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_happy_decadent_dessert);
        mydb=new DataBaseHelperAddCart(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BeHappyDecadentDessert.this,CheckOut.class));
            }
        });
        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner3=(Spinner)findViewById(R.id.spinner3);
        spinner4=(Spinner)findViewById(R.id.spinner4);
        spinner5=(Spinner)findViewById(R.id.spinner5);
        spinner6=(Spinner)findViewById(R.id.spinner6);
        spinner7=(Spinner)findViewById(R.id.spinner7);
        spinner8=(Spinner)findViewById(R.id.spinner8);
        spinner9=(Spinner)findViewById(R.id.spinner9);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        textView3=findViewById(R.id.text3);
        textView4=findViewById(R.id.text4);
        textView5=findViewById(R.id.text5);
        textView6=findViewById(R.id.text6);
        textView7=findViewById(R.id.text7);
        textView8=findViewById(R.id.text8);
        textView9=findViewById(R.id.text9);
        price1=findViewById(R.id.price1);
        price2=findViewById(R.id.price2);
        price3=findViewById(R.id.price3);
        price4=findViewById(R.id.price4);
        price5=findViewById(R.id.price5);
        price6=findViewById(R.id.price6);
        price7=findViewById(R.id.price7);
        price8=findViewById(R.id.price8);
        price9=findViewById(R.id.price9);
        String[] number_of_item={"0","1","2","3","4","5"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter3=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter4=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter5=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter6=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter7=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter8=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        ArrayAdapter<String> adapter9=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,number_of_item);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
        spinner5.setAdapter(adapter5);
        spinner6.setAdapter(adapter6);
        spinner7.setAdapter(adapter7);
        spinner8.setAdapter(adapter8);
        spinner9.setAdapter(adapter9);

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
            case R.id.b4:
                name=textView4.getText().toString().trim();
                price=price4.getText().toString().trim();
                quantity=spinner4.getSelectedItem().toString();
                if(quantity=="0") {
                    Toast.makeText(this, "please add atleast one quantity", Toast.LENGTH_SHORT).show();
                    result = false;
                }
                else
                    result = mydb.insertData(name,price,quantity);
                break;
            case R.id.b5:
                name=textView5.getText().toString().trim();
                price=price5.getText().toString().trim();
                quantity=spinner5.getSelectedItem().toString();
                if(quantity=="0") {
                    Toast.makeText(this, "please add atleast one quantity", Toast.LENGTH_SHORT).show();
                    result = false;
                }
                else
                    result = mydb.insertData(name,price,quantity);
                break;
            case R.id.b6:
                name=textView6.getText().toString().trim();
                price=price6.getText().toString().trim();
                quantity=spinner6.getSelectedItem().toString();
                if(quantity=="0") {
                    Toast.makeText(this, "please add atleast one quantity", Toast.LENGTH_SHORT).show();
                    result = false;
                }
                else
                    result = mydb.insertData(name,price,quantity);
                break;
            case R.id.b7:
                name=textView7.getText().toString().trim();
                price=price7.getText().toString().trim();
                quantity=spinner7.getSelectedItem().toString();
                if(quantity=="0") {
                    Toast.makeText(this, "please add atleast one quantity", Toast.LENGTH_SHORT).show();
                    result = false;
                }
                else
                    result = mydb.insertData(name,price,quantity);
                break;
            case R.id.b8:
                name=textView8.getText().toString().trim();
                price=price8.getText().toString().trim();
                quantity=spinner8.getSelectedItem().toString();
                if(quantity=="0") {
                    Toast.makeText(this, "please add atleast one quantity", Toast.LENGTH_SHORT).show();
                    result = false;
                }
                else
                    result = mydb.insertData(name,price,quantity);
                break;
            case R.id.b9:
                name=textView9.getText().toString().trim();
                price=price9.getText().toString().trim();
                quantity=spinner9.getSelectedItem().toString();
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
