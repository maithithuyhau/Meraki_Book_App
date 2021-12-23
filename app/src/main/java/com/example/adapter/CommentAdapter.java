package com.example.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merakibook.DetailBookActivity;
import com.example.merakibook.R;
import com.example.merakibook.Reviews;
import com.example.utils.Constant;

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
        ImageView imvdieuhuong;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCmt=itemView.findViewById(R.id.txtCmt);
            imvdieuhuong=itemView.findViewById(R.id.imvdieuhuong);

            imvdieuhuong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu= new PopupMenu(context,view);
                    popupMenu.getMenuInflater().inflate(R.menu.contextmenu,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()){
                                case R.id.mnEdit:
                                    Edit(getAdapterPosition());
                                    return true;
                                case R.id.mnDel:
                                    removeAt(getAdapterPosition());
                                    return true;
                                default:
                                    return false;
                            }

                        }
                    });
                    popupMenu.show();
                }
            });
        }

    }
    public void Edit(int position) {
        Intent intent=new Intent(context, Reviews.class);
        intent.putExtra(Constant.SELECTED_ITEM,cmt_content);
        context.startActivity(intent);
    }

    public void removeAt(int position) {
//        cmt_content.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, cmt_content.size());
        AlertDialog.Builder builder= new AlertDialog.Builder(context);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure you want to delete this comment");
        builder.setIcon(android.R.drawable.ic_input_delete);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cmt_content.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cmt_content.size());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

}
