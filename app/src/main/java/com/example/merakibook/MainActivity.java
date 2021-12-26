package com.example.merakibook;

import static com.example.utils.Constant.ACCOUNT_STATUS_PATH;
import static com.example.utils.Constant.REFERENCE_PATH;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView menu_bar;
    Fragment NavContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkView();
        addEvent();
        statusBar();
        getSupportFragmentManager().beginTransaction().replace(R.id.NavContent, new HomePageFragment()).commit();

    }

    public void statusBar(){
        if(Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.green));
        }
    }

    private void linkView() {
        menu_bar=(BottomNavigationView)findViewById(R.id.menu_bar);
        menu_bar.setOnNavigationItemSelectedListener(navListener);
    }

    private void addEvent() {
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
                selectedFragment=new MyBookActivity();
                    break;
                case R.id.ThongBao:
                    selectedFragment=new NotificationActivity();
                    break;
                case R.id.TaiKhoan:
                    File f = new File(getApplicationInfo().dataDir + ACCOUNT_STATUS_PATH );
                    if(!f.exists()){
                        selectedFragment=new AccountLoginFragment();
                    }else if(f.exists()){
                        selectedFragment=new AccountActivity();
                    }
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.NavContent, selectedFragment).commit();
            return  true;
        }
    };
}