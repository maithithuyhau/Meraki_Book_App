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

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    Context context;
    ArrayList<Book> books;

    public CartAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View myView = inflater.inflate(R.layout.activity_cart_item_list,parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvBook.setImageResource(books.get(position).getBookImage());
        holder.txtAuthor.setText(books.get(position).getBookAuthor());
        holder.txtTitle.setText(books.get(position).getBookName());
        holder.txtPrice.setText(books.get(position).getBookPrice());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvBook;
        TextView txtAuthor, txtTitle, txtPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvBook = itemView.findViewById(R.id.imvSach);
            txtAuthor = itemView.findViewById(R.id.txtTacGia);
            txtTitle = itemView.findViewById(R.id.txtTenSach);
            txtPrice = itemView.findViewById(R.id.txtGiaSach);
        }
    }
}
