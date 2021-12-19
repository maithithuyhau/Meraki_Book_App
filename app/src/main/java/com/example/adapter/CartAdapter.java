package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merakibook.R;
import com.example.model.Book;
import com.example.model.Cart;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    Context context;
    ArrayList<Cart> carts;
    private OnItemClickListener mListener;
    private int number = 0;

    public CartAdapter(Context context, ArrayList<Cart> carts) {
        this.context = context;
        this.carts = carts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View myView = inflater.inflate(R.layout.activity_cart_item_list,parent, false);
        ViewHolder holder = new ViewHolder(myView, mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvBook.setImageResource(carts.get(position).getItemImage());
        holder.txtAuthor.setText(carts.get(position).getItemAuthor());
        holder.txtTitle.setText(carts.get(position).getItemName());
        holder.txtPrice.setText(String.valueOf(carts.get(position).getItemPrice()));
        holder.edtSoLuong.setText("1");
        holder.btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number ++;
                holder.edtSoLuong.setText(""+number);
            }
        });

        holder.btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number <= 0){
                    number = 0;
                }else{
                    number --;
                }
                holder.edtSoLuong.setText(""+number);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvBook;
        TextView txtAuthor, txtTitle, txtPrice;
        EditText edtSoLuong;
        ImageButton btnCong, btnTrash, btnTru;


        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imvBook = itemView.findViewById(R.id.imvSach);
            txtAuthor = itemView.findViewById(R.id.txtTacGia);
            txtTitle = itemView.findViewById(R.id.txtTenSach);
            txtPrice = itemView.findViewById(R.id.txtGiaSach);
            edtSoLuong = itemView.findViewById(R.id.edtSoLuong);
            btnCong =  itemView.findViewById(R.id.btnCong);
            btnTru =  itemView.findViewById(R.id.btnTru);
            btnTrash =  itemView.findViewById(R.id.btnTrash);

            btnTrash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }
}
