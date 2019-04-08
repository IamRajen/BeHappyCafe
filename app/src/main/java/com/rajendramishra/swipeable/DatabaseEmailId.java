package com.rajendramishra.swipeable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseEmailId extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "UserEmailId.db";
    public static final String TABLE_NAME="UserEmailId";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "EMAIL_ID";



    public DatabaseEmailId(Context context)
    {
        super(context , DATABASE_NAME , null , 1 );
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,EMAIL_ID TEXT)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public boolean insertData(String emailId)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,emailId);
        long result=db.insert(TABLE_NAME,null,contentValues);
        db.close();

        if(result==-1)
            return false;
        else
            return true;
    }
    public ArrayList<UserEmailId> getAppCategoryDetail() {

        final String TABLE_NAME = DatabaseEmailId.TABLE_NAME;

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        ArrayList<UserEmailId> data      = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                UserEmailId information=new UserEmailId();
                information.setEmailId(cursor.getString(cursor.getColumnIndex(COL_2)));
                data.add(information);
                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }
    public int dataPresent()
    {
        final String TABLE_NAME = DatabaseEmailId.TABLE_NAME;
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
