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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VipActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDangKyNgay;
    TextView txtKhungGia3, txtKhungGia2, txtKhungGia1;
    Drawable bgKhung1, bgKhung2, bgKhung3;

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
        txtKhungGia1 = findViewById(R.id.txtKhungGia1);
        txtKhungGia2 = findViewById(R.id.txtKhungGia2);
        txtKhungGia3 = findViewById(R.id.txtKhungGia3);

    }

    private void vipOnClick() {
        txtKhungGia1.setOnClickListener(VipActivity.this);
        txtKhungGia2.setOnClickListener(VipActivity.this);
        txtKhungGia3.setOnClickListener(VipActivity.this);
    }
    @Override
    public void onClick(View view) {
//        bgKhung1 = txtKhungGia1.getBackground();
//        bgKhung2 = txtKhungGia2.getBackground();
//        bgKhung3 = txtKhungGia3.getBackground();
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
//                Button btnBatDau = dialog.findViewById(R.id.btnBatDau);
//                btnBatDau.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(VipActivity.this, HomePageActivity.class);
//                        startActivity(intent);
//
//                        finish();
//
//                    }
//                });
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
//        txtKhungGia1.setOnClickListener(new View.OnClickListener() {
//            Drawable background = txtKhungGia1.getBackground();
//            @Override
//            public void onClick(View view) {
//                txtKhungGia1.setBackgroundResource(R.drawable.vip_border);
//            }
//        });
    }


}