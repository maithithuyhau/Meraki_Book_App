package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merakibook.R;
import com.example.model.Book;
import com.example.model.BookItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class BookAdapterVertical extends RecyclerView.Adapter<BookAdapterVertical.ViewHolder> implements Filterable {
    Context context;
    List<Book> data;
    List<Book> dataFilterable;
    BookItemClickListener bookItemClickListener;

    public BookAdapterVertical(Context context, List<Book> data, BookItemClickListener bookItemClickListener) {
        this.context = context;
        this.data = data;
        this.bookItemClickListener = bookItemClickListener;
        this.dataFilterable=data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_book_vertical,parent,false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull BookAdapterVertical.ViewHolder holder, int position) {

        holder.imvBookVer.setImageResource(dataFilterable.get(position).getBookImage());
        holder.txtNameVer.setText(dataFilterable.get(position).getBookName());
        holder.txtAuthorVer.setText(dataFilterable.get(position).getBookAuthor());
        holder.txtPageVer.setText(dataFilterable.get(position).getBookPage());
        holder.btnRead.getContext();
    }

    @Override
    public int getItemCount() {
        return dataFilterable.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String Key=charSequence.toString();
                if(Key.isEmpty()){
                    dataFilterable=data;
                }else {
                    List<Book> lstFiltered=new ArrayList<>();
                    for (Book row:data){
                        if (row.getBookName().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);
                        }

                    }
                    dataFilterable=lstFiltered;
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=dataFilterable;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                dataFilterable=(List<Book>) filterResults.values;
                notifyDataSetChanged();
            }
        };
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
                    bookItemClickListener.onBookClick(dataFilterable.get(getAdapterPosition()),imvBookVer);
                }
            });
        }

    }

}
