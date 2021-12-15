package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro2Activity extends AppCompatActivity {

    Button btnIntro2Next, btnIntro2Skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);

        linkViews();
        addEvent();
    }

    private void addEvent() {
        btnIntro2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro2Activity.this, Intro3Activity.class);
                startActivity(intent);
            }
        });
        btnIntro2Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro2Activity.this, Intro1Activity.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        btnIntro2Next=findViewById(R.id.btnIntro2Next);
        btnIntro2Skip=findViewById(R.id.btnIntro2Skip);
    }
}