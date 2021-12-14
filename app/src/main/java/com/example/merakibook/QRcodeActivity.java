package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class QRcodeActivity extends AppCompatActivity {

    Button btnCheck, btnBackHome, btnDetailOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        linkView();
        addEvent();

    }

    private void linkView() {
        btnCheck = findViewById(R.id.btnCheck);
        btnBackHome = findViewById(R.id.btnBackHome);
    }

    private void addEvent() {
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }


        });
    }
    public void openDialog(){

        Dialog dialog = new Dialog(QRcodeActivity.this);
        dialog.setContentView(R.layout.popup_order_successful);
        Button btnDetailOrder = dialog.findViewById(R.id.btnDetailOrder);
        btnDetailOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}