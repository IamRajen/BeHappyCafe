package com.rajendramishra.swipeable;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddAddress extends AppCompatActivity {


    DataBaseHelperAddCart dataBaseHelperAddCart;
    DatabaseHelperYourOrders databaseHelperYourOrders;
    List<UserName> username;
    List<UserAddress> useraddress;
    List<UserPhoneNumber> userphonenumber;
    List<UserEmailId> useremailid;
    DatabaseNames databaseNames;
    DatabasePhoneNumber databasePhoneNumber;
    DatabaseEmailId databaseEmailId;
    DatabaseAddress databaseAddress;
    ListView listView;
    String itemNameQuantityPrice="",addr="";
    String[] addresses,names,mailId,phoneNumber;
    Date date;
    Spinner spinner1,spinner2,spinner3,spinner4;
    ArrayAdapter<String> adapter1,adapter2,adapter3,adapter4;
    TextInputEditText textInputEditText1,textInputEditText2,textInputEditText3,textInputEditText4;
    int i=0;


    int total=0;
    private static final int MY_PERMISSION_REQUEST_SEND_SMS=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        username=new ArrayList<>();
        useraddress=new ArrayList<>();
        useremailid=new ArrayList<>();
        userphonenumber=new ArrayList<>();
        databaseNames=new DatabaseNames(this);
        databaseAddress=new DatabaseAddress(this);
        databaseEmailId=new DatabaseEmailId(this);
        databasePhoneNumber=new DatabasePhoneNumber(this);
        //listView=findViewById(R.id.userData);
        dataBaseHelperAddCart=new DataBaseHelperAddCart(this);
        databaseHelperYourOrders=new DatabaseHelperYourOrders(this);
        date= Calendar.getInstance().getTime();
        spinner1=findViewById(R.id.name_book);
        spinner2=findViewById(R.id.address_book);
        spinner3=findViewById(R.id.phone_book);
        spinner4=findViewById(R.id.mail_book);
        textInputEditText1=findViewById(R.id.name);
        textInputEditText2=findViewById(R.id.address);
        textInputEditText3=findViewById(R.id.phoneNumber1);
        textInputEditText4=findViewById(R.id.emailId);

    }
    @Override
    public void onStart()
    {

        int length_name=databaseNames.dataPresent();
        int length_address=databaseAddress.dataPresent();
        int length_emailId=databaseEmailId.dataPresent();
        int length_phoneNumber=databasePhoneNumber.dataPresent();
        addresses=new String[length_address];
        names=new String[length_name];
        mailId=new String[length_emailId];
        phoneNumber=new String[length_phoneNumber];
        super.onStart();
        username=databaseNames.getAppCategoryDetail();
        useraddress=databaseAddress.getAppCategoryDetail();
        useremailid=databaseEmailId.getAppCategoryDetail();
        userphonenumber=databasePhoneNumber.getAppCategoryDetail();
        i=0;
        for(UserName userName:username){
            names[i++]=userName.getName().toUpperCase();
        }
        i=0;
        for(UserAddress userAddress:useraddress){
            addresses[i++]=userAddress.getAddress();
        }
        i=0;
        for(UserPhoneNumber userPhoneNumber:userphonenumber){
            phoneNumber[i++]=userPhoneNumber.getPhoneNumber();
       }
        i=0;
        for(UserEmailId userEmailId:useremailid){
            mailId[i++]=userEmailId.getEmailId();
        }
        adapter1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,names);
        adapter2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,addresses);
        adapter3=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,phoneNumber);
        adapter4=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,mailId);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);


        // UserInformationAdapter adapter=new UserInformationAdapter(AddAddress.this,data);
        //listView.setAdapter(adapter);
    }



    public void addName(View view)
    {

        if(textInputEditText1.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Field Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean result = databaseNames.insertData(textInputEditText1.getText().toString().trim());
            if (result == true) {
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                textInputEditText1.setText("");
                onStart();
            } else
                Toast.makeText(this, "Failed to Insert Data", Toast.LENGTH_SHORT).show();
        }
    }
    public void addAddress(View view)
    {
        if(textInputEditText2.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Field Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean result = databaseAddress.insertData(textInputEditText2.getText().toString().trim());
            if (result == true) {
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                textInputEditText2.setText("");
                onStart();
            } else
                Toast.makeText(this, "Failed to Insert Data", Toast.LENGTH_SHORT).show();
        }
    }
    public void addNumber(View view)
    {
        if(textInputEditText3.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Field Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean result = databasePhoneNumber.insertData(textInputEditText3.getText().toString().trim());
            if (result == true) {
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                textInputEditText3.setText("");
                onStart();
            } else
                Toast.makeText(this, "Failed to Insert Data", Toast.LENGTH_SHORT).show();
        }
    }
    public void addEmailId(View view)
    {
        if(textInputEditText4.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Field Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean result = databaseEmailId.insertData(textInputEditText4.getText().toString().trim());
            if (result == true) {
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                textInputEditText4.setText("");
                onStart();
            } else
                Toast.makeText(this, "Failed to Insert Data", Toast.LENGTH_SHORT).show();
        }
    }

   public void checkout(View view)
   {
       //store the user data from selected address book in string "msg"
       String msg="";
       String name=spinner1.getSelectedItem().toString();
       String address=spinner2.getSelectedItem().toString();
       String phoneNumber =spinner3.getSelectedItem().toString();
       String emailId =spinner4.getSelectedItem().toString();
        for(Cart s:CheckOut.data)
        {
            msg+=s.getProduct_name()+"\n";
            msg+="Quantity: "+s.getQuantity()+"\n";
            msg+="Price: "+s.getPrice()+"\n";
            total+=(Integer.parseInt(s.getPrice())*Integer.parseInt(s.getQuantity()));

        }
        msg+="\nTotal : "+Integer.toString(total);
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permissionCheck== PackageManager.PERMISSION_GRANTED)
        {
            String number=MainActivity.owner_number;
            if(msg==""){
                Toast.makeText(this, "Nothing to Order", Toast.LENGTH_SHORT).show();
            }
            else if(name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty() || emailId.isEmpty())
            {
                Toast.makeText(this, "Please Select Proper Address", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isDigitsOnly(number))
            {
                msg+="\n\nUser Details : \n\n"+name+"\n"+address+"\n"+phoneNumber+"\n"+emailId+"\n";
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,msg,null,null);
                Toast.makeText(this, "Order Placed", Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Thank You For Ordering", Toast.LENGTH_LONG).show();
                //deleting all data from cart database...
                for(Cart items:CheckOut.data)
                {
                    itemNameQuantityPrice+=items.getProduct_name()+"\nPrice: "+items.getPrice()+"\nQuantity: "+items.getQuantity()+"\n\n";
                }
                Boolean result= databaseHelperYourOrders.insertData(itemNameQuantityPrice,Integer.toString(total),date.toString());

                dataBaseHelperAddCart.deleteAllData();
            }
            else
            {
                Toast.makeText(this, "Order Could Not Be Placed", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_SEND_SMS);
        }

   }
}
