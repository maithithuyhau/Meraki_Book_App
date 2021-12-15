package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeliveryActivity extends AppCompatActivity {
    Button btnDvDongY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        linkView();
        addEvent();
    }

    private void linkView() {
        btnDvDongY = findViewById(R.id.btnDvDongY);
    }

    private void addEvent() {
        btnDvDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeliveryActivity.this, PaymentOptionActivity.class);
                startActivity(intent);
            }
        });
    }
}