package com.rajendramishra.swipeable;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelperAddCart extends SQLiteOpenHelper{
    public static final String DATABASE_NAME= "AddCart1.db";
    public static final String TABLE_NAME="AddCart_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "ITEM_NAME";
    public static final String COL_3 = "PRICE";
    public static final String COL_4="QUANTITY";
    public static  int total=0;

    public DataBaseHelperAddCart(Context context)
    {
        super(context , DATABASE_NAME , null , 1 );
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,ITEM_NAME TEXT,PRICE TEXT,QUANTITY TEXT)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public boolean insertData(String itemName,String price,String quantity)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,itemName);
        contentValues.put(COL_3,price);
        contentValues.put(COL_4,quantity);
        long result=db.insert(TABLE_NAME,null,contentValues);
        db.close();

        if(result==-1)
            return false;
        else
            return true;
    }
    public ArrayList<Cart> getAppCategoryDetail() {

        final String TABLE_NAME = DataBaseHelperAddCart.TABLE_NAME;

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        ArrayList<Cart> data      = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Cart cart=new Cart();
                cart.setId(cursor.getString(cursor.getColumnIndex(COL_1)));
                cart.setProduct_name(cursor.getString(cursor.getColumnIndex(COL_2)));
                cart.setPrice(cursor.getString(cursor.getColumnIndex(COL_3)));
                cart.setQuantity(cursor.getString(cursor.getColumnIndex(COL_4)));
                //total+=Integer.parseInt(cart.getPrice());
                data.add(cart);
                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }
    public Integer deleteData(int  id){
        String id1=String.valueOf(id);
        SQLiteDatabase db=this.getWritableDatabase();
        int i=db.delete(TABLE_NAME,"ID=?",new String[]{id1});
        return  i;
    }
    public void deleteAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
    }
    public int dataPresent()
    {
        final String TABLE_NAME = DataBaseHelperAddCart.TABLE_NAME;
        int count=0;
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        //ArrayList<Cart> data      = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                    count++;
                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return count;
    }

}
