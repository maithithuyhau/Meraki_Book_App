package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class ReturnAndRefundPolicyActivity extends AppCompatActivity {
    LinearLayout lnThoiGian, lnHoanTien;
    TextView txtThoiGian, txtHoanTien;
    View viewHoanTien;
    TableLayout tbThoiGian;
    ImageButton imbBackReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_and_refund_policy);

        linkViews();
        addEvents();
    }



    private void linkViews() {
        lnThoiGian = findViewById(R.id.lnThoiGian);
        lnHoanTien = findViewById(R.id.lnHoanTien);
        txtThoiGian = findViewById(R.id.txtThoiGian);
        txtHoanTien = findViewById(R.id.txtHoanTien);
        viewHoanTien = findViewById(R.id.viewHoanTien);
        tbThoiGian = findViewById(R.id.tbThoiGian);
        imbBackReturn = findViewById(R.id.imbBackReturn);
    }
    private void addEvents() {
        lnThoiGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtThoiGian.setVisibility(txtThoiGian.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                tbThoiGian.setVisibility(tbThoiGian.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                viewHoanTien.setVisibility(viewHoanTien.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
        lnHoanTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHoanTien.setVisibility(txtHoanTien.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });
        imbBackReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}