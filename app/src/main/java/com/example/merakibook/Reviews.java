package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Reviews extends AppCompatActivity {
ImageView imvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        linkView();
        addEvent();
    }

    private void linkView() {
        imvBack=findViewById(R.id.imvBack);

    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Reviews.this,DetailBookActivity.class);
                startActivity(intent);
            }
        });
    }
}