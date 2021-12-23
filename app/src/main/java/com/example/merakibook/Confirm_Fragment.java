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
import android.widget.ImageView;
import android.widget.TextView;


import com.example.adapter.OrderConfirmAdapter;
import com.example.model.Order;
import com.example.model.OrderDetailClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;

public class  Confirm_Fragment extends Fragment implements OrderDetailClickListener {
    RecyclerView rcvConfirm;
    ImageView imvOrderImage;
    TextView txtOrderName, txtOrderPrice;
    Button btnDetailConfirm, btnOrderCancel;

    ArrayList<Order> orders;
    OrderConfirmAdapter orderConfirmAdapter;
    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_confirm_, container, false);
        linkViews();
        initData();

        return view;
    }


    private void linkViews() {
        rcvConfirm = view.findViewById(R.id.rcvConfirm);
        imvOrderImage = view.findViewById(R.id.imvOrderImage);
        txtOrderName = view.findViewById(R.id.txtOrderName);
        txtOrderPrice = view.findViewById(R.id.txtOrderPrice);
        btnDetailConfirm = view.findViewById(R.id.btnDetailConfirm);
        btnOrderCancel = view.findViewById(R.id.btnOrderCancel);

    }


    private void initData() {
        orders = new ArrayList<>();
        orders.add(new Order("Lão Hạc", "1569A", "2", "125.000", "8:00 20/12/2021","Chờ xác nhận","",R.drawable.laohac));
        orders.add(new Order("Harry Potter", "3350B", "1", "65.000", "14:00 20/12/2021","Chờ xác nhận","",R.drawable.harrypotter));

        orderConfirmAdapter = new OrderConfirmAdapter(orders, this);
        rcvConfirm.setAdapter(orderConfirmAdapter);
        rcvConfirm.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
    }



    @Override
    public void onOrderClick(Order order, ImageView orderImage) {
        Intent intent = new Intent(getActivity(), OrderConfirmDetailActivity.class);
        intent.putExtra(Constant.ORDER_NAME, order.getOrderName());
        intent.putExtra(Constant.ORDER_NUMBER, order.getOrderNumber());
        intent.putExtra(Constant.ORDER_PRICE, order.getOrderPrice());
        intent.putExtra(Constant.ORDER_DATE, order.getOrderDate());
        intent.putExtra(Constant.ORDER_QUANTITY, order.getOrderQuantity());
        intent.putExtra(Constant.ORDER_STATUS, order.getOrderStatus());
        intent.putExtra(Constant.ORDER_TIME, order.getOrderTime());
        intent.putExtra(Constant.ORDER_IMAGE, order.getOrderImage());
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(getActivity(), orderImage,"sharedName");
        startActivity(intent,options.toBundle());
    }
}