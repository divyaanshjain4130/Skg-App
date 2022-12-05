package com.example.skg.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skg.Databse.DBhelper;
import com.example.skg.R;
import com.example.skg.cart_page;
import com.example.skg.models.order_model;
import com.example.skg.order_detail;

import java.sql.Connection;
import java.util.ArrayList;


public class oder_adapter extends RecyclerView.Adapter<oder_adapter.viewHolder> {

    ArrayList<order_model> list;
    Context context;
    Button bt2;
    oder_adapter adapter;

    public oder_adapter(ArrayList<order_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final order_model model = list.get(position);
        holder.oderImage.setImageResource(model.getOrderImage());
        holder.orderName.setText(model.getOrderName());
        holder.orderNumber.setText(model.getOrderNumb());
        holder.price.setText(model.getPrice());
    //    holder.location.setText(model.getLoc());
//        holder.
//        holder.quantity.setText(String.valueOf(model.getQuant()));
//         holder.location.setText(model.getLoc());


        //Sending clicked item details to the next page

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, order_detail.class);
                in.putExtra("image", model.getOrderImage());
                in.putExtra("name",model.getName());
                in.putExtra("loc",model.getLoc());
                in.putExtra("quant",model.getQuant());
                in.putExtra("price", model.getPrice());
                in.putExtra("phone",model.getPhone());
                in.putExtra("desc", model.getOrderDesc());
                in.putExtra("foodname", model.getOrderName());
                in.putExtra("id", model.getOrderNumb());
                in.putExtra("position",model.getOrderNumb());
                context.startActivity(in);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DBhelper dBhelper = new DBhelper(context);
                dBhelper.delete(model.getOrderNumb());
                    Toast.makeText(context, "Item Deleted", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
       /* holder.removeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oder_adapter adapter=new oder_adapter(list,context);
                DBhelper dBhelper = new DBhelper(context);
                dBhelper.delete(model.getOrderNumb());
                Toast.makeText(context, "Item Deleted", Toast.LENGTH_SHORT).show();
                adapter.notifyItemRemoved(Integer.parseInt(model.getOrderNumb()));
             }
        });*/
        holder.img_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oder_adapter adapter=new oder_adapter(list,context);
                adapter.notifyItemRemoved(Integer.parseInt(model.getOrderNumb()));
                DBhelper dBhelper = new DBhelper(context);
                dBhelper.delete(model.getOrderNumb());
                Toast.makeText(context, "Item Deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void remove(int position1){
        DBhelper dBhelper = new DBhelper(context);
        dBhelper.delete(String.valueOf(position1));
    }
    @Override
    public int getItemCount() {
        System.out.println(list.size()+"LIst size");
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView oderImage;
        TextView orderName,orderNumber,price,quantity,location;
        Button insertBttn,removeBttn;
        ImageButton img_reset;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            img_reset=itemView.findViewById(R.id.img_reset);
            oderImage=itemView.findViewById(R.id.orderImage);
            orderName=itemView.findViewById(R.id.orderItem);
            orderNumber=itemView.findViewById(R.id.orderNumber);
            price=itemView.findViewById(R.id.orderPrice);
            quantity=itemView.findViewById(R.id.quantity);
            location=itemView.findViewById(R.id.location);
            insertBttn=itemView.findViewById(R.id.order_bttn);
           // removeBttn=itemView.findViewById(R.id.resetBttn);
        }
    }
}
