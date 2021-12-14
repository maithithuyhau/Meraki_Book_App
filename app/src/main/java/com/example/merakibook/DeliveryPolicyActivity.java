package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DeliveryPolicyActivity extends AppCompatActivity {
    ImageButton imbBackDelivery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_policy);
        linkViews();
        addEvents();
    }


    private void linkViews() {
        imbBackDelivery = findViewById(R.id.imbBackDelivery);
    }

    private void addEvents() {
        imbBackDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}