package com.example.merakibook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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

    ViewPaperAdapterLogin viewPaperAdapterLogin;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        viewPaperAdapterLogin= new ViewPaperAdapterLogin(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPaperAdapterLogin);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initView() {
        viewPager = findViewById(R.id.vp_login);

        tabLayout = findViewById(R.id.tl_login);

    }
}

