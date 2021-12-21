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
import com.example.model.Author;
import com.example.model.AuthorItemClickListener;
import com.example.model.Book;
import com.example.model.BookItemClickListener;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AuthorSearchAdapter extends RecyclerView.Adapter<AuthorSearchAdapter.ViewHolder> {
    Context context;
    ArrayList<Author> authors;
    AuthorItemClickListener authorItemClickListener;

    public AuthorSearchAdapter(Context context, ArrayList<Author> authors, AuthorItemClickListener authorItemClickListener) {
        this.context = context;
        this.authors = authors;
        this.authorItemClickListener = authorItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_author_horizontal,parent,false);

        return new ViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvTacGiaImage.setImageResource(authors.get(position).getAuthorImage());
        holder.txtTacGiaView.setText(authors.get(position).getAuthorName());
    }

    @Override
    public int getItemCount() {
        return authors.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imvTacGiaImage;
        TextView txtTacGiaView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imvTacGiaImage = itemView.findViewById(R.id.imvTacGiaImage);
            txtTacGiaView = itemView.findViewById(R.id.txtTacGiaView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    authorItemClickListener.onAuthorClick(authors.get(getAdapterPosition()),imvTacGiaImage);
                }
            });
        }
    }
}
