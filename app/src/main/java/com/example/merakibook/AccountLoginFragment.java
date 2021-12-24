package com.example.merakibook;

import static com.example.utils.Constant.ACCOUNT_STATUS_PATH;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

public class AccountLoginFragment extends Fragment  {
    Button btnAcSaw, btnAcRate,btnAcCart, btnAccDangNhap, btnAccDangKy, btnDangNhap;
    ImageButton btnCaiDat;
    ConstraintLayout layoutChinhSach, layoutGioiThieu;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account_login, container, false);
        linkView();
        addEvent();
        return view;
    }

    private void linkView() {
        layoutChinhSach = view.findViewById(R.id.layoutChinhSach);
        layoutGioiThieu = view.findViewById(R.id.layoutGioiThieu);
        btnAcCart = view.findViewById(R.id.btnAcCart);
        btnAcSaw = view.findViewById(R.id.btnAcSaw);
        btnAcRate = view.findViewById(R.id.btnAcRate);
        btnCaiDat = view.findViewById(R.id.btnCaiDat);
        btnAccDangKy = view.findViewById(R.id.btnAccDangKy);
        btnAccDangNhap = view.findViewById(R.id.btnAccDangNhap);
        btnDangNhap = view.findViewById(R.id.btnDangNhap);

    }
    private void addEvent() {
        btnAcCart.setOnClickListener(myClick);
        btnAcSaw.setOnClickListener(myClick);
        btnAcRate.setOnClickListener(myClick);
        layoutGioiThieu.setOnClickListener(myClick);
        layoutChinhSach.setOnClickListener(myClick);
        btnCaiDat.setOnClickListener(myClick);
        btnAccDangNhap.setOnClickListener(myClick);
        btnAccDangKy.setOnClickListener(myClick);
    }

    View.OnClickListener myClick = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnAcCart:
                    intent = new Intent(getActivity(),PurchaseOrderActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnAcSaw:
                    intent = new Intent(getActivity(),RecentlyBookActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnAcRate:
                    intent = new Intent(getActivity(),MyRatingActivity.class);
                    startActivity(intent);
                    break;
                case R.id.layoutGioiThieu:
                    intent = new Intent(getActivity(),AboutMerakiBook.class);
                    startActivity(intent);
                    break;
                case R.id.layoutChinhSach:
                    intent = new Intent(getActivity(),PolicyActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnCaiDat:
                    intent = new Intent(getActivity(), SettingActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnAccDangNhap:
                    btnAccDangNhap.setBackgroundResource(R.drawable.background_btn);
                    File f = new File(getActivity().getApplicationInfo().dataDir + ACCOUNT_STATUS_PATH);
                    if (!f.exists()){
                        f.mkdirs();
                        intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.btnAccDangKy:
                    btnAccDangKy.setBackgroundResource(R.drawable.background_btn);
                    File file = new File(getActivity().getApplicationInfo().dataDir + ACCOUNT_STATUS_PATH);
                    if (!file.exists()){
                        file.mkdirs();
                        intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                    }
                    break;
            }
        }
    };
}