package com.example.merakibook;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VipActivity extends AppCompatActivity {
    Button btnDangKyNgay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        linkView();
        //addEvent();
    }

    private void linkView() {
        btnDangKyNgay = findViewById(R.id.btnDangKyNgay);
    }

    private void addEvent() {
        btnDangKyNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(VipActivity.this);
                dialog.setContentView(R.layout.popup_vip);

                Button btnBatDau = dialog.findViewById(R.id.btnBatDau);
                btnBatDau.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(VipActivity.this, HomePageActivity.class);
                        startActivity(intent);

                        finish();

                    }
                });
            }
        });
    }

    public void openPopUp(View view) {
        btnDangKyNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(VipActivity.this);
                dialog.setContentView(R.layout.popup_vip);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button btnBatDau = dialog.findViewById(R.id.btnBatDau);

                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }
}