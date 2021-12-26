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
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.adapter.BookAdapterHorizontal;
import com.example.adapter.BookAdapterVertical;
import com.example.model.Author;
import com.example.model.AuthorItemClickListener;
import com.example.model.Book;
import com.example.model.BookItemClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Authors extends AppCompatActivity implements BookItemClickListener, AuthorItemClickListener {
    private TextView txtTenTacGia1, txtTenTacGia2, txtNamSinh, txtNamMat, txtSoLuongTacPham, txtQueQuan, txtTomTat, txtXemTatCa;
    private CircleImageView imvAuthor;
    private RecyclerView rcvCacTacPham;
    ImageView imvBack;
    ArrayList<Book> myBook;
    BookAdapterHorizontal bookAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors);

        linkViews();
        loadData();
        addEvent();
        intiData();

    }


    private void linkViews() {
        txtTenTacGia1=findViewById(R.id.txtTenTacGia1);
        txtTenTacGia2=findViewById(R.id.txtTenTacGia2);
        txtNamSinh=findViewById(R.id.txtNamSinh);
        txtNamMat=findViewById(R.id.txtNamMat);
        txtQueQuan=findViewById(R.id.txtQueQuan);
        txtSoLuongTacPham=findViewById(R.id.txtSoLuongTacPham);
        txtTomTat=findViewById(R.id.txtTomTat);
        txtXemTatCa=findViewById(R.id.txtXemTatCa);

        rcvCacTacPham=findViewById(R.id.rcvCacTacPham);

        imvAuthor=findViewById(R.id.imvAuthor);
        imvBack=findViewById(R.id.imvBack);

    }

    private void intiData() {
        myBook = new ArrayList<>();
        myBook.add(new Book("Lão Hạc","Nam Cao","150","15,000","45,000","Nhà Xuất Bản Văn Học","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.laohac,R.string.sapiens));
        myBook.add(new Book("Sống mòn","Nam Cao","170","25,000","83,000 ","Nhà Xuất Bản Văn Học","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.songmon,R.string.sinh_trac_van_tay));
        myBook.add(new Book("Chí Phèo","Nam Cao","190","35,000","113,000 ","Nhà Xuất Bản Văn Học","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.chipheo,R.string.sinh_trac_van_tay));
        myBook.add(new Book("Đời thừa","Nam Cao","150","25,000","65,000","Nhà Xuất Bản Văn Học","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.doithua,R.string.sapiens));
        myBook.add(new Book("Đôi mắt","Nam Cao","170","25,000","50,000 ","Nhà Xuất Bản Văn Học","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.doimat,R.string.sinh_trac_van_tay));
        myBook.add(new Book("Giăng sáng","Nam Cao","190","30,000","75,000 ","Nhà Xuất Bản Văn Học","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.giangsang,R.string.sinh_trac_van_tay));

        bookAdapter= new BookAdapterHorizontal(this,myBook,this);
        rcvCacTacPham.setAdapter(bookAdapter);
        rcvCacTacPham.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        txtXemTatCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Authors.this, BooksOfAuthorActivity.class);
                startActivity(intent);
            }
        });

    }

    private void loadData() {
        Intent intent= getIntent();
        String authorName=intent.getExtras().getString(Constant.AUTHOR_NAME);
        String authorPlaceOfBirth= intent.getExtras().getString(Constant.PLACE_OF_BIRTH);
        String authorBirth=intent.getExtras().getString(Constant.AUTHOR_BIRTH);
        String authorDeath= intent.getExtras().getString(Constant.AUTHOR_DEADTH);
        String authorTotalBook= intent.getExtras().getString(Constant.TOTAL_BOOK);

        String authorSummary= intent.getExtras().getString(Constant.AUTHOR_SUMMARY);
        int authorImage =intent.getExtras().getInt(Constant.AUTHOR_IMAGE);

        imvAuthor.setImageResource(authorImage);

        txtTenTacGia1.setText(authorName);
        txtTenTacGia2.setText(authorName);
        txtNamSinh.setText(authorBirth);
        txtNamMat.setText(authorDeath);
        txtQueQuan.setText(authorPlaceOfBirth);
        txtSoLuongTacPham.setText(authorTotalBook);
        txtTomTat.setText(authorSummary);
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
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Authors.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }

    @Override
    public void onAuthorClick(Author author, CircleImageView authorImage) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}