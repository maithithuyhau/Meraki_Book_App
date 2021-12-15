package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;


public class QRcodeActivity extends AppCompatActivity {

    private Button btnCheck, btnBackHome;
    private TextView txtTittle, txtCountdown;
    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;

    private static final long START_TIME_IN_MILLIS = 1800000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        linkView();
        addEvent();
//        getDataVisa();
//        getDataATM();
        startTime();
    }

    private void linkView() {
        btnCheck = findViewById(R.id.btnCheck);
        btnBackHome = findViewById(R.id.btnBackHome);
        txtTittle = findViewById(R.id.txtTittle);
        txtCountdown =  findViewById(R.id.txtCountdown);
    }

    private void addEvent() {
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(QRcodeActivity.this);
            }
        });
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRcodeActivity.this,MainActivity.class);
                QRcodeActivity.this.startActivity(intent);
            }
        });
    }

    private void getDataVisa() {
        Intent intent = getIntent();
        String visa = intent.getStringExtra("visa");
        txtTittle.setText(visa);
    }

    private void getDataATM() {
        Intent intent = getIntent();
        String atm = intent.getStringExtra("atm");
        txtTittle.setText(atm);
    }

    private void startTime() {
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000 / 60);
        int seconds = (int) (timeLeftInMillis / 1000 % 60);
        String timeLeftFormat = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        txtCountdown.setText(timeLeftFormat);
    }

    public void openDialog(Context context){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.popup_order_successful);

        Button btnDetailOrder = dialog.findViewById(R.id.btnDetailOrder);
        btnDetailOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,PurchaseOrderActivity.class);
                context.startActivity(intent);
            }
        });

        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

}