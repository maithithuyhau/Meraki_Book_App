package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merakibook.R;
import com.example.model.Book;
import com.example.model.BookItemClickListener;

import java.util.ArrayList;

public class BookAdapterVertical extends RecyclerView.Adapter<BookAdapterVertical.ViewHolder> {
    Context context;
    ArrayList<Book> books;
    BookItemClickListener bookItemClickListener;

    public BookAdapterVertical(Context context, ArrayList<Book> books, BookItemClickListener bookItemClickListener) {
        this.context = context;
        this.books = books;
        this.bookItemClickListener = bookItemClickListener;
    }

    @NonNull
    @Override
    public BookAdapterVertical.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_book_vertical,parent,false);
        return new ViewHolder(customView);
    }
    @Override
    public void onBindViewHolder(@NonNull BookAdapterVertical.ViewHolder holder, int position) {

        holder.imvBookVer.setImageResource(books.get(position).getBookImage());
        holder.txtNameVer.setText(books.get(position).getBookName());
        holder.txtAuthorVer.setText(books.get(position).getBookAuthor());
        holder.txtPageVer.setText(books.get(position).getBookPage());
        holder.btnRead.getContext();
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvBookVer, imvStar, imvFavorite;
        TextView txtNameVer, txtAuthorVer, txtPageVer;
        Button btnRead;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imvBookVer = itemView.findViewById(R.id.imvBookVer);
            imvStar = itemView.findViewById(R.id.imvStarVer);
            imvFavorite = itemView.findViewById(R.id.imvFavorite);
            txtNameVer = itemView.findViewById(R.id.txtNameVer);
            txtAuthorVer = itemView.findViewById(R.id.txtAuthorVer);
            txtPageVer = itemView.findViewById(R.id.txtPageVer);
            btnRead = itemView.findViewById(R.id.btnRead);

            itemView.findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

    }

}
