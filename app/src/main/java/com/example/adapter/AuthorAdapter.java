package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merakibook.R;
import com.example.model.Author;
import com.example.model.AuthorItemClickListener;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.ViewHolder> implements Filterable {
    Context context;
    ArrayList<Author> authors;
    ArrayList<Author> authorsFilterable;
    AuthorItemClickListener authorItemClickListener;

    public AuthorAdapter(Context context, ArrayList<Author> authors, AuthorItemClickListener authorItemClickListener) {
        this.context = context;
        this.authors = authors;
        this.authorItemClickListener = authorItemClickListener;
        this.authorsFilterable=authors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_author,parent,false);

        return new ViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvTacGiaImage.setImageResource(authorsFilterable.get(position).getAuthorImage());
        holder.txtTacGiaView.setText(authorsFilterable.get(position).getAuthorName());
    }

    @Override
    public int getItemCount() {
        return authorsFilterable.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String Key=charSequence.toString();
                if(Key.isEmpty()){
                    authorsFilterable=authors;
                }else {
                   ArrayList<Author> lstFiltered=new ArrayList<>();
                    for (Author row:authors){
                        if (row.getAuthorName().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);
                        }

                    }
                    authorsFilterable=lstFiltered;
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=authorsFilterable;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                authorsFilterable=(ArrayList<Author>) filterResults.values;
                notifyDataSetChanged();
            }
        };
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
                    authorItemClickListener.onAuthorClick(authorsFilterable.get(getAdapterPosition()),imvTacGiaImage);
                }
            });
        }
    }
}
