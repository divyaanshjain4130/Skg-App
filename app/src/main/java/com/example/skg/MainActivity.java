package com.example.skg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.skg.adapters.main_adapter;
import com.example.skg.models.main_model;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        rv=findViewById(R.id.recycle);
        ArrayList<main_model> list=new ArrayList<>();

        list.add(new main_model(R.drawable.drinks,"drinks","10","Hard drink not for kids"));
        list.add(new main_model(R.drawable.sweets,"sweets","20","sweets"));
        list.add(new main_model(R.drawable.icecream,"ice cream","30","chocolate icecream"));
        list.add(new main_model(R.drawable.naan,"Breads","23","indian breadRoti"));
        list.add(new main_model(R.drawable.pulaw,"Rice","40","Rice"));
        list.add(new main_model(R.drawable.sweets,"Sweets","20","sweet"));

        main_adapter adapter1= new main_adapter(list,this);
        rv.setAdapter(adapter1);

        LinearLayoutManager layout=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(layout);
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