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
import android.widget.EditText;
import android.widget.ImageButton;

public class AddressActivity extends AppCompatActivity {
    Button btnDcLuuThongTin;
    ImageButton  btnBack;
    EditText edtDcAddress,edtDcName,edtDcPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        linkView();
        addEvent();
    }

    private void linkView() {
        btnDcLuuThongTin = findViewById(R.id.btnDcLuuThongTin);
        btnBack = findViewById(R.id.btnBack);

        edtDcAddress = findViewById(R.id.edtDcAddress);
        edtDcName = findViewById(R.id.edtDcName);
        edtDcPhone = findViewById(R.id.edtDcPhone);
    }

    private void addEvent() {
        btnBack.setOnClickListener(myClick);
        btnDcLuuThongTin.setOnClickListener(myClick);

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

    View.OnClickListener myClick = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnBack:
                    finish();
                    break;
                case R.id.btnDcLuuThongTin:
                    SharedPreferences preferences = getSharedPreferences(REFERENCE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("diachi", edtDcAddress.getText().toString());
                    editor.commit();
                    intent = new Intent(AddressActivity.this, DeliveryActivity.class);
                    startActivity(intent);
                    break;
                }
            }
        };
}