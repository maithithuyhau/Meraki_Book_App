package com.example.merakibook;

import static com.example.utils.Constant.REFERENCE_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class PaymentOptionActivity extends AppCompatActivity {

    RadioGroup rdgPaymentOption;
    RadioButton rdoCOD, rdoATM, rdoVisa;
    Button btnAgree;
    ImageButton imbBack;

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
        imbBack = findViewById(R.id.imbBack);
    }

    private void addEvent() {
        checkEmpty();
        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(REFERENCE_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                if(rdoATM.isChecked()){
                    editor.putString("thanhtoan", rdoATM.getText().toString());
                }else if(rdoCOD.isChecked()){
                    editor.putString("thanhtoan", rdoCOD.getText().toString());
                }else if(rdoVisa.isChecked()){
                    editor.putString("thanhtoan", rdoVisa.getText().toString());
                }
                editor.commit();
                Intent intent = new Intent(PaymentOptionActivity.this, PaymentActivity.class);
                startActivity(intent);
//                int checkedOption = rdgPaymentOption.getCheckedRadioButtonId();
//                    selectedPayment(checkedOption);
            }
        });

        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void checkEmpty() {
        rdoCOD.setOnCheckedChangeListener(checkRadio);
        rdoATM.setOnCheckedChangeListener(checkRadio);
        rdoVisa.setOnCheckedChangeListener(checkRadio);
    }
    CompoundButton.OnCheckedChangeListener checkRadio = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(compoundButton.getId() == R.id.rdoCOD){
                if(b){
                    btnAgree.setEnabled(true);
                }
            }else if(compoundButton.getId() == R.id.rdoATM){
                if(b){
                    btnAgree.setEnabled(true);
                }
            }else if (compoundButton.getId() == R.id.rdoVisa){
                if(b){
                    btnAgree.setEnabled(true);
                }
            }
        }
    };

//    private void selectedPayment(int checkedId){
//        switch (checkedId){
//            case R.id.rdoCOD:
//                Intent intent = new Intent(PaymentOptionActivity.this, PaymentActivity.class);
//                PaymentOptionActivity.this.startActivity(intent);
//                break;
//            case R.id.rdoATM:
//                openQRActivityWithATM();
//                break;
//            case R.id.rdoVisa:
//                openQRActivityWithVisa();
//                break;
//        }
//    }

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