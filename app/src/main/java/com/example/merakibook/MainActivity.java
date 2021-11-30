package com.example.merakibook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView menu_bar;
    Fragment NavContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkView();
        getSupportFragmentManager().beginTransaction().replace(R.id.NavContent, new HomePageFragment()).commit();
    }

    private void linkView() {
        menu_bar=(BottomNavigationView)findViewById(R.id.menu_bar);
        menu_bar.setOnNavigationItemSelectedListener(navListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.Home:
                    selectedFragment=new HomePageFragment();
                    break;
                case R.id.TuSach:
//            selectedFragment=new HomePageFragment();
                    break;
                case R.id.ThongBao:
                    selectedFragment=new AccountActivity();
                    break;
                case R.id.TaiKhoan:
                    selectedFragment=new NotificationActivity();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.NavContent, selectedFragment).commit();
            return  true;
        }
    };
}