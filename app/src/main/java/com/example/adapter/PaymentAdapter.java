package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merakibook.R;
import com.example.model.Book;
import com.example.model.Cart;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHoder> {
    Context context;
    ArrayList<Cart> carts;

    public PaymentAdapter(Context context, ArrayList<Cart> carts) {
        this.context = context;
        this.carts = carts;
    }


    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.book_item_order, parent,false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        holder.imvSach.setImageResource(carts.get(position).getItemImage());
        holder.txtTenSach.setText(carts.get(position).getItemName());
        holder.txtTacGia.setText(carts.get(position).getItemAuthor());
        holder.txtGiaSach.setText(String.valueOf(carts.get(position).getItemPrice()) );
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public static class ViewHoder extends RecyclerView.ViewHolder{
        ImageView imvSach;
        TextView txtTenSach, txtTacGia, txtGiaSach;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            imvSach = itemView.findViewById(R.id.imvSach);
            txtGiaSach = itemView.findViewById(R.id.txtGiaSach);
            txtTacGia = itemView.findViewById(R.id.txtTacGia);
            txtTenSach = itemView.findViewById(R.id.txtTenSach);

        }
    }
}
