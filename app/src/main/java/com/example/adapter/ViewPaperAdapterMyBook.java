package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.merakibook.mybookfragment.FavoriteBookFragment;
import com.example.merakibook.mybookfragment.MyEbookFragment;
import com.example.merakibook.mybookfragment.ReadedBookFragment;
import com.example.merakibook.mybookfragment.ReadingBookFragment;

public class ViewPaperAdapterMyBook extends FragmentPagerAdapter {

    public ViewPaperAdapterMyBook(@NonNull FragmentManager fragmentManager, int behavior ) {
        super(fragmentManager,behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FavoriteBookFragment();
            case 1:
                return new ReadingBookFragment();
            case 2:
                return new ReadedBookFragment();
            case 3:
                return new MyEbookFragment();
            default:
                return new FavoriteBookFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Yêu thích";
            case 1:
                return "Đang đọc";
            case 2:
                return "Đã đọc";
            case 3:
                return "Ebook của tôi";
            default:
                return "Yêu thích";
        }
    };
}
