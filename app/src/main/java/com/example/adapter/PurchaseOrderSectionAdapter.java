package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.merakibook.Confirm_Fragment;
import com.example.merakibook.Delivered_Fragment;
import com.example.merakibook.Delivering_Fragment;


public class PurchaseOrderSectionAdapter extends FragmentStateAdapter {

    public PurchaseOrderSectionAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1:
                return new Delivering_Fragment();
            case 2:
                return new Delivered_Fragment();
        }
        return new Confirm_Fragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
