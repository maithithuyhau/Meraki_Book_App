package com.example.merakibook;

import static com.example.utils.Constant.REFERENCE_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

public class DeliveryActivity extends AppCompatActivity {
    Button btnDvDongY;
    CheckBox chkNgayNhanNhanh, chkNgayNhanTietKiem, chkNgayNhanViettel;
    TextView txtNgayNhanNhanh, txtNgayNhanTietKiem, txtNgayNhanViettel;
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        linkView();
        addEvent();
    }

    private void linkView() {
        btnDvDongY = findViewById(R.id.btnDvDongY);
        btnBack = findViewById(R.id.btnBack);

        chkNgayNhanNhanh = findViewById(R.id.chkNgayNhanNhanh);
        chkNgayNhanTietKiem = findViewById(R.id.chkNgayNhanTietKiem);
        chkNgayNhanViettel =findViewById(R.id.chkNgayNhanViettel);

        txtNgayNhanNhanh = findViewById(R.id.txtNgayNhanNhanh);
        txtNgayNhanTietKiem = findViewById(R.id.txtNgayNhanTietKiem);
        txtNgayNhanViettel = findViewById(R.id.txtNgayNhanViettel);
    }

    private void addEvent() {
        checkEvent();
        btnDvDongY.setOnClickListener(myClick);
        btnBack.setOnClickListener(myClick);
    }

    View.OnClickListener myClick = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnDvDongY:
                    SharedPreferences preferences = getSharedPreferences(REFERENCE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    if(chkNgayNhanNhanh.isChecked()){
                        editor.putString("giaohang","Giao hàng nhanh: " + txtNgayNhanNhanh.getText().toString());
                    }else if(chkNgayNhanTietKiem.isChecked()){
                        editor.putString("giaohang","Giao hàng tiết kiệm: "+ txtNgayNhanTietKiem.getText().toString());
                    }else if(chkNgayNhanViettel.isChecked()){
                        editor.putString("giaohang","Giao hàng Viettel: "+ txtNgayNhanViettel.getText().toString());
                    }
                    editor.commit();
                    intent = new Intent(DeliveryActivity.this, PaymentOptionActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnBack:
                    finish();
                    break;
            }
        }
    };



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