package com.example.skg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import com.example.skg.Databse.DBhelper;
import com.example.skg.databinding.ActivityCartPageBinding;

import java.text.DateFormat;
import java.util.Calendar;

public class cart_page extends AppCompatActivity {

    ActivityCartPageBinding binding;
    ImageView add1,sub1;
    TextView quant1,disp,loc;
    Integer c=1;
    String dis,bibha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBhelper dBhelper = new DBhelper(this);

//main activity se data cart page p display k lie yeh line of codes hai

            final int image = getIntent().getIntExtra("image", 0);
            final String price = getIntent().getStringExtra("price");
            final String name = getIntent().getStringExtra("name");
            final String desc = getIntent().getStringExtra("desc");

            quant1 = findViewById(R.id.quantity);
            add1 = findViewById(R.id.add);
            sub1 = findViewById(R.id.sub);
            disp = findViewById(R.id.pricelable);
            loc = findViewById(R.id.location);
            add1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c++;
                    dis = String.valueOf(c);
                    quant1.setText(dis);
                    int i = Integer.parseInt(dis);
                    int j = Integer.parseInt(price);
                    bibha = String.valueOf(i * j);
                    disp.setText(bibha);
                }
            });
            sub1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c--;
                    if (c < 1) c = 1;
                    dis = String.valueOf(c);
                    quant1.setText(dis);
                    int i = Integer.parseInt(dis);
                    int j = Integer.parseInt(price);
                    bibha = String.valueOf(i * j);
                    disp.setText(bibha);
                }

            });

            binding.detailFimage.setImageResource(image);
            binding.pricelable.setText(price);
            binding.detailFtext.setText(name);
            binding.desc.setText(desc);
            binding.orderBttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text= binding.nameBox.getText().toString();
                    if(text !=null&&text.length()!=0) {
                        Calendar calendar=Calendar.getInstance();
                        String calender= DateFormat.getDateInstance().format(calendar.getTime());
                        System.out.println(calender);

                        boolean isInserted = dBhelper.insertOrder(binding.nameBox.getText().toString(),
                                binding.phonebox.getText().toString(),
                                price,
                                image,
                                desc,
                                name,
                                Integer.parseInt(binding.quantity.getText().toString()),
                                binding.location.getText().toString(),
                                calender);
                        System.out.println(binding.location.getText().toString());
                        if (isInserted){
                            Toast.makeText(cart_page.this, "ORDER PLACED YAYY!!", Toast.LENGTH_SHORT).show();
                        finish();}
                        else Toast.makeText(cart_page.this,"error in input",Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(cart_page.this, "Enter Your name", Toast.LENGTH_SHORT).show();

                    }
            });
//        //}
//        //else{
//            int id = getIntent().getIntExtra("id", 0);
//            Cursor cursor = dBhelper.getOrderByid(id);
//            binding.nameBox.setText(cursor.getString(1));
//            binding.phonebox.setText(cursor.getString(2));
//            binding.orderBttn.setText("update");
//
//            binding.orderBttn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    boolean isUp = dBhelper.updateOrder(
//                            binding.nameBox.getText().toString(), binding.phonebox.getText().toString(),
//                            (binding.pricelable.getText().toString()),
//                            image,
//                            binding.desc.getText().toString(),
//                            binding.detailFtext.getText().toString(),
//                            1,
//                            id
//                    );
//                    if (isUp) Toast.makeText(cart_page.this, "updated", Toast.LENGTH_SHORT).show();
//                    else
//                        Toast.makeText(cart_page.this, "------------------", Toast.LENGTH_SHORT).show();
//          //      }
//          //  });
//        //}
}
    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.myOrder:
                    Intent in =new Intent(this,Activity_order.class);
                    startActivity(in);
            }
            return super.onOptionsItemSelected(item);
        }
    }
