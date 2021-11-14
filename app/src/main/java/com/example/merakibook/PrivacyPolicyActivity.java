package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PrivacyPolicyActivity extends AppCompatActivity {
    LinearLayout lnThongTinBaoMat, lnCamKet, lnTrachNhiem;
    TextView txtThongTinBaoMat, txtCamKet, txtTrachNhiem;
    View viewCamKet, viewTrachNhiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        linkViews();
        addEvents();
    }


    private void linkViews() {
        lnThongTinBaoMat = findViewById(R.id.lnThongTinBaoMat);
        lnCamKet = findViewById(R.id.lnCamKet);
        lnTrachNhiem = findViewById(R.id.lnTrachNhiem);
        txtThongTinBaoMat = findViewById(R.id.txtThongTinBaoMat);
        txtCamKet = findViewById(R.id.txtCamKet);
        txtTrachNhiem = findViewById(R.id.txtTrachNhiem);
        viewCamKet = findViewById(R.id.viewCamKet);
        viewTrachNhiem = findViewById(R.id.viewTrachNhiem);
    }

    private void addEvents() {
        lnThongTinBaoMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtThongTinBaoMat.setVisibility(txtThongTinBaoMat.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                viewCamKet.setVisibility(viewCamKet.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
        lnCamKet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCamKet.setVisibility(txtCamKet.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                viewTrachNhiem.setVisibility(viewTrachNhiem.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
        lnTrachNhiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTrachNhiem.setVisibility(txtTrachNhiem.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
    }
}