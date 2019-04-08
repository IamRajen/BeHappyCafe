package com.rajendramishra.swipeable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelperYourOrders extends SQLiteOpenHelper{

    public static final String DATABASE_NAME= "Order_table.db";
    public static final String TABLE_NAME="Order_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "ITEM_NAMES_WITH_QUANTITY_AND_PRICE";
    public static final String COL_3 = "TOTAL_PRICE";
    public static final String COL_4 = "DATE";

    public DatabaseHelperYourOrders(Context context)
    {
        super(context , DATABASE_NAME , null , 1 );
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,ITEM_NAMES_WITH_QUANTITY_AND_PRICE TEXT,TOTAL_PRICE TEXT,DATE TEXT)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public boolean insertData(String itemName,String total_price,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,itemName);
        contentValues.put(COL_3,total_price);
        contentValues.put(COL_4,date);
        long result=db.insert(TABLE_NAME,null,contentValues);
        db.close();

        if(result==-1)
            return false;
        else
            return true;
    }
    public ArrayList<Orders> getOrderData() {

        final String TABLE_NAME = DatabaseHelperYourOrders.TABLE_NAME;

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        ArrayList<Orders> data      = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Orders orders=new Orders();
                orders.setId(cursor.getString(cursor.getColumnIndex(COL_1)));
                orders.setItemWithQuantityAndPrice(cursor.getString(cursor.getColumnIndex(COL_2)));
                orders.setTotal_price(cursor.getString(cursor.getColumnIndex(COL_3)));
                orders.setCurrentDate(cursor.getString(cursor.getColumnIndex(COL_4)));
                data.add(orders);
                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }



}

