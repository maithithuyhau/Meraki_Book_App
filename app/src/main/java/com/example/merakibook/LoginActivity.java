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

public class LoginActivity extends Fragment {

    View view;
    ViewPaperAdapterLogin viewPaperAdapterLogin;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_my_book,container,false);

        linkView();

        viewPaperAdapterLogin = new ViewPaperAdapterLogin(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPaperAdapterLogin);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void linkView() {
        viewPager = view.findViewById(R.id.vp_login);
        tabLayout = view.findViewById(R.id.tl_login);
    }

}

