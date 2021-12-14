package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddressActivity extends AppCompatActivity {
    Button btnDcLuuThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        linkView();
        addEvent();
    }

    private void linkView() {
        btnDcLuuThongTin = findViewById(R.id.btnDcLuuThongTin);
    }

    private void addEvent() {
        btnDcLuuThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddressActivity.this, DeliveryActivity.class);
                startActivity(intent);
            }
        });
    }


}