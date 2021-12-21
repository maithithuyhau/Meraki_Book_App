package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro3Activity extends AppCompatActivity {

    Button btnIntro3Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro3);

        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnIntro3Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro3Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        btnIntro3Next = findViewById(R.id.btnIntro3Next);
    }
}