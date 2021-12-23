package com.example.merakibook;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class VipActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDangKyNgay;
    ImageButton btnBack;
    TextView txtKhungGia3, txtKhungGia2, txtKhungGia1, txtQuyenLoi, txtDieuKhoan1;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        linkView();
        vipOnClick();
        addEvent();

    }

    private void linkView() {
        btnDangKyNgay = findViewById(R.id.btnDangKyNgay);
        btnBack = findViewById(R.id.btnBack);

        txtKhungGia1 = findViewById(R.id.txtKhungGia1);
        txtKhungGia2 = findViewById(R.id.txtKhungGia2);
        txtKhungGia3 = findViewById(R.id.txtKhungGia3);
        txtQuyenLoi = findViewById(R.id.txtQuyenLoi);
        txtDieuKhoan1 = findViewById(R.id.txtDieuKhoan1);

    }

    private void vipOnClick() {
        txtKhungGia1.setOnClickListener(VipActivity.this);
        txtKhungGia2.setOnClickListener(VipActivity.this);
        txtKhungGia3.setOnClickListener(VipActivity.this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtKhungGia1:
                txtKhungGia1.setBackgroundResource(R.drawable.vip_border);
                txtKhungGia2.setBackgroundResource(R.drawable.box);
                txtKhungGia3.setBackgroundResource(R.drawable.box);
                break;
            case R.id.txtKhungGia2:
                txtKhungGia2.setBackgroundResource(R.drawable.vip_border);
                txtKhungGia1.setBackgroundResource(R.drawable.box);
                txtKhungGia3.setBackgroundResource(R.drawable.box);
                break;
            case R.id.txtKhungGia3:
                txtKhungGia3.setBackgroundResource(R.drawable.vip_border);
                txtKhungGia2.setBackgroundResource(R.drawable.box);
                txtKhungGia1.setBackgroundResource(R.drawable.box);
                break;
        }

    }

    private void addEvent() {
        btnDangKyNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(VipActivity.this);
                dialog.setContentView(R.layout.popup_vip);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button btnBatDau = dialog.findViewById(R.id.btnBatDau);
                btnBatDau.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        toHomePage();
                        dialog.dismiss();

                    }
                });
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txtQuyenLoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VipActivity.this, PolicyActivity.class);
                startActivity(intent);
            }
        });
        txtDieuKhoan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VipActivity.this, TermsOfUseActivity.class);
                startActivity(intent);
            }
        });

    }

    private void toHomePage() {
//        manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.layoutVip, new HomePageFragment());
//        transaction.addToBackStack(null);
//        transaction.commit();
        Intent intent = new Intent(VipActivity.this, MainActivity.class);
        startActivity(intent);
    }


}