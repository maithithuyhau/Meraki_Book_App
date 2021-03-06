package com.example.merakibook;

//import android.content.Context;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.BookAdapterVertical;
import com.example.adapter.BookAdapterVerticalFragment;
import com.example.model.Book;
import com.example.model.BookItemClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;

public class BooksOfAuthorActivity extends AppCompatActivity implements BookItemClickListener {

    RecyclerView rcvBooksOfAuthor;
    ArrayList<Book> myBook;
    BookAdapterVertical bookAdapterVertical;
    SearchView searchView;
    ImageView imvBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_of_author);

        linkView();
        addEvent();
        initData();
    }


    private void linkView() {
        imvBack=findViewById(R.id.imvBack);
        rcvBooksOfAuthor = findViewById(R.id.rcvBooksOfAuthor);
        searchView=findViewById(R.id.actionSearch);
    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

    private void initData() {
        myBook = new ArrayList<>();
        myBook.add(new Book("L??o H???c","Nam Cao","150","15,000","45,000","Nh?? Xu???t B???n V??n H???c","2021-07-14 11:36:27","B??a m???m","13 x 20.5 cm",R.string.sach_moi,R.drawable.laohac,R.string.sapiens));
        myBook.add(new Book("S???ng m??n","Nam Cao","170","25,000","83,000 ","Nh?? Xu???t B???n V??n H???c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.songmon,R.string.sinh_trac_van_tay));
        myBook.add(new Book("Ch?? Ph??o","Nam Cao","190","35,000","113,000 ","Nh?? Xu???t B???n V??n H???c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.chipheo,R.string.sinh_trac_van_tay));
        myBook.add(new Book("?????i th???a","Nam Cao","150","25,000","65,000","Nh?? Xu???t B???n V??n H???c","2021-07-14 11:36:27","B??a m???m","13 x 20.5 cm",R.string.sach_moi,R.drawable.doithua,R.string.sapiens));
        myBook.add(new Book("????i m???t","Nam Cao","170","25,000","50,000 ","Nh?? Xu???t B???n V??n H???c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.doimat,R.string.sinh_trac_van_tay));
        myBook.add(new Book("Gi??ng s??ng","Nam Cao","190","30,000","75,000 ","Nh?? Xu???t B???n V??n H???c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.giangsang,R.string.sinh_trac_van_tay));

        bookAdapterVertical = new BookAdapterVertical(this,myBook,this);
        rcvBooksOfAuthor.setLayoutManager(new LinearLayoutManager(this));
        rcvBooksOfAuthor.setAdapter(bookAdapterVertical);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
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
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(BooksOfAuthorActivity.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }

}
