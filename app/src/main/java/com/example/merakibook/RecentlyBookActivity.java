package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
import com.example.utils.Constant;

import java.util.ArrayList;

public class RecentlyBookActivity extends AppCompatActivity implements BookItemClickListener {

    View view;
    RecyclerView rcvRecentlyBook;
    ArrayList<Book> myRecentlyBook;
    BookAdapterVerticalFragment bookAdapterVertical;
    ImageView imvBackRecently;
    androidx.appcompat.widget.SearchView searchViewRecently;

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
        imvBackRecently = findViewById(R.id.imvBackRecently);
        searchViewRecently = findViewById(R.id.actionSearchRecently);
    }

    private void initData() {
        myRecentlyBook = new ArrayList<>();
        myRecentlyBook.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nh?? Xu???t B???n Th??? Gi???i","2021-07-14 11:36:27","B??a m???m","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        myRecentlyBook.add(new Book("Sinh tr???c v??n tay","RICHARD UNGER","444","85,000","183,000 ","Nh?? Xu???t B???n H???ng ?????c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        myRecentlyBook.add(new Book("B???m ?????t gi?? bao nhi??u","V??n T??nh","320","45,000","119,000","NXB V??n H???c","2018-08-01","B??a m???m","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        myRecentlyBook.add(new Book("Gia t???c Morgan","Ron Chernow","1092","65,000","279,000"," NXB Th??? Gi???i","30/09/2021","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));

    }

    private void addEvent() {
        imvBackRecently.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        searchViewRecently.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                bookAdapterVertical.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                bookAdapterVertical.getFilter().filter(newText);
                return false;
            }
        });
    }
    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(RecentlyBookActivity.this, DetailBookActivity.class);
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

        //Animation
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(RecentlyBookActivity.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }
}