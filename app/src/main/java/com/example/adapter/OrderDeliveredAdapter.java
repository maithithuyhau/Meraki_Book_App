package com.example.adapter;

import android.content.Context;
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
import com.example.merakibook.Delivered_Fragment;
import com.example.merakibook.OrderDetailActivity;
import com.example.merakibook.R;
import com.example.model.Order;
import com.example.model.OrderDetailClickListener;


import java.util.ArrayList;
import java.util.List;

public class OrderDeliveredAdapter extends RecyclerView.Adapter<OrderDeliveredAdapter.ViewHolder> {


    ArrayList<Order> orders;

    OrderDetailClickListener orderDetailClickListener;


    public OrderDeliveredAdapter(ArrayList<Order> orders, OrderDetailClickListener listener) {

        this.orders = orders;
        this.orderDetailClickListener = listener;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delivered,parent,false);

        return new ViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvOrderImage.setImageResource(orders.get(position).getOrderImage());
        holder.txtOrderName.setText(orders.get(position).getOrderName());
        holder.txtOrderPrice.setText(orders.get(position).getOrderPrice());
        holder.txtOrderQuantity.setText(orders.get(position).getOrderQuantity());


    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvOrderImage;
        TextView txtOrderName, txtOrderPrice, txtOrderQuantity;
        Button btnDetail, btnBuyAgain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvOrderImage = itemView.findViewById(R.id.imvOrderImage);
            txtOrderName = itemView.findViewById(R.id.txtOrderName);
            txtOrderPrice = itemView.findViewById(R.id.txtOrderPrice);
            txtOrderQuantity = itemView.findViewById(R.id.txtOrderQuantity);
            btnDetail = itemView.findViewById(R.id.btnDetail);
            btnBuyAgain = itemView.findViewById(R.id.btnBuyAgain);

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    orderDetailClickListener.onOrderClick(orders.get(getAdapterPosition()), imvOrderImage);

                }
            });
            btnBuyAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), CartActivity.class);
                    view.getContext().startActivity(intent);
                }
            });

        }

    }
}
