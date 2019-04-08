package com.rajendramishra.swipeable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class YourOrders extends AppCompatActivity {
    DatabaseHelperYourOrders databaseHelperYourOrders;
    List<Orders> data1;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_orders);
        listView=findViewById(R.id.orderList);
        databaseHelperYourOrders=new DatabaseHelperYourOrders(this);
        data1=new ArrayList<>();
    }
    public void onStart()
    {
        super.onStart();
        data1=databaseHelperYourOrders.getOrderData();
        OrderAdapter adapter=new OrderAdapter(YourOrders.this,data1);
        listView.setAdapter(adapter);

    }


}
