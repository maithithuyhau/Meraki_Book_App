package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {
    Button btnDcLuuThongTin;
    EditText edtDcAddress,edtDcName,edtDcPhone;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        linkView();
        addEvent();
    }

    private void linkView() {
        btnDcLuuThongTin = findViewById(R.id.btnDcLuuThongTin);
        edtDcAddress = findViewById(R.id.edtDcAddress);
        edtDcName = findViewById(R.id.edtDcName);
        edtDcPhone = findViewById(R.id.edtDcPhone);
    }

    private void addEvent() {
        btnDcLuuThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AddressActivity.this, DeliveryActivity.class);
                startActivity(intent);
            }
        });

        edtDcName.addTextChangedListener(checkEmpty);
        edtDcPhone.addTextChangedListener(checkEmpty);
        edtDcAddress.addTextChangedListener(checkEmpty);

    }
    private TextWatcher checkEmpty = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String nameData = edtDcName.getText().toString().trim();
            String phoneData = edtDcName.getText().toString().trim();
            String addressData = edtDcName.getText().toString().trim();

            if(!nameData.isEmpty() && !phoneData.isEmpty() && ! addressData.isEmpty()){
                btnDcLuuThongTin.setEnabled(true);
            }else{
                btnDcLuuThongTin.setEnabled(false);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };




}