package com.rajendramishra.swipeable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAddress extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "UserAddress.db";
    public static final String TABLE_NAME="UserAddress";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "ADDRESS";



    public DatabaseAddress(Context context)
    {
        super(context , DATABASE_NAME , null , 1 );
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,ADDRESS TEXT)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public boolean insertData(String address)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,address);
        long result=db.insert(TABLE_NAME,null,contentValues);
        db.close();

        if(result==-1)
            return false;
        else
            return true;
    }
    public ArrayList<UserAddress> getAppCategoryDetail() {

        final String TABLE_NAME = DatabaseAddress.TABLE_NAME;

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        ArrayList<UserAddress> data      = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                UserAddress information=new UserAddress();
                information.setAddress(cursor.getString(cursor.getColumnIndex(COL_2)));
                data.add(information);
                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }
    public int dataPresent()
    {
        final String TABLE_NAME = DatabaseAddress.TABLE_NAME;
        int count=0;
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                count++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        return count;
    }
}
