package com.example.merakibook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.adapter.BannerAdapter;
import com.example.adapter.BookAdapterHorizontal;
import com.example.model.Banner;
import com.example.model.Book;
import com.example.model.BookItemClickListener;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public abstract class HomePageActivity extends AppCompatActivity implements BookItemClickListener {
//    private List<Banner> list_banner;
//    private ViewPager banner_page;
//    private TabLayout indicator;
//    private RecyclerView rcvSachMoiNhat, rcvSachHotNhat,rcvTop10, rcvDeXuat, rcvBookFree;
//
//    private DrawerLayout drawerLayout;
//    private ImageView imvDanhmuc;
//    private ActionBarDrawerToggle toggle;
//    NavigationView danhmuc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

//        linkView();
//        initData();
//        addEvent();

    }

//    private void linkView() {
//        banner_page=findViewById(R.id.banner_page);
//        indicator=findViewById(R.id.indicator);
//
//        rcvSachMoiNhat=findViewById(R.id.rcvSachMoiNhat);
//        rcvSachHotNhat=findViewById(R.id.rcvSachHotNhat);
//        rcvTop10=findViewById(R.id.rcvTop10);
//        rcvBookFree=findViewById(R.id.rcvBookFree);
//        rcvDeXuat=findViewById(R.id.rcvDeXuat);
//
//
//
//        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//
//
//        drawerLayout=(DrawerLayout) findViewById(R.id.drawDanhmuc);
//        danhmuc=(NavigationView) findViewById(R.id.danhmuc);
//        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
////        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//    }
//
//
//    private void addEvent() {
//        danhmuc.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.bangxephang:
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.tieuthuyet:
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.truyenngan:
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.trinhtham:
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.giatuong:
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.kinhdoanh:
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.kynang:
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.tamly:
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.giaoduc:
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//
//                }
//                return true;
//            }
//        });
//
//
//
//    }
//
//    private void initData() {
//        //list h??nh banner
//        list_banner= new ArrayList<>();
//        list_banner.add(new Banner(R.drawable.banner2));
//        list_banner.add(new Banner(R.drawable.banner1));
//        list_banner.add(new Banner(R.drawable.banner3));
//        list_banner.add(new Banner(R.drawable.banne4));
//        list_banner.add(new Banner(R.drawable.banner5));
//
//        BannerAdapter adapter=new BannerAdapter(this, list_banner);
//        banner_page.setAdapter(adapter);
//        // set timer
//        Timer timer=new Timer();
//        timer.scheduleAtFixedRate(new HomePageActivity.BannerTimer(),2000,4000);
//        indicator.setupWithViewPager(banner_page,true);
////S??ch m???i
//        List<Book> list_book1= new ArrayList<>();
//        list_book1.add(new Book("?????c nh??n t??m","Dale Carnegie","320","15,000","45,000","First News - Tr?? Vi???t","2016-03-18","B??a c???ng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.datnhantam,R.string.dat_nhan_tam,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book1.add(new Book("D???t T??nh","V?? Tr???ng Ph???ng","162","15,000","45,000","NXB V??n H???c","2016-03-18","B??a c???ng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book1.add(new Book("L??o H???c","Nam Cao","208","15,000","35,000","Nh?? Xu???t B???n D??n Tr??","2021","B??a m???m","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book1.add(new Book("Nh???ng quy t???c t?? duy"," Richard Templar","336","45,000","129,000 ","Nh?? Xu???t B???n Lao ?????ng","21/08/2021","B??a m???m","15 x 23 cm",R.string.sach_moi,R.drawable.nhungquytactuduy,R.string.nhung_quy_tac_tu_duy,R.drawable.icon_heart,R.drawable.icon_fivestar));
//
//        BookAdapterHorizontal adapter1= new BookAdapterHorizontal(this,list_book1,this);
//        rcvSachMoiNhat.setAdapter(adapter1);
//        rcvSachMoiNhat.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//
//        //s??ch hot
//        List<Book> list_book2= new ArrayList<>();
//        list_book2.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nh?? Xu???t B???n Th??? Gi???i","2021-07-14 11:36:27","B??a m???m","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book2.add(new Book("Sinh tr???c v??n tay","RICHARD UNGER","444","85,000","183,000 ","Nh?? Xu???t B???n H???ng ?????c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book2.add(new Book("B???m ?????t gi?? bao nhi??u","V??n T??nh","320","45,000","119,000","NXB V??n H???c","2018-08-01","B??a m???m","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book2.add(new Book("Gia t???c Morgan","Ron Chernow","1092","65,000","279,000"," NXB Th??? Gi???i","30/09/2021","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan,R.drawable.icon_heart,R.drawable.icon_fivestar));
//
//        BookAdapterHorizontal adapter2=new BookAdapterHorizontal(this, list_book2,this);
//        rcvSachHotNhat.setAdapter(adapter2);
//        rcvSachHotNhat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
//
//        // S??ch Top 10
//        List<Book> list_book3= new ArrayList<>();
//        list_book3.add(new Book("Becoming"," Michelle Obama","448","35,000","579.000","Penguin Books","2021-07-14 11:36:27","Hardback","242 x 164 x 42 mm",R.string.sach_moi,R.drawable.becoming,R.string.sapiens,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book3.add(new Book("Kh??ng gia ????nh","Hector Malot","582","45,000","168,210","NXB V??n H???c","14/01/2016","B??a m???m","16 x 24 cm",R.string.sach_moi,R.drawable.khonggiadinh,R.string.khong_gia_dinh,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book3.add(new Book("Ch??u ??u c?? g?? l??? kh??ng em?","Misa Gjone","192","15,000","69,000","Saigon Books","15/10/2019","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.chauaucogilakhongem,R.string.chau_au_co_gi_la_khong_em,R.drawable.icon_heart,R.drawable.icon_fivestar));
//
//        BookAdapterHorizontal adapter3=new BookAdapterHorizontal(this, list_book3,this);
//        rcvTop10.setAdapter(adapter3);
//        rcvTop10.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
////S??ch free
//        List<Book> list_book4= new ArrayList<>();
//        list_book4.add(new Book("M???t m??a th?? d???i","Higuchi Ichiyo","192","15,000","59,000","NXB H???i Nh?? V??n"," 28/07/2015","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.motmuathodai,R.string.mot_mua_tho_dai,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book4.add(new Book("Sinh tr???c v??n tay","RICHARD UNGER","444","85,000","183,000 ","Nh?? Xu???t B???n H???ng ?????c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book4.add(new Book("B???m ?????t gi?? bao nhi??u","V??n T??nh","320","45,000","119,000","NXB V??n H???c","2018-08-01","B??a m???m","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book4.add(new Book("?????c nh??n t??m","Dale Carnegie","320","15,000","45,000","First News - Tr?? Vi???t","2016-03-18","B??a c???ng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.datnhantam,R.string.dat_nhan_tam,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book4.add(new Book("D???t T??nh","V?? Tr???ng Ph???ng","162","15,000","45,000","NXB V??n H???c","2016-03-18","B??a c???ng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book4.add(new Book("L??o H???c","Nam Cao","208","15,000","35,000","Nh?? Xu???t B???n D??n Tr??","2021","B??a m???m","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        BookAdapterHorizontal adapter4=new BookAdapterHorizontal(this, list_book4,this);
//        rcvBookFree.setAdapter(adapter4);
//        rcvBookFree.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
//
//        //S??ch ????? xu???t
//        List<Book> list_book5= new ArrayList<>();
//        list_book5.add(new Book("Ba ??i, m??nh ??i ????u?","Jean-Louis Fournier","178","15,000","51,000","H???i nh?? v??n","25-11-2019","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book5.add(new Book("Khi H??i Th??? H??a Thinh Kh??ng"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book5.add(new Book("????p ??n C???a Th???i Gian","L?? T?? H???o","312","20,000","77,000","Nh?? Xu???t B???n Ph??? N??? Vi???t Nam","2021-02-01","B??a m???m","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian,R.drawable.icon_heart,R.drawable.icon_fivestar));
//        list_book5.add(new Book("B???n M??a Cu???c S???ng","Jim Rohn","164","25,000","75,000","Th??i H??","2018-05-07","B??a m???m","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song,R.drawable.icon_heart,R.drawable.icon_fivestar));
//
//        BookAdapterHorizontal adapter5=new BookAdapterHorizontal(this, list_book5,this);
//        rcvDeXuat.setAdapter(adapter5);
//        rcvDeXuat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
//    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
//        Intent intent=new Intent(this,DetailBookActivity.class);
//        intent.putExtra("Title",book.getBookName());
//        intent.putExtra("Summary",book.getBookSummary());
//        intent.putExtra("Image",book.getBookImage());
//        intent.putExtra("Author",book.getBookAuthor());
//        intent.putExtra("Page",book.getBookPage());
//        intent.putExtra("EbookPrice",book.getEbookPrice());
//        intent.putExtra("bookPrice",book.getBookPrice());
//        intent.putExtra("Publisher",book.getBookPublisher());
//        intent.putExtra("DateTime",book.getDateTime());
//        intent.putExtra("LoaiBia",book.getLoaiBia());
//        intent.putExtra("BookSize",book.getBookSize());
//
//
////        startActivity(intent);
//
//        //Animation
//        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(HomePageActivity.this, bookImageView,"sharedName");
//        startActivity(intent,options.toBundle());
    }

//    class  BannerTimer extends TimerTask {
//
//        @Override
//        public void run() {
//            HomePageActivity.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    if (banner_page.getCurrentItem()<list_banner.size()-1){
//                        banner_page.setCurrentItem(banner_page.getCurrentItem()+1);
//                    }else
//                        banner_page.setCurrentItem(0);
//                }
//            });
//        }
//    }
}