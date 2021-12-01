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



import java.util.ArrayList;

public class AuthorSearchAdapter extends RecyclerView.Adapter<AuthorSearchAdapter.ViewHolder> {
    Context context;
    ArrayList<Author> authors;

    public AuthorSearchAdapter(Context context, ArrayList<Author> authors) {
        this.context = context;
        this.authors = authors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_author_horizontal, parent, false);

        return new ViewHolder((customView));
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
        ImageView imvTacGiaImage;
        TextView txtTacGiaView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imvTacGiaImage = itemView.findViewById(R.id.imvTacGiaImage);
            txtTacGiaView = itemView.findViewById(R.id.txtTacGiaView);
        }
    }
}
