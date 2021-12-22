package com.example.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merakibook.CartActivity;
import com.example.merakibook.R;
import com.example.model.Order;
import com.example.model.OrderDetailClickListener;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {


    ArrayList<Order> orders;

    OrderDetailClickListener orderDetailClickListener;


    public NotificationAdapter(ArrayList<Order> orders, OrderDetailClickListener listener) {

        this.orders = orders;
        this.orderDetailClickListener = listener;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvOrderImage.setImageResource(orders.get(position).getOrderImage());
        holder.txtOrderName.setText(orders.get(position).getOrderName());
       holder.txtOrderTime.setText(orders.get(position).getOrderDate());
       holder.txtOrderStatus.setText(orders.get(position).getOrderStatus());


    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvOrderImage;
        TextView txtOrderName, txtOrderTime, txtOrderStatus;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvOrderImage = itemView.findViewById(R.id.imvOrderImage);
            txtOrderName = itemView.findViewById(R.id.txtOrderName);
            txtOrderTime = itemView.findViewById(R.id.txtOrderTime);
            txtOrderStatus = itemView.findViewById(R.id.txtOrderStatus);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    orderDetailClickListener.onOrderClick(orders.get(getAdapterPosition()),imvOrderImage);

                }
            });


        }

    }
}
