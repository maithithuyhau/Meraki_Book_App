package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class DeliveryActivity extends AppCompatActivity {
    Button btnDvDongY;
    CheckBox chkNgayNhanNhanh, chkNgayNhanTietKiem, chkNgayNhanViettel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        linkView();
        addEvent();
    }

    private void linkView() {
        btnDvDongY = findViewById(R.id.btnDvDongY);
        chkNgayNhanNhanh = findViewById(R.id.chkNgayNhanNhanh);
        chkNgayNhanTietKiem = findViewById(R.id.chkNgayNhanTietKiem);
        chkNgayNhanViettel =findViewById(R.id.chkNgayNhanViettel);
    }

    private void addEvent() {
        //emptyEvent();
        checkEvent();
        btnDvDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeliveryActivity.this, PaymentOptionActivity.class);
                startActivity(intent);
            }
        });
    }




    private void checkEvent() {
        chkNgayNhanNhanh.setOnCheckedChangeListener(check);
        chkNgayNhanTietKiem.setOnCheckedChangeListener(check);
        chkNgayNhanViettel.setOnCheckedChangeListener(check);
    }

    CompoundButton.OnCheckedChangeListener check = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (compoundButton.getId() == R.id.chkNgayNhanNhanh){
                if(b){
                    chkNgayNhanTietKiem.setChecked(false);
                    chkNgayNhanViettel.setChecked(false);

                    chkNgayNhanTietKiem.setEnabled(false);
                    chkNgayNhanViettel.setEnabled(false);
                    btnDvDongY.setEnabled(true);
                }else {
                    chkNgayNhanTietKiem.setEnabled(true);
                    chkNgayNhanViettel.setEnabled(true);
                    btnDvDongY.setEnabled(false);
                }
            }else if(compoundButton.getId() == R.id.chkNgayNhanTietKiem){
                if(b){
                    chkNgayNhanNhanh.setChecked(false);
                    chkNgayNhanViettel.setChecked(false);

                    chkNgayNhanNhanh.setEnabled(false);
                    chkNgayNhanViettel.setEnabled(false);
                    btnDvDongY.setEnabled(true);
                }else {
                    chkNgayNhanNhanh.setEnabled(true);
                    chkNgayNhanViettel.setEnabled(true);
                    btnDvDongY.setEnabled(false);
                }
            }else if(compoundButton.getId() == R.id.chkNgayNhanViettel){
                if(b){
                    chkNgayNhanNhanh.setChecked(false);
                    chkNgayNhanTietKiem.setChecked(false);

                    chkNgayNhanNhanh.setEnabled(false);
                    chkNgayNhanTietKiem.setEnabled(false);
                    btnDvDongY.setEnabled(true);
                }else {
                    chkNgayNhanNhanh.setEnabled(true);
                    chkNgayNhanTietKiem.setEnabled(true);
                    btnDvDongY.setEnabled(false);
                }
            }


        }
    };


}