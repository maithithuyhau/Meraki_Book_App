package com.example.merakibook;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.adapter.OrderDeliveredAdapter;

import com.example.model.Order;
import com.example.model.OrderDetailClickListener;

import java.util.ArrayList;

public class  Delivered_Fragment extends Fragment implements OrderDetailClickListener {
RecyclerView rcvDeliveried;
ImageView imvOrderImage;
TextView txtOrderName, txtOrderPrice;
Button btnDetail, btnBuyAgain;

ArrayList<Order> orders;
OrderDeliveredAdapter adapter;
View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_delivered_, container, false);
        linkViews();
        initData();

        return view;
    }


    private void linkViews() {
        rcvDeliveried = view.findViewById(R.id.rcvDeliveried);
        imvOrderImage = view.findViewById(R.id.imvOrderImage);
        txtOrderName = view.findViewById(R.id.txtOrderName);
        txtOrderPrice = view.findViewById(R.id.txtOrderPrice);
        btnDetail = view.findViewById(R.id.btnDetail);
        btnBuyAgain = view.findViewById(R.id.btnBuyAgain);

    }


    private void initData() {
        orders = new ArrayList<>();
        orders.add(new Order("Đáp án của thời gian", "1099A", "2", "125.000", "12:00 10/11/2021","Giao hàng thành công","15:00 13/11/2021",R.drawable.dapancuathoigian));
        orders.add(new Order("Chí Phèo", "1250B", "1", "45.000", "9:00 15/12/2021","Giao hàng thành công","16:00 18/12/2021",R.drawable.chipheo));
        adapter = new OrderDeliveredAdapter(orders, this);
        rcvDeliveried.setAdapter(adapter);
        rcvDeliveried.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
    }



    @Override
    public void onOrderClick(Order order, ImageView orderImage) {
        Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
        intent.putExtra("OrderName", order.getOrderName());
        intent.putExtra("OrderNumber", order.getOrderNumber());
        intent.putExtra("OrderPrice", order.getOrderPrice());
        intent.putExtra("OrderDate", order.getOrderDate());
        intent.putExtra("OrderQuantity", order.getOrderQuantity());
        intent.putExtra("OrderStatus", order.getOrderStatus());
        intent.putExtra("OrderTime", order.getOrderTime());
        intent.putExtra("OrderImage", order.getOrderImage());
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(getActivity(), orderImage,"sharedName");
        startActivity(intent,options.toBundle());
    }
 }