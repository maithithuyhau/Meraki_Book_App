package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro1Activity extends AppCompatActivity {
    Button btnIntro1Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

        linkViews();
        addEvent();
    }

    private void linkViews() { btnIntro1Next=findViewById(R.id.btnIntro1Next); }

    private void addEvent() {
        btnIntro1Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intro1Activity.this, Intro2Activity.class);
                startActivity(intent);
            }
        });
    }
}