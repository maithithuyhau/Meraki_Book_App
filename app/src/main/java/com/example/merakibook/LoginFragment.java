package com.example.merakibook;

import static com.example.utils.Constant.ACCOUNT_STATUS_PATH;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;

public class LoginFragment extends Fragment {

    View view;
    EditText edtEmailOrSDT, edtMatKhau;
    Button btnDangNhap;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view  =inflater.inflate(R.layout.fragment_login, container, false);

        linkView();
        addEvent();
        return view;
    }

    private void addEvent() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtEmailOrSDT.getText().toString().isEmpty()){
                    edtEmailOrSDT.setError("Vui lòng điền thông tin!");
                }else if (edtMatKhau.getText().toString().isEmpty()){
                    edtMatKhau.setError("Vui lòng điền thông tin!");
                } else {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void linkView() {
        edtEmailOrSDT = view.findViewById(R.id.edtEmailOrSĐT);
        edtMatKhau = view.findViewById(R.id.edtMatKhau);
        btnDangNhap =view.findViewById(R.id.btnDangNhap);

    }

}