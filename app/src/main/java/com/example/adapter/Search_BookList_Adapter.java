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
import com.example.merakibook.SearchActivity;
import com.example.model.Book;
import com.example.model.BookItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class Search_BookList_Adapter extends RecyclerView.Adapter<Search_BookList_Adapter.ViewHolder> {

    Context context;
    List<Book> data;
    BookItemClickListener bookItemClickListener;

    public Search_BookList_Adapter(Context context, List<Book> data, BookItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.bookItemClickListener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bookitem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(data.get(position).getBookName());
        holder.imvHinh.setImageResource(data.get(position).getBookImage());
        holder.txtTacGia.setText(data.get(position).getBookAuthor());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtTacGia;
        ImageView imvHinh;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            txtName=itemView.findViewById(R.id.txtName);
            imvHinh=itemView.findViewById(R.id.imvHinh);
            txtTacGia=itemView.findViewById(R.id.txtTacGia);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bookItemClickListener.onBookClick(data.get(getAdapterPosition()),imvHinh);
                }
            });
        }
    }


}
