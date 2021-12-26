package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.security.Policy;
import java.util.ArrayList;

public class PolicyActivity extends AppCompatActivity {
LinearLayout lnDieuKhoan, lnCSBaoMat, lnCSGiaoHang, lnCSDoiTra;
ImageButton imbBackPolicy;
Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        linkViews();
        addEvents();
    }


    private void linkViews() {
        lnDieuKhoan = findViewById(R.id.lnDieuKhoan);
        lnCSBaoMat = findViewById(R.id.lnCSBaoMat);
        lnCSGiaoHang = findViewById(R.id.lnCSGiaoHang);
        lnCSDoiTra = findViewById(R.id.lnCSDoiTra);
        imbBackPolicy = findViewById(R.id.imbBackPolicy);
        btnCall = findViewById(R.id.btnCall);
    }

    private void addEvents() {
        lnDieuKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PolicyActivity.this, TermsOfUseActivity.class);
                startActivity(intent);
            }
        });
        lnCSBaoMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PolicyActivity.this, PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });
        lnCSGiaoHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PolicyActivity.this, DeliveryPolicyActivity.class);
                startActivity(intent);
            }
        });
        lnCSDoiTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PolicyActivity.this, ReturnAndRefundPolicyActivity.class);
                startActivity(intent);
            }
        });
        imbBackPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:1900636466"));
                startActivity(callIntent);
            }
        });
    }
}