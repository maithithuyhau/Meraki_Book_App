package com.example.merakibook;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.adapter.BannerAdapter;
import com.example.adapter.BookAdapterHorizontalFragment;
import com.example.model.Banner;
import com.example.model.Book;
import com.example.model.BookItemClickListener;
import com.example.utils.Constant;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment implements BookItemClickListener {
    public HomePageFragment(){

    }
    View view;
    private List<Banner> list_banner;
    private ViewPager banner_page;
    private TabLayout indicator;
    private RecyclerView rcvSachMoiNhat, rcvSachHotNhat,rcvTop10, rcvDeXuat, rcvBookFree;
//  private EditText edtSearch;
    private DrawerLayout drawerLayout;
    private ImageView imvDanhmuc, imvVip,imvCart,edtSearch;
    private ActionBarDrawerToggle toggle;
    TextView txtXemAllNew,txtXemallHot,txtXemAllTop10,txtXemallFree,txtXemallDeXuat;
    NavigationView danhmuc;
    BottomNavigationView menu_bar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_home_page,container,false);

         LinkView();
         initData();
         loadData();
         addEvent();

        return view;
    }

    private void LinkView() {
        //linkView
        banner_page=view.findViewById(R.id.banner_page);
        indicator=view.findViewById(R.id.indicator);
        rcvSachMoiNhat=view.findViewById(R.id.rcvSachMoiNhat);
        rcvSachHotNhat=view.findViewById(R.id.rcvTopHot);
        rcvTop10=view.findViewById(R.id.rcvTop10);
        rcvBookFree=view.findViewById(R.id.rcvFree);
        rcvDeXuat=view.findViewById(R.id.rcvDeXuat);

        imvVip=view.findViewById(R.id.imvVip);
        imvCart=view.findViewById(R.id.imvCart);

        edtSearch=view.findViewById(R.id.edtSearch);

        txtXemAllNew=view.findViewById(R.id.txtXemAllNew);
        txtXemAllTop10=view.findViewById(R.id.txtXemAllTop10);
        txtXemallHot=view.findViewById(R.id.txtXemallHot);
        txtXemallDeXuat=view.findViewById(R.id.txtXemallDeXuat);
        txtXemallFree=view.findViewById(R.id.txtXemallFree);

    }

    private void initData() {
        //Banner
        list_banner= new ArrayList<>();
        list_banner.add(new Banner(R.drawable.banner2));
        list_banner.add(new Banner(R.drawable.banner1));
        list_banner.add(new Banner(R.drawable.banner3));
        list_banner.add(new Banner(R.drawable.banne4));
        list_banner.add(new Banner(R.drawable.banner5));
        BannerAdapter adapter= new BannerAdapter(list_banner);
        banner_page.setAdapter(adapter);
        // set timer
//        Timer timer=new Timer();
//        timer.scheduleAtFixedRate(new BannerTimer(),2000,4000);
//        indicator.setupWithViewPager(banner_page,true);


        //List s??ch m???i nh???t
        List<Book> list_book1= new ArrayList<>();
        list_book1.add(new Book("?????c nh??n t??m","Dale Carnegie","320","15,000","45,000","First News - Tr?? Vi???t","2016-03-18","B??a c???ng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dacnhantam,R.string.dat_nhan_tam));
        list_book1.add(new Book("D???t T??nh","V?? Tr???ng Ph???ng","162","15,000","45,000","NXB V??n H???c","2016-03-18","B??a c???ng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh));
        list_book1.add(new Book("L??o H???c","Nam Cao","208","15,000","35,000","Nh?? Xu???t B???n D??n Tr??","2021","B??a m???m","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac));
        list_book1.add(new Book("Nh???ng quy t???c t?? duy"," Richard Templar","336","45,000","129,000 ","Nh?? Xu???t B???n Lao ?????ng","21/08/2021","B??a m???m","15 x 23 cm",R.string.sach_moi,R.drawable.nhungquytactuduy,R.string.nhung_quy_tac_tu_duy));

        BookAdapterHorizontalFragment adapter1= new BookAdapterHorizontalFragment(list_book1,this);
        rcvSachMoiNhat.setAdapter(adapter1);
        rcvSachMoiNhat.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));

        //List s??ch hot nh???t
        List<Book> list_book2= new ArrayList<>();
        list_book2.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nh?? Xu???t B???n Th??? Gi???i","2021-07-14 11:36:27","B??a m???m","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        list_book2.add(new Book("Sinh tr???c v??n tay","RICHARD UNGER","444","85,000","183,000 ","Nh?? Xu???t B???n H???ng ?????c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        list_book2.add(new Book("B???m ?????t gi?? bao nhi??u","V??n T??nh","320","45,000","119,000","NXB V??n H???c","2018-08-01","B??a m???m","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        list_book2.add(new Book("Gia t???c Morgan","Ron Chernow","1092","65,000","279,000"," NXB Th??? Gi???i","30/09/2021","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));

        BookAdapterHorizontalFragment adapter2= new BookAdapterHorizontalFragment(list_book2,this);
        rcvSachHotNhat.setAdapter(adapter2);
        rcvSachHotNhat.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));

        //List x???p h??ng
        List<Book> list_book3= new ArrayList<>();
        list_book3.add(new Book("Becoming"," Michelle Obama","448","35,000","579.000","Penguin Books","2021-07-14 11:36:27","Hardback","242 x 164 x 42 mm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.sapiens));
        list_book3.add(new Book("Kh??ng gia ????nh","Hector Malot","582","45,000","168,210","NXB V??n H???c","14/01/2016","B??a m???m","16 x 24 cm",R.string.sach_moi,R.drawable.khonggiadinh,R.string.khong_gia_dinh));
        list_book3.add(new Book("Ch??u ??u c?? g?? l??? kh??ng em?","Misa Gjone","192","15,000","69,000","Saigon Books","15/10/2019","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.chauaucogilakhongem,R.string.chau_au_co_gi_la_khong_em));

        BookAdapterHorizontalFragment adapter3= new BookAdapterHorizontalFragment(list_book3,this);
        rcvTop10.setAdapter(adapter3);
        rcvTop10.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));

        //List Free
        List<Book> list_book4= new ArrayList<>();
        list_book4.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nh?? Xu???t B???n Th??? Gi???i","2021-07-14 11:36:27","B??a m???m","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        list_book4.add(new Book("Sinh tr???c v??n tay","RICHARD UNGER","444","85,000","183,000 ","Nh?? Xu???t B???n H???ng ?????c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        list_book4.add(new Book("B???m ?????t gi?? bao nhi??u","V??n T??nh","320","45,000","119,000","NXB V??n H???c","2018-08-01","B??a m???m","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        list_book4.add(new Book("Gia t???c Morgan","Ron Chernow","1092","65,000","279,000"," NXB Th??? Gi???i","30/09/2021","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));

        BookAdapterHorizontalFragment adapter4= new BookAdapterHorizontalFragment(list_book4,this);
        rcvBookFree.setAdapter(adapter4);
        rcvBookFree.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));

        //List s??ch ????? xu???t
        List<Book> list_book5= new ArrayList<>();
        list_book5.add(new Book("Ba ??i, m??nh ??i ????u?","Jean-Louis Fournier","178","15,000","51,000","H???i nh?? v??n","25-11-2019","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the));
        list_book5.add(new Book("Khi H??i Th??? H??a Thinh Kh??ng"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong));
        list_book5.add(new Book("????p ??n C???a Th???i Gian","L?? T?? H???o","312","20,000","77,000","Nh?? Xu???t B???n Ph??? N??? Vi???t Nam","2021-02-01","B??a m???m","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian));
        list_book5.add(new Book("B???n M??a Cu???c S???ng","Jim Rohn","164","25,000","75,000","Th??i H??","2018-05-07","B??a m???m","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song));

        BookAdapterHorizontalFragment adapter5= new BookAdapterHorizontalFragment(list_book5,this);
        rcvDeXuat.setAdapter(adapter5);
        rcvDeXuat.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));

    }

    private void loadData() {
        // thanh danh m???c
        Toolbar toolbar=(Toolbar) view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menu_bar=(BottomNavigationView) view.findViewById(R.id.menu_bar);
        drawerLayout=(DrawerLayout) view.findViewById(R.id.drawDanhmuc);
        danhmuc=(NavigationView) view.findViewById(R.id.danhmuc);
        toggle=new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        danhmuc.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bangxephang:
                        Intent intent0=new Intent(getActivity(),BangXepHang.class);
                        startActivity(intent0);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.tieuthuyet:
                        Intent intent=new Intent(getActivity(),BookListCatogoryActivity.class);
                        intent.putExtra(Constant.CATEGORY,"Ti???u thuy???t");
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.truyenngan:
                        Intent intent1 =new Intent(getActivity(),BookListCatogoryActivity.class);
                        intent1.putExtra(Constant.CATEGORY,"Truy???n ng???n");
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.trinhtham:
                        Intent intent2 =new Intent(getActivity(),BookListCatogoryActivity.class);
                        intent2.putExtra(Constant.CATEGORY,"Trinh th??m");
                        startActivity(intent2);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.giatuong:
                        Intent intent3 =new Intent(getActivity(),BookListCatogoryActivity.class);
                        intent3.putExtra(Constant.CATEGORY,"Gi??? t?????ng");
                        startActivity(intent3);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.kinhdoanh:
                        Intent intent4 =new Intent(getActivity(),BookListCatogoryActivity.class);
                        intent4.putExtra(Constant.CATEGORY,"Kinh doanh");
                        startActivity(intent4);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.kynang:
                        Intent intent5 =new Intent(getActivity(),BookListCatogoryActivity.class);
                        intent5.putExtra(Constant.CATEGORY,"K??? n??ng");
                        startActivity(intent5);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.tamly:
                        Intent intent6 =new Intent(getActivity(),BookListCatogoryActivity.class);
                        intent6.putExtra(Constant.CATEGORY,"T??m l??");
                        startActivity(intent6);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.giaoduc:
                        Intent intent7 =new Intent(getActivity(),BookListCatogoryActivity.class);
                        intent7.putExtra(Constant.CATEGORY,"Gi??o d???c");
                        startActivity(intent7);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.tacgia:
                        Intent intent8 =new Intent(getActivity(),ListAuthorActivity.class);
                        startActivity(intent8);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });

    }

    private void addEvent() {
        imvVip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),VipActivity.class);
                startActivity(intent);
            }
        });
        imvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),CartActivity.class);
                startActivity(intent);
            }
        });

        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });
        txtXemAllNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),BookListCatogoryActivity.class);
                intent.putExtra(Constant.CATEGORY,"S??ch m???i");
                startActivity(intent);
            }
        });
        txtXemallDeXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),BookListCatogoryActivity.class);
                intent.putExtra(Constant.CATEGORY,"S??ch ????? xu???t");
                startActivity(intent);
            }
        });
        txtXemallFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),BookListCatogoryActivity.class);
                intent.putExtra(Constant.CATEGORY,"S??ch mi???n ph??");
                startActivity(intent);
            }
        });
        txtXemallHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),BookListCatogoryActivity.class);
                intent.putExtra(Constant.CATEGORY,"S??ch Hot");
                startActivity(intent);
            }
        });
        txtXemAllTop10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),BangXepHang.class);
                startActivity(intent);
            }
        });
    }



    private void setSupportActionBar(Toolbar toolbar) {

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(getActivity(),DetailBookActivity.class);
        intent.putExtra(Constant.BOOK_NAME,book.getBookName());
        intent.putExtra(Constant.BOOK_SUMMARY,book.getBookSummary());
        intent.putExtra(Constant.BOOK_IMAGE,book.getBookImage());
        intent.putExtra(Constant.BOOK_AUTHOR,book.getBookAuthor());
        intent.putExtra(Constant.BOOK_PAGE,book.getBookPage());
        intent.putExtra(Constant.BOOK_E_PRICE,book.getEbookPrice());
        intent.putExtra(Constant.BOOK_PRICE,book.getBookPrice());
        intent.putExtra(Constant.BOOK_PUBLISHER,book.getBookPublisher());
        intent.putExtra(Constant.BOOK_DATETIME,book.getDateTime());
        intent.putExtra(Constant.BOOK_LOAI_BIA,book.getLoaiBia());
        intent.putExtra(Constant.BOOK_SIZE,book.getBookSize());
//        startActivity(intent);
        //Animation
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(getActivity(), bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }


//    class  BannerTimer extends TimerTask {
//
//        @Override
//        public void run() {
//            getActivity().runOnUiThread(new Runnable() {
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
