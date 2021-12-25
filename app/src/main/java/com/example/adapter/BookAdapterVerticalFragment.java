package com.example.adapter;

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
import java.util.Locale;

public class BookAdapterVerticalFragment extends RecyclerView.Adapter<BookAdapterVerticalFragment.MyViewHolder> implements Filterable {

    List<Book> data;
    BookItemClickListener bookItemClickListener;
    List<Book> dataSearch;

    public BookAdapterVerticalFragment(List<Book> data , BookItemClickListener listener) {
        this.data = data;
        this.bookItemClickListener = listener;
        this.dataSearch = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_vertical,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtNameVer.setText(data.get(position).getBookName());
        holder.imvBookVer.setImageResource(data.get(position).getBookImage());
        holder.txtAuthorVer.setText(data.get(position).getBookAuthor());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imvBookVer, imvStar, imvFavorite;
        TextView txtNameVer, txtAuthorVer, txtPageVer;
        Button btnRead;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            imvBookVer = itemView.findViewById(R.id.imvBookVer);
            imvStar = itemView.findViewById(R.id.imvStarVer);
            imvFavorite = itemView.findViewById(R.id.imvFavorite);
            txtNameVer = itemView.findViewById(R.id.txtNameVer);
            txtAuthorVer = itemView.findViewById(R.id.txtAuthorVer);
            txtPageVer = itemView.findViewById(R.id.txtPageVer);
            btnRead = itemView.findViewById(R.id.btnRead);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bookItemClickListener.onBookClick(data.get(getAdapterPosition()),imvBookVer);
                }
            });

        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if(strSearch.isEmpty()){
                    data = dataSearch;
                }else {
                    List<Book> list = new ArrayList<>();
                    for (Book book : dataSearch){
                        if (book.getBookName().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(book);
                        }
                    }
                    data = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = data;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                data = (List<Book>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
