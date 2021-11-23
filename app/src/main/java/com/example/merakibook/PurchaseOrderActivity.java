package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.adapter.PurchaseOrderSectionAdapter;
import com.google.android.material.tabs.TabLayout;

public class PurchaseOrderActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 pager2;
    PurchaseOrderSectionAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_order);
        linkViews();
        loadData();


    }


    private void linkViews() {
        tabLayout = findViewById(R.id.TabPurchaseOrder);
        pager2 = findViewById(R.id.PurchaseOrderView);
    }


    private void loadData() {
        FragmentManager fm = getSupportFragmentManager();
        adapter = new PurchaseOrderSectionAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Chờ xác nhận"));
        tabLayout.addTab(tabLayout.newTab().setText("Đang giao"));
        tabLayout.addTab(tabLayout.newTab().setText("Đã giao"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}