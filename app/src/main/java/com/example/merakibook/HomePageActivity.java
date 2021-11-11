package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.adapter.BannerAdapter;
import com.example.adapter.BookAdapterHorizontal;
import com.example.model.Banner;
import com.example.model.Book;
import com.example.model.BookItemClickListener;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageActivity extends AppCompatActivity implements BookItemClickListener {
    private List<Banner> list_banner;
    private ViewPager banner_page;
    private TabLayout indicator;
    private RecyclerView rcvSachMoiNhat, rcvSachHotNhat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        linkView();
        initData();
    }

    private void linkView() {
        banner_page=findViewById(R.id.banner_page);
        indicator=findViewById(R.id.indicator);
        rcvSachMoiNhat=findViewById(R.id.rcvSachMoiNhat);
        rcvSachHotNhat=findViewById(R.id.rcvSachHotNhat);
    }

    private void initData() {
        //list hình banner
        list_banner= new ArrayList<>();
        list_banner.add(new Banner(R.drawable.banner2));
        list_banner.add(new Banner(R.drawable.banner1));
        list_banner.add(new Banner(R.drawable.banner3));
        list_banner.add(new Banner(R.drawable.banne4));
        list_banner.add(new Banner(R.drawable.banner5));

        BannerAdapter adapter=new BannerAdapter(this, list_banner);
        banner_page.setAdapter(adapter);
        // set timer
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new HomePageActivity.BannerTimer(),2000,4000);
        indicator.setupWithViewPager(banner_page,true);
//
        List<Book> list_book1= new ArrayList<>();
        list_book1.add(new Book("Đắc nhân tâm","Dale Carnegie","320","15,000","45,000","First News - Trí Việt","2016-03-18","Bìa cứng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.datnhantam,R.string.dat_nhan_tam,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Dứt Tình","Vũ Trọng Phụng","162","15,000","45,000","NXB Văn Học","2016-03-18","Bìa cứng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Lão Hạc","Nam Cao","208","15,000","35,000","Nhà Xuất Bản Dân Trí","2021","Bìa mềm","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu,R.drawable.icon_heart,R.drawable.icon_fivestar));
        BookAdapterHorizontal adapter1= new BookAdapterHorizontal(this,list_book1,this);
        rcvSachMoiNhat.setAdapter(adapter1);
        rcvSachMoiNhat.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        //
        List<Book> list_book2= new ArrayList<>();
        list_book2.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book2.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book2.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book2.add(new Book("Đắc nhân tâm","Dale Carnegie","320","15,000","45,000","First News - Trí Việt","2016-03-18","Bìa cứng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.datnhantam,R.string.dat_nhan_tam,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book2.add(new Book("Dứt Tình","Vũ Trọng Phụng","162","15,000","45,000","NXB Văn Học","2016-03-18","Bìa cứng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book2.add(new Book("Lão Hạc","Nam Cao","208","15,000","35,000","Nhà Xuất Bản Dân Trí","2021","Bìa mềm","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac,R.drawable.icon_heart,R.drawable.icon_fivestar));
        BookAdapterHorizontal adapter2=new BookAdapterHorizontal(this, list_book2,this);
        rcvSachHotNhat.setAdapter(adapter2);
        rcvSachHotNhat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(this,DetailBookActivity.class);
        intent.putExtra("Title",book.getBookName());
        intent.putExtra("Summary",book.getBookSummary());
        intent.putExtra("Image",book.getBookImage());
        intent.putExtra("Author",book.getBookAuthor());
        intent.putExtra("Page",book.getBookPage());
        intent.putExtra("EbookPrice",book.getEbookPrice());
        intent.putExtra("bookPrice",book.getBookPrice());
        intent.putExtra("Publisher",book.getBookPublisher());
        intent.putExtra("DateTime",book.getDateTime());
        intent.putExtra("LoaiBia",book.getLoaiBia());
        intent.putExtra("BookSize",book.getBookSize());


//        startActivity(intent);

        //Animation
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(HomePageActivity.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }

    class  BannerTimer extends TimerTask {

        @Override
        public void run() {
            HomePageActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (banner_page.getCurrentItem()<list_banner.size()-1){
                        banner_page.setCurrentItem(banner_page.getCurrentItem()+1);
                    }else
                        banner_page.setCurrentItem(0);
                }
            });
        }
    }
}