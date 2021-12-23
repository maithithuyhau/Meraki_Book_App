package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Order;
import com.example.model.OrderDetailClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity implements OrderDetailClickListener {
//private RecyclerView rcvOrderItemList;
private TextView  txtOrderName,txtOrderNumber, txtOrderPrice, txtOrderDate, txtOrderQuantity, txtOrderStatus, txtOrderTime;
private ImageView imvOrderImage;
private Button btnBuyAgain;
private ImageButton imbBackOrder;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        linkViews();
        loadData();
        addEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }


    private void linkViews() {

        txtOrderName = findViewById(R.id.txtOrderName);
        txtOrderNumber = findViewById(R.id.txtOrderNumber);
        txtOrderPrice = findViewById(R.id.txtOrderPrice);

        txtOrderStatus = findViewById(R.id.txtOrderStatus);
        txtOrderQuantity = findViewById(R.id.txtOrderQuantity);
        txtOrderTime = findViewById(R.id.txtOrderTime);
        imvOrderImage = findViewById(R.id.imvOrderImage);
        btnBuyAgain = findViewById(R.id.btnBuyAgain);
        imbBackOrder = findViewById(R.id.imbBackOrder);
    }

    private void loadData() {
        Intent intent = getIntent();
        String orderName = intent.getExtras().getString(Constant.ORDER_NAME);
        String orderNumber = intent.getExtras().getString(Constant.ORDER_NUMBER);
        String orderPrice = intent.getExtras().getString(Constant.ORDER_PRICE);
        String orderQuantity = intent.getExtras().getString(Constant.ORDER_QUANTITY);
        String orderStatus = intent.getExtras().getString(Constant.ORDER_STATUS);
        String orderTime = intent.getExtras().getString(Constant.ORDER_TIME);
        int orderImage = intent.getExtras().getInt(Constant.ORDER_IMAGE);

        imvOrderImage.setImageResource(orderImage);
        txtOrderName.setText(orderName);
        txtOrderNumber.setText(orderNumber);
        txtOrderStatus.setText(orderStatus);
        txtOrderPrice.setText(orderPrice);
        txtOrderQuantity.setText(orderQuantity);
        txtOrderStatus.setText(orderStatus);
        txtOrderTime.setText(orderTime);
    }

    private void addEvent() {
        btnBuyAgain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderDetailActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        imbBackOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onOrderClick(Order order, ImageView imageView) {

    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}