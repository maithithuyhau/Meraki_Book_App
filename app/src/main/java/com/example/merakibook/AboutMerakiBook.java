package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AboutMerakiBook extends AppCompatActivity {
ImageView imvTwitter, imvFB, imvInsta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_meraki_book);
        linkView();
        addEvent();
    }

    private void linkView() {
        imvFB=findViewById(R.id.imvFB);
        imvInsta=findViewById(R.id.imvInsta);
        imvTwitter=findViewById(R.id.imvTwitter);
    }

    private void addEvent() {
        imvTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/hau-mai-12676b216/?fbclid=IwAR0Y1SC6hfdydvQSRrTz3WP1SqUvmn1G8o7Bzmvy7X8DRthruR3GozDPmA8"));
                startActivity(intent);
            }
        });
        imvFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100009531826813"));
                startActivity(intent);
            }
        });
        imvInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/imh_au/"));
                startActivity(intent);
            }
        });
    }
}