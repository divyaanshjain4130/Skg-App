package com.example.skg.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.skg.R;
import com.example.skg.cart_page;
import com.example.skg.models.main_model;
import java.util.ArrayList;

public class main_adapter extends RecyclerView.Adapter<main_adapter.viewHolder> {
    ArrayList<main_model> list;
    Context context;

    public main_adapter(ArrayList<main_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_recyleview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        main_model model = list.get(position);
        holder.oderImage.setImageResource(model.getOrderImage());
        holder.orderName.setText(model.getOrderName());
        holder.orderDesc.setText(model.getOrderDesc());
        holder.price.setText(model.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(context, cart_page.class);
                in.putExtra("image",model.getOrderImage());
                in.putExtra("price",model.getPrice());
                in.putExtra("desc",model.getOrderDesc());
                in.putExtra("name",model.getOrderName());
                context.startActivity(in);
            }
        });

    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView oderImage;
        TextView orderName,orderDesc,price;
        Button insertBttn;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            oderImage=itemView.findViewById(R.id.imageView);
            orderName=itemView.findViewById(R.id.orderName);
            orderDesc=itemView.findViewById(R.id.orderDesc);
            price=itemView.findViewById(R.id.price);
            insertBttn=itemView.findViewById(R.id.order_bttn);

        }
    }
}
