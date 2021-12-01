package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.merakibook.LoginFragment;
import com.example.merakibook.SignUpFragment;

public class ViewPaperAdapterLogin extends FragmentStatePagerAdapter {

    /*public ViewPaperAdapterLogin(FragmentManager fm) {
        super(fm);
        loginFragment = new LoginFragment();
        signupFragment = new SignUpFragment();
    }*/

    private String titleTab[]={"Đăng nhập", "Đăng ký"};
    private LoginFragment loginFragment;
    private SignUpFragment signupFragment;

    public ViewPaperAdapterLogin(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
        loginFragment = new LoginFragment();
        signupFragment = new SignUpFragment();
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return loginFragment;
        } else  if (position==1){
            return signupFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return titleTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleTab[position];
    }
}
