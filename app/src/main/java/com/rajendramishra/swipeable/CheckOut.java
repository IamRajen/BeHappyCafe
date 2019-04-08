package com.rajendramishra.swipeable;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class CheckOut extends AppCompatActivity {

    DataBaseHelperAddCart myDb;
    TextView result,total_price;
    static List<Cart> data;
    ListView listView;
    Button button;
    static int total=0;

    //private static final int MY_PERMISSION_REQUEST_SEND_SMS=0;
    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_check_out);
        //result=findViewById(R.id.result);
        data=new ArrayList<>();
        myDb=new DataBaseHelperAddCart(this);
        listView=findViewById(R.id.nameList);
        total_price=findViewById(R.id.total);
        //button.setOnClickListener(this);
    }
    public void onStart()
    {
        super.onStart();
        total=0;
        data=myDb.getAppCategoryDetail();
        CartAdapter adapter=new CartAdapter(CheckOut.this,data);
        listView.setAdapter(adapter);
        for(Cart value :data)
        {
            total+=(Integer.parseInt(value.getPrice())*Integer.parseInt(value.getQuantity()));
        }
        total_price.setText(""+Integer.toString(total));
    }

   /* public void onClick(View view)
    {
        ViewParent viewParent =view.getParent();

    }*/
    public void checkout(View view)
    {
        if(data.isEmpty())
        {
            Toast.makeText(this, "Cart is Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            startActivity(new Intent(this, AddAddress.class));

        /*int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permissionCheck== PackageManager.PERMISSION_GRANTED)
        {
            String number=MainActivity.owner_number;
            String msg="order placed";
            if(msg==""){
                Toast.makeText(this, "Nothing to Order", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isDigitsOnly(number))
            {
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,msg,null,null);
                Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Order Could Not Be Placed", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_SEND_SMS);
        }*/
        }

    }

    public void deleteAll(View view)
    {
        //delete all the elements for the database add cart....
        myDb.deleteAllData();
        onStart();
    }

}
