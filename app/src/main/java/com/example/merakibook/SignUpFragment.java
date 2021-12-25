package com.example.merakibook;

import static com.example.utils.Constant.ACCOUNT_STATUS_PATH;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class SignUpFragment extends Fragment {

    View view;
    EditText edtEmailOrSDT, edtMatKhau, edtNhapLaiMatKhau;
    Button btnDangKi;


    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view  =inflater.inflate(R.layout.fragment_sign_up, container, false);

        linkView();
        addEvent();
        return view;
    }

    private void addEvent() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File f = new File(getActivity().getApplicationInfo().dataDir + ACCOUNT_STATUS_PATH);
                if (f.exists()){
                    Intent intent = new Intent(getActivity(), AccountActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void linkView() {
        edtEmailOrSDT= view.findViewById(R.id.edtEmailOrSĐT);
        edtMatKhau = view.findViewById(R.id.edtMatKhau);
        edtNhapLaiMatKhau = view.findViewById(R.id.edtNhapLaiMatKhau);
        btnDangKi = view.findViewById(R.id.btnDangKi);
    }
}