package com.example.merakibook;

import static com.example.merakibook.AddressActivity.REFERENCE_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.adapter.BookAdapterVertical;
import com.example.adapter.CartAdapter;
import com.example.adapter.PaymentAdapter;
import com.example.model.Cart;

import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity {
    RecyclerView rcvItemThanhToan;
    ArrayList<Cart> carts;
    PaymentAdapter adapter;

    Button btnTtDatHang;
    TextView txtTtDiaChi, txtTtDonViVanChuyen, txtTtPhuongThuc, txtTtDieuKhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        linkView();
        initData();
        addEvent();
    }

    private void linkView() {
        rcvItemThanhToan = findViewById(R.id.rcvItemThanhToan);
        btnTtDatHang = findViewById(R.id.btnTtDatHang);
        txtTtDiaChi = findViewById(R.id.txtTtDiaChi);
        txtTtDonViVanChuyen = findViewById(R.id.txtTtDonViVanChuyen);
        txtTtPhuongThuc = findViewById(R.id.txtTtPhuongThuc);
        txtTtDieuKhoan = findViewById(R.id.txtTtDieuKhoan);
    }

    private void initData() {
        carts = new ArrayList<>();
        carts.add(new Cart("Bạn đắt giá bao nhiêu","Vãn Tình", 119000, R.drawable.bandatgiabaonhieu,1));
        adapter = new PaymentAdapter(getApplicationContext(), carts);
        rcvItemThanhToan.setAdapter(adapter);
        rcvItemThanhToan.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    private void addEvent() {
        SharedPreferences preferences = getSharedPreferences(REFERENCE_NAME, MODE_PRIVATE);
        String diachi = preferences.getString("diachi", null);
        String giaohang = preferences.getString("giaohang", null);
        String thanhtoan = preferences.getString("thanhtoan",null);

        txtTtDiaChi.append(diachi);
        txtTtPhuongThuc.append(thanhtoan);
        txtTtDonViVanChuyen.append(giaohang);

        btnTtDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(PaymentActivity.this);
            }
        });
    }
    public void openDialog(Context context){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.popup_order_successful);

        Button btnDetailOrder = dialog.findViewById(R.id.btnDetailOrder);
        btnDetailOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,PurchaseOrderActivity.class);
                context.startActivity(intent);
            }
        });

        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}