package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TermsOfUseActivity extends AppCompatActivity {
    LinearLayout lnTaiKhoanKH, lnQuyenLoi, lnQuyenVaNghiaVu, lnQuyenKhachHang;
    TextView txtTaiKhoanKH, txtQuyenLoi, txtQuyenLoiVaNghiaVu, txtQuyenKhachHang;
    View viewTaiKhoan, viewQuyenLoiVaNghiaVu, viewQuyenKhachHang;
    ImageButton imbBackTurnOfUse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_of_use);
         linkViews();
         addEvents();

    }


    private void linkViews() {
        lnTaiKhoanKH = findViewById(R.id.lnTaiKhoanKH);
        lnQuyenLoi = findViewById(R.id.lnQuyenLoi);
        lnQuyenVaNghiaVu = findViewById(R.id.lnQuyenVaNghiaVu);
        lnQuyenKhachHang = findViewById(R.id.lnQuyenKhachHang);
        txtTaiKhoanKH = findViewById(R.id.txtTaiKhoanKH);
        txtQuyenLoi = findViewById(R.id.txtQuyenLoi);
        txtQuyenLoiVaNghiaVu = findViewById(R.id.txtQuyenVaNghiaVu);
        txtQuyenKhachHang = findViewById(R.id.txtQuyenKhachHang);
        viewTaiKhoan = findViewById(R.id.viewTaiKhoan);
        viewQuyenLoiVaNghiaVu = findViewById(R.id.viewQuyenVaNghiaVu);
        viewQuyenKhachHang = findViewById(R.id.viewQuyenKhachHang);
        imbBackTurnOfUse = findViewById(R.id.imbBackTermOfUse);
    }

    private void addEvents() {
        lnTaiKhoanKH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTaiKhoanKH.setVisibility(txtTaiKhoanKH.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                viewTaiKhoan.setVisibility(viewTaiKhoan.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        lnQuyenLoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtQuyenLoi.setVisibility(txtQuyenLoi.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                viewQuyenLoiVaNghiaVu.setVisibility(viewQuyenLoiVaNghiaVu.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
        lnQuyenVaNghiaVu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtQuyenLoiVaNghiaVu.setVisibility(txtQuyenLoiVaNghiaVu.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                viewQuyenKhachHang.setVisibility(viewQuyenKhachHang.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
        lnQuyenKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtQuyenKhachHang.setVisibility(txtQuyenKhachHang.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
        imbBackTurnOfUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}