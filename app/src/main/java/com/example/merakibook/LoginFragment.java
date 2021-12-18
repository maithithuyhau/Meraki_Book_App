package com.example.merakibook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {

    View view;
    EditText edtEmailOrSDT, edtMatKhau;

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
        return view;
    }

    private void linkView() {
        edtEmailOrSDT = view.findViewById(R.id.edtEmailOrSĐT);
        edtMatKhau = view.findViewById(R.id.edtMatKhau);
        //btnDangNhap =view.findViewById(R.id.btnDangNhap);

    }
}