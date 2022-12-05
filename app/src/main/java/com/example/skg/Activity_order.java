package com.example.skg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.skg.Databse.DBhelper;
import com.example.skg.adapters.oder_adapter;
import com.example.skg.databinding.ActivityOrderBinding;
import com.example.skg.models.order_model;

import java.util.ArrayList;

public class Activity_order extends AppCompatActivity {

    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBhelper helper=new DBhelper(this);
        ArrayList<order_model> list=helper.getorder();

        oder_adapter adapter=new oder_adapter(list,this);
        binding.orderRecyclerview.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerview.setLayoutManager(linearLayoutManager);

    }
    @Override
    public void onBackPressed(){
        Intent in = new Intent(this,MainActivity.class);
        startActivity(in);
    }
}