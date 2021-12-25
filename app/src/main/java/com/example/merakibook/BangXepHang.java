package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.BookAdapterHorizontal;
import com.example.model.Book;
import com.example.model.BookItemClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class BangXepHang extends AppCompatActivity implements BookItemClickListener {
        RecyclerView rcvTopTuan, rcvTopThang, rcvBanChay;
        ImageView imvBack;
        TextView txtXemallTuan,txtXemAllTopThang,txtXemallBanChay;
        SearchView searchView;
        BookAdapterHorizontal adapter1,adapter2,adapter3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_xep_hang);

        linkView();
        initData();
        addEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    private void linkView() {
        rcvBanChay=findViewById(R.id.rcvBanChay);
        rcvTopThang=findViewById(R.id.rcvTopThang);
        rcvTopTuan=findViewById(R.id.rcvTopTuan);

        txtXemallBanChay=findViewById(R.id.txtXemallBanChay);
        txtXemallTuan=findViewById(R.id.txtXemallTuan);
        txtXemAllTopThang=findViewById(R.id.txtXemAllTopThang);

        imvBack=findViewById(R.id.imvBack);

        searchView=findViewById(R.id.actionSearch);


    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        txtXemAllTopThang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BangXepHang.this,BookListCatogoryActivity.class);
                intent.putExtra(Constant.CATEGORY,"Top Tháng");
                startActivity(intent);
            }
        });
        txtXemallTuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BangXepHang.this,BookListCatogoryActivity.class);
                intent.putExtra(Constant.CATEGORY,"Top Tuần");
                startActivity(intent);
            }
        });
        txtXemallBanChay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BangXepHang.this,BookListCatogoryActivity.class);
                intent.putExtra(Constant.CATEGORY,"Sách bán chạy");
                startActivity(intent);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter1.getFilter().filter(query);
                adapter2.getFilter().filter(query);
                adapter3.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter1.getFilter().filter(newText);
                adapter2.getFilter().filter(newText);
                adapter3.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void initData() {
        //sách top tuần
        List<Book> list_book1= new ArrayList<>();
        list_book1.add(new Book("Đắc nhân tâm","Dale Carnegie","320","15,000","45,000","First News - Trí Việt","2016-03-18","Bìa cứng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.datnhantam,R.string.dat_nhan_tam));
        list_book1.add(new Book("Dứt Tình","Vũ Trọng Phụng","162","15,000","45,000","NXB Văn Học","2016-03-18","Bìa cứng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh));
        list_book1.add(new Book("Lão Hạc","Nam Cao","208","15,000","35,000","Nhà Xuất Bản Dân Trí","2021","Bìa mềm","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac));
        list_book1.add(new Book("Những quy tắc tư duy"," Richard Templar","336","45,000","129,000 ","Nhà Xuất Bản Lao Động","21/08/2021","Bìa mềm","15 x 23 cm",R.string.sach_moi,R.drawable.nhungquytactuduy,R.string.nhung_quy_tac_tu_duy));

        adapter1= new BookAdapterHorizontal(this,list_book1,this);
        rcvTopTuan.setAdapter(adapter1);
        rcvTopTuan.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        // Sách Top tháng
        List<Book> list_book2= new ArrayList<>();
        list_book2.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        list_book2.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        list_book2.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        list_book2.add(new Book("Gia tộc Morgan","Ron Chernow","1092","65,000","279,000"," NXB Thế Giới","30/09/2021","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));

        adapter2=new BookAdapterHorizontal(this, list_book2,this);
        rcvTopThang.setAdapter(adapter2);
        rcvTopThang.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        //sách nên đọc
        List<Book> list_book3= new ArrayList<>();
        list_book3.add(new Book("Becoming"," Michelle Obama","448","35,000","579.000","Penguin Books","2021-07-14 11:36:27","Hardback","242 x 164 x 42 mm",R.string.sach_moi,R.drawable.becoming,R.string.sapiens));
        list_book3.add(new Book("Không gia đình","Hector Malot","582","45,000","168,210","NXB Văn Học","14/01/2016","Bìa mềm","16 x 24 cm",R.string.sach_moi,R.drawable.khonggiadinh,R.string.khong_gia_dinh));
        list_book3.add(new Book("Châu Âu có gì lạ không em?","Misa Gjone","192","15,000","69,000","Saigon Books","15/10/2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.chauaucogilakhongem,R.string.chau_au_co_gi_la_khong_em));
        adapter3=new BookAdapterHorizontal(this, list_book3,this);
        rcvBanChay.setAdapter(adapter3);
        rcvBanChay.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(this, DetailBookActivity.class);
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
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(BangXepHang.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }


}