package com.example.skg.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.skg.models.order_model;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {

    final static String DBname = "mydatabase1.db";
    final static int ver = 1;

    public DBhelper(@Nullable Context context) {
        super(context, DBname, null, ver);
    }

    /*
    id=0
    user name=1
    phone=2
    price=3
    image=4
    desc=5
    foodname=6
    quantity=7
    */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders" +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price integer," +
                        "image integer," +
                        "description text," +
                        "foodname text," +
                        "quantity integer,"+
                        "loc text,"+
                        "date text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP table if exists orders");
        onCreate(db);
    }
    public void reset(String tableName){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DROP table if exists "+tableName);
        onCreate(db);
    }

    public boolean insertOrder(String Username, String phone, String price, int image, String desc, String Fname, int quantity,String loc,String date) {
        SQLiteDatabase databse = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", Username);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname", Fname);
        values.put("quantity", quantity);
        values.put("loc",loc);
        values.put("date",date);
        long id = databse.insert("orders", null, values);
        if (id == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<order_model> getorder() {
        ArrayList<order_model> order = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select id,foodname,image,price,description from orders", null);
        if (cursor.moveToNext()) {
            while (cursor.moveToNext()) {
                order_model model = new order_model();
                model.setOrderNumb(cursor.getString(0));
                model.setOrderName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getString(3) + "");
                model.setOrderDesc(cursor.getString(4));
                order.add(model);
            }
        }
        database.close();
        return order;
    }
    public Cursor getOrderByid(int id) {
    SQLiteDatabase database = this.getWritableDatabase();
    Cursor cursor = database.rawQuery("select * from orders where id="+id, null);
   if (cursor.getCount()>0)
       cursor.moveToFirst();
    return cursor;
    }
    public boolean updateOrder(String Username, String phone, String price, int image, String desc, String Fname, int quantity,int id) {
        SQLiteDatabase databse = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", Username);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname", Fname);
        values.put("quantity", quantity);
        long row = databse.update("orders", values,"id="+id,null );
        if (id == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int delete(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("orders","id="+id,null);
}
}
