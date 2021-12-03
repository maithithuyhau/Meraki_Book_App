package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.adapter.BookAdapterVertical;
import com.example.model.Book;
import com.example.model.BookItemClickListener;

import java.util.ArrayList;

public abstract class RecentlyBookActivity extends AppCompatActivity implements BookItemClickListener {

    View view;
    RecyclerView rcvRecentlyBook;
    ArrayList<Book> myRecentlyBook;
    BookAdapterVertical bookAdapterVertical;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recently_book);

        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVertical(this,myRecentlyBook,this);
        rcvRecentlyBook.setLayoutManager(new LinearLayoutManager(this));
        rcvRecentlyBook.setAdapter(bookAdapterVertical);

    }

    private void linkView() {
        rcvRecentlyBook =findViewById(R.id.rcvRecentlyBook);
    }

    private void initData() {
        myRecentlyBook = new ArrayList<>();
        myRecentlyBook.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        myRecentlyBook.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        myRecentlyBook.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        myRecentlyBook.add(new Book("Gia tộc Morgan","Ron Chernow","1092","65,000","279,000"," NXB Thế Giới","30/09/2021","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));

    }
    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }
}