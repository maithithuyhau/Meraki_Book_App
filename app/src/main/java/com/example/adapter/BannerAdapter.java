package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.merakibook.R;
import com.example.model.Banner;

import java.util.List;

public class BannerAdapter extends PagerAdapter {
    private Context context;
    private List<Banner> listBanner;

    public BannerAdapter(Context context, List<Banner> listBanner) {
        this.context = context;
        this.listBanner = listBanner;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View bannerLayout = inflater.inflate(R.layout.banner_item,null);

        ImageView imvImage=bannerLayout.findViewById(R.id.imvBanner);


        imvImage.setImageResource(listBanner.get(position).getImageSlide());


        container.addView(bannerLayout);
        return bannerLayout;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return listBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
