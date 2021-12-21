package com.example.merakibook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.NotificationAdapter;
import com.example.adapter.OrderDeliveredAdapter;
import com.example.model.Order;
import com.example.model.OrderDetailClickListener;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends Fragment implements OrderDetailClickListener {
    View view;
    RecyclerView rcvNotification;
    TextView txtOrderName, txtOrderStatus, txtOrderTime;
    ImageView imvOrderImage;
    ImageButton imbBackNotification;
    ArrayList<Order> orders;
    OrderDetailClickListener orderDetailClickListener;
    NotificationAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_notification,container,false);

        linkViews();
        initData();
        return view;

    }


    private void linkViews() {
        rcvNotification = view.findViewById(R.id.rcvNotif);
        txtOrderName = view.findViewById(R.id.txtOrderName);
        txtOrderStatus = view.findViewById(R.id.txtOrderStatus);
        txtOrderTime = view.findViewById(R.id.txtOrderTime);
        imvOrderImage = view.findViewById(R.id.imvOrderImage);
    }

    private void initData() {
        orders = new ArrayList<>();
        orders.add(new Order("Đáp án của thời gian", "1099A", "2", "125.000", "12:00 10/11/2021","Giao hàng thành công","15:00 13/11/2021",R.drawable.dapancuathoigian));
        orders.add(new Order("Chí Phèo", "1250B", "1", "45.000", "9:00 15/12/2021","Giao hàng thành công","16:00 18/12/2021",R.drawable.chipheo));
        adapter = new NotificationAdapter(orders, this);
        rcvNotification.setAdapter(adapter);
        rcvNotification.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
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