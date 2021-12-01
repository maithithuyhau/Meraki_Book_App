package com.example.merakibook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adapter.ViewPaperAdapterLogin;
import com.example.adapter.ViewPaperAdapterMyBook;
import com.google.android.material.tabs.TabLayout;

import java.util.zip.Inflater;

public class LoginActivity extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.vp_login);
        viewPager.setAdapter(new ViewPaperAdapterLogin(getSupportFragmentManager()));
        tabLayout = findViewById(R.id.tl_login);
        tabLayout.setupWithViewPager(viewPager);
    }
}

