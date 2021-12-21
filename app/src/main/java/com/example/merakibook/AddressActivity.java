package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

    public static final String REFERENCE_NAME = "paymentInfo";

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
                SharedPreferences preferences = getSharedPreferences(REFERENCE_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("diachi", edtDcAddress.getText().toString());
                editor.commit();
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
            String phoneData = edtDcPhone.getText().toString().trim();
            String addressData = edtDcAddress.getText().toString().trim();

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