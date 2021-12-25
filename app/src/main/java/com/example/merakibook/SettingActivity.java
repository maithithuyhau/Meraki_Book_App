package com.example.merakibook;

import static com.example.utils.Constant.ACCOUNT_STATUS_PATH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;

public class SettingActivity extends AppCompatActivity {

    ImageButton imbBackSetting;
    Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        linkView();
        addEvent();
    }

    private void linkView() {
        imbBackSetting = findViewById(R.id.imbBackSetting);
        btnSignOut = findViewById(R.id.btnSignOut);
    }

    private void addEvent() {
        imbBackSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File f = new File(getApplicationInfo().dataDir + ACCOUNT_STATUS_PATH );
                if(f.exists()){
                    f.delete();
                    }
                Intent intent = new Intent(SettingActivity.this,MainActivity.class);
                SettingActivity.this.startActivity(intent);
            }
        });
    }

}