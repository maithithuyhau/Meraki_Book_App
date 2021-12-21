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
import com.example.model.BookItemClickListener;
import com.example.model.Order;
import com.example.model.OrderDetailClickListener;

import java.util.ArrayList;

public class OrderConfirmAdapter extends RecyclerView.Adapter<OrderConfirmAdapter.ViewHolder> {


    ArrayList<Order> orders;
   OrderDetailClickListener orderConfirm;


    public OrderConfirmAdapter(ArrayList<Order> orders, OrderDetailClickListener listener) {

        this.orders = orders;
        this.orderConfirm = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_confirm,parent,false);

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
        Button btnDetail, btnOrderCancel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvOrderImage = itemView.findViewById(R.id.imvOrderImage);
            txtOrderName = itemView.findViewById(R.id.txtOrderName);
            txtOrderPrice = itemView.findViewById(R.id.txtOrderPrice);
            txtOrderQuantity = itemView.findViewById(R.id.txtOrderQuantity);
            btnDetail = itemView.findViewById(R.id.btnDetail);
            btnOrderCancel = itemView.findViewById(R.id.btnOrderCancel);


            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    orderConfirm.onOrderClick(orders.get(getAdapterPosition()), imvOrderImage);
                }
            });
            btnOrderCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(view.equals(btnOrderCancel)){
                        removeAt(getAdapterPosition());
                    } else if(orderConfirm != null){
                        orderConfirm.onOrderClick(orders.get(getAdapterPosition()), imvOrderImage);
                    }
                }
            });

        }

    }
    public void removeAt(int position) {
        orders.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, orders.size());
    }
}
