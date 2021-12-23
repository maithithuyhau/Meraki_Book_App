package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.adapter.BookAdapterVertical;
import com.example.adapter.BookAdapterVerticalFragment;
import com.example.model.Book;
import com.example.model.BookItemClickListener;

import java.util.ArrayList;

public class RecentlyBookActivity extends AppCompatActivity implements BookItemClickListener {

    View view;
    RecyclerView rcvRecentlyBook;
    ArrayList<Book> myRecentlyBook;
    BookAdapterVerticalFragment bookAdapterVertical;
    ImageButton imbBackRecently;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recently_book);

        linkView();
        initData();
        addEvent();

        bookAdapterVertical = new BookAdapterVerticalFragment(myRecentlyBook,this);
        rcvRecentlyBook.setLayoutManager(new LinearLayoutManager(this));
        rcvRecentlyBook.setAdapter(bookAdapterVertical);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    private void linkView() {
        rcvRecentlyBook =findViewById(R.id.rcvRecentlyBook);
        imbBackRecently = findViewById(R.id.imbBackRecently);
    }

    private void initData() {
        myRecentlyBook = new ArrayList<>();
        myRecentlyBook.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        myRecentlyBook.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        myRecentlyBook.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        myRecentlyBook.add(new Book("Gia tộc Morgan","Ron Chernow","1092","65,000","279,000"," NXB Thế Giới","30/09/2021","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));

    }

    private void addEvent() {
        imbBackRecently.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(RecentlyBookActivity.this, DetailBookActivity.class);
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
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(RecentlyBookActivity.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }
}