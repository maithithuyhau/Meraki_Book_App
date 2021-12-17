package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merakibook.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {
Context context;
ArrayList<String> cmt_id, cmt_content;

    public CommentAdapter(Context context, ArrayList<String> cmt_id, ArrayList<String> cmt_content) {
        this.context = context;
        this.cmt_id = cmt_id;
        this.cmt_content = cmt_content;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_comment,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.txtCmt.setText(String.valueOf(cmt_content.get(position)));
    }

    @Override
    public int getItemCount() {
        return cmt_content.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
TextView txtCmt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCmt=itemView.findViewById(R.id.txtCmt);
        }
    }
}
