package com.example.merakibook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.adapter.ViewPaperAdapterLogin;
import com.example.adapter.ViewPaperAdapterMyBook;
import com.google.android.material.tabs.TabLayout;

import java.util.zip.Inflater;

public class LoginActivity extends AppCompatActivity {

    Fragment fragment;
    Button btnDangKy, btnDangNhap;
    LinearLayout linearLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        linkView();
        addEvent();
    }

    private void addEvent() {
        btnDangNhap.setOnClickListener(myClick);
        btnDangKy.setOnClickListener(myClick);
    }

    View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            switch (view.getId()){
                case R.id.btnDangNhap:
                    fragment = new LoginFragment();
                    break;
                case R.id.btnDangKy:
                    fragment = new SignUpFragment();
                    break;
                default:
                    fragment = new LoginFragment();
                    break;
            }

            transaction.replace(R.id.linearLayoutContainer, fragment);
            transaction.commit();
        }
    };


    private void linkView() {
        btnDangKy = findViewById(R.id.btnDangKy);
        btnDangNhap = findViewById(R.id.btnDangNhap);

        linearLayoutContainer = findViewById(R.id.linearLayoutContainer);

    }

}

