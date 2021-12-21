package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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
    }

    private void linkView() {
        rcvItemThanhToan = findViewById(R.id.rcvItemThanhToan);
        btnTtDatHang = findViewById(R.id.btnTtDatHang);
        txtTtDiaChi = findViewById(R.id.txtTtDiaChi);
        txtTtDonViVanChuyen = findViewById(R.id.txtTtDonViVanChuyen);
        txtTtPhuongThuc = findViewById(R.id.txtTtPhuongThuc);
    }

    private void initData() {
        carts = new ArrayList<>();
        carts.add(new Cart("Bạn đắt giá bao nhiêu","Vãn Tình", 119000, R.drawable.bandatgiabaonhieu,1));
        adapter = new PaymentAdapter(getApplicationContext(), carts);
        rcvItemThanhToan.setAdapter(adapter);
        rcvItemThanhToan.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }
}