package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PaymentOptionActivity extends AppCompatActivity {

    RadioGroup rdgPaymentOption;
    RadioButton rdoCOD, rdoATM, rdoVisa;
    Button btnAgree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);

        linkView();
        addEvent();
    }

    private void linkView() {
        rdgPaymentOption = findViewById(R.id.rdgPaymentOption);
        btnAgree = findViewById(R.id.btnAgree);
        rdoCOD = findViewById(R.id.rdoCOD);
        rdoATM = findViewById(R.id.rdoATM);
        rdoVisa = findViewById(R.id.rdoVisa);
    }

    private void addEvent() {
        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedOption = rdgPaymentOption.getCheckedRadioButtonId();
                if (checkedOption == -1){
                    Toast.makeText(PaymentOptionActivity.this, "Hãy chọn một phương thức thanh toán!", Toast.LENGTH_SHORT).show();
                }else{
                    selectedPayment(checkedOption);
                }
            }
        });
    }

    private void selectedPayment(int checkedId){
        switch (checkedId){
            case R.id.rdoCOD:
                QRcodeActivity qRcodeActivity = new QRcodeActivity();
                qRcodeActivity.openDialog(PaymentOptionActivity.this);
                break;
            case R.id.rdoATM:
                openQRActivityWithATM();
                break;
            case R.id.rdoVisa:
                openQRActivityWithVisa();
                break;
        }
    }

    private void openQRActivityWithATM(){
        String atm = "Sử dụng ứng dụng trên di động của ngân hàng (mobile banking) quét mã QR bên dưới để thanh toán.";
        Intent intent = new Intent(PaymentOptionActivity.this, QRcodeActivity.class);
        intent.putExtra("atm",atm);
        PaymentOptionActivity.this.startActivity(intent);
    }



    private void openQRActivityWithVisa(){
        String visa = "Sử dụng ứng dụng thẻ ghi nợ trên thiết bị di động quét mã QR bên dưới để thanh toán.";
        Intent intent = new Intent(PaymentOptionActivity.this, QRcodeActivity.class);
        intent.putExtra("visa",visa);
        startActivity(intent);
    }


}