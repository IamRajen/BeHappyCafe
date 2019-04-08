package com.rajendramishra.swipeable;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    String uriString;
    RatingBar ratingBar;
    float ratings=0.0f;
    private static final int MY_PERMISSION_REQUEST_SEND_SMS=0;
    TextInputEditText textInputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        textInputEditText=findViewById(R.id.feedback);
        ratingBar=findViewById(R.id.ratings);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratings=rating;
            }
        });
    }

    public void whatsapp(View view)
    {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"Rajendra is Great");
        intent.setPackage("com.whatsapp");
        startActivity(intent);
    }
    public void facebook(View view)
    {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        uriString="https://www.facebook.com/behappycafebodhgaya/";
        intent.putExtra(Intent.EXTRA_TEXT,uriString);
        intent.setPackage("com.facebook.katana");
        startActivity(intent);
    }
    public void sendFeedback(View view)
    {
        String feedback_data=textInputEditText.getText().toString().trim();
        feedback_data=feedback_data+"\n"+"Rating:- "+ratings;
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permissionCheck== PackageManager.PERMISSION_GRANTED)
        {
            String number=MainActivity.owner_number;
            if(feedback_data==""){
                Toast.makeText(this, "Field Empty", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isDigitsOnly(number))
            {
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,feedback_data,null,null);
                Toast.makeText(this, "Thanks for your feedback", Toast.LENGTH_SHORT).show();
                textInputEditText.setText("");
                ratingBar.setRating(0.0f);
            }
            else
            {
                Toast.makeText(this, "An Error occurred", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_SEND_SMS);
        }
    }

}
