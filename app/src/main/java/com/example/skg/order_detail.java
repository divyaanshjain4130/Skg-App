package com.example.skg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skg.Databse.DBhelper;

public class order_detail extends AppCompatActivity {

    TextView userName,location,itemName,quanti,pric,total,ornum,datee,phonenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        userName=findViewById(R.id.userName);
        location=findViewById(R.id.location1);
        itemName=findViewById(R.id.itemorder);
        quanti=findViewById(R.id.quantity1);
        pric=findViewById(R.id.price1);
        total=findViewById(R.id.total);
        ornum=findViewById(R.id.orderNumber1);
        datee=findViewById(R.id.date);
        phonenum=findViewById(R.id.pnumber);


       /* String name=getIntent().getStringExtra("name");
        String loc=getIntent().getStringExtra("loc");
        String quant=String.valueOf(getIntent().getStringExtra("quant"));
        String  phone=String.valueOf(getIntent().getStringExtra("phone"));
        String price=getIntent().getStringExtra("price");
        String foodname=getIntent().getStringExtra("foodname");
        */int id=Integer.parseInt((getIntent().getStringExtra("id")));
        // int pos=getIntent().getIntExtra("pos",0);


        DBhelper helper=new DBhelper(this);
        System.out.println("----"+helper.getOrderByid(id).getString(0)+"----");//ID
        System.out.println("----"+helper.getOrderByid(id).getString(1)+"----");//USER NAME
        System.out.println("----"+helper.getOrderByid(id).getString(2)+"----");//PHONE
        System.out.println("----"+helper.getOrderByid(id).getString(3)+"----");//PRICE
        System.out.println("----"+helper.getOrderByid(id).getString(4)+"----");//IMAGE
        System.out.println("----"+helper.getOrderByid(id).getString(5)+"----");//DESCRIPTION
        System.out.println("----"+helper.getOrderByid(id).getString(6)+"----");//ITEM NAME
        System.out.println("----"+helper.getOrderByid(id).getString(7)+"----");//QUANTITY
        System.out.println("----"+helper.getOrderByid(id).getString(8)+"----");//LOCATION
        System.out.println("----"+helper.getOrderByid(id).getString(9)+"----");//DATE


        String name=helper.getOrderByid(id).getString(1);
        String loc=helper.getOrderByid(id).getString(8);
        String foodname=helper.getOrderByid(id).getString(6);
        String quant=helper.getOrderByid(id).getString(7);
        String price=helper.getOrderByid(id).getString(3);
        int a,b;
        a=Integer.parseInt(quant);
        b=Integer.parseInt(price);
        String total1=String.valueOf(a*b);
        String id1=helper.getOrderByid(id).getString(0);
        String date1=helper.getOrderByid(id).getString(9);
        String phone=helper.getOrderByid(id).getString(2);


        userName.setText(name);
        location.setText(loc);
        itemName.setText(foodname);
        quanti.setText(quant);
        pric.setText(price);
        total.setText(total1);
        ornum.setText(id1);
        datee.setText(date1);
        phonenum.setText(phone);



//        datee
//                total
//

      /*  DBhelper dBhelper=new DBhelper(this);
        dBhelper.getReadableDatabase();
*/
    }
}