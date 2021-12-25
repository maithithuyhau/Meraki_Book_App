package com.example.merakibook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adapter.ViewPaperAdapterMyBook;
import com.google.android.material.tabs.TabLayout;

public class MyBookActivity extends Fragment {

    View view;
    ViewPaperAdapterMyBook viewPaperAdapterMyBook;
    TabLayout tabLayout;
    ViewPager viewPager;

    public MyBookActivity() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_my_book,container,false);

        linkView();

        viewPaperAdapterMyBook = new ViewPaperAdapterMyBook(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPaperAdapterMyBook);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void linkView() {
        viewPager = view.findViewById(R.id.viewPagerMyBook);
        tabLayout = view.findViewById(R.id.tabMyBook);
    }

}