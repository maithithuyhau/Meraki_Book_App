package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.AuthorSearchAdapter;
import com.example.adapter.BookAdapterHorizontal;
import com.example.adapter.Search_BookList_Adapter;
import com.example.model.AuthorItemClickListener;
import com.example.model.Book;
import com.example.model.Author;
import com.example.model.BookItemClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchActivity extends AppCompatActivity implements BookItemClickListener, AuthorItemClickListener {
    RecyclerView rcvItemBook;
    Search_BookList_Adapter adapter;
    ImageView imvHinh;
    CircleImageView imvTacGiaImage;
    TextView txtName, txtTacGia, txtTacGiaView;
    RecyclerView rcvTacGia;
    ArrayList<Book> books;
    ArrayList<Author>authors;
    AuthorSearchAdapter authorSearchAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        linkViews();
        configRecyclerView();
        initData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }


    private void linkViews() {
        imvHinh = findViewById(R.id.imvHinh);
        imvTacGiaImage = findViewById(R.id.imvTacGiaImage);
        txtName = findViewById(R.id.txtName);
        txtTacGia = findViewById(R.id.txtTacGia);
        txtTacGiaView = findViewById(R.id.txtTacGiaView);
        rcvItemBook = findViewById(R.id.rcvBookItem);
        rcvTacGia = findViewById(R.id.rcvTacGia);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvTacGia.setLayoutManager(manager);
    }

    private void initData() {
        books = new ArrayList<>();
        books.add(new Book("Ba ơi, mình đi đâu?","Jean-Louis Fournier","178","15,000","51,000","Hội nhà văn","25-11-2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the));
        books.add(new Book("Khi Hơi Thở Hóa Thinh Không"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong));
        books.add(new Book("Đáp Án Của Thời Gian","Lư Tư Hạo","312","20,000","77,000","Nhà Xuất Bản Phụ Nữ Việt Nam","2021-02-01","Bìa mềm","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian));
        books.add(new Book("Bốn Mùa Cuộc Sống","Jim Rohn","164","25,000","75,000","Thái Hà","2018-05-07","Bìa mềm","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song));
        books.add(new Book("Đắc nhân tâm","Dale Carnegie","320","15,000","45,000","First News - Trí Việt","2016-03-18","Bìa cứng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.datnhantam,R.string.dat_nhan_tam));
        books.add(new Book("Dứt Tình","Vũ Trọng Phụng","162","15,000","45,000","NXB Văn Học","2016-03-18","Bìa cứng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh));

        adapter = new Search_BookList_Adapter(this, books,this);
        rcvItemBook.setAdapter(adapter);
        rcvItemBook.setLayoutManager(new GridLayoutManager(this,2));


        authors = new ArrayList<>();
        authors.add(new Author("J.K.Rowling","Vương quốc Liên hiệp Anh và Bắc Ireland","6","31/07/1965","Không", R.drawable.jkrowling, "Là một nhà văn, nhà từ thiện, nhà sản xuất phim và truyền hình, nhà biên kịch người Anh. Bà nổi tiếng là tác giả của bộ truyện giả tưởng Harry Potter từng đoạt nhiều giải thưởng và bán được hơn 500 triệu bản"));
        authors.add(new Author("Nam Cao","Xã Hòa Hậu, huyện Lý Nhân, Hà Nam","23","29/10/1915","30/11/1951", R.drawable.namcao, "Là một nhà văn và cũng là một chiến sĩ, liệt sĩ người Việt Nam. Ông là nhà văn hiện thực lớn (trước Cách mạng Tháng Tám), một nhà báo kháng chiến (sau Cách mạng), một trong những nhà văn tiêu biểu nhất thế kỷ 20. Nam Cao có nhiều đóng góp quan trọng đối với việc hoàn thiện phong cách truyện ngắn và tiểu thuyết Việt Nam ở nửa đầu thế kỷ 20."));
        authors.add(new Author("Tô Hoài","Hà Nội, Việt Nam","6","27/09/1920","06/07/2014", R.drawable.tohoai, "Một trong số những gương mặt tiêu biểu Tô Hoài – nhà văn xuất sắc trong nền văn học Việt Nam hiện đại."));
        authors.add(new Author("Paulo Coelho","Rio de Janeiro, Brasil","6","24/08/1947","Không", R.drawable.paulocoel, "Ông mới bắt đầu viết khi 40 tuổi và xuất bản cuốn sách đầu tiên, Paulo Coelho được xem là nhà văn có nhiều người đọc nhất thế giới."));
        authors.add(new Author("Nguyễn Nhật Ánh","Bình Quế, Thăng Bình, Quảng Nam","40","07/05/1955","Không", R.drawable.nguyennhatanh, "Là một nhà văn người Việt Nam, nổi tiếng nhờ các tác phẩm về đề tài tuổi mới lớn, các tác phẩm của ông được nhiều người yêu thích và nhiều tác phẩm được chuyển thành thể phim"));
        authorSearchAdapter = new AuthorSearchAdapter(this, authors, this);
        rcvTacGia.setAdapter(authorSearchAdapter);
    }



    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent = new Intent(SearchActivity. this,DetailBookActivity.class);
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
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SearchActivity.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }

    @Override
    public void onAuthorClick(Author author, CircleImageView authorImage) {
        Intent intent = new Intent(SearchActivity. this, Authors.class);
        intent.putExtra("AuthorName", author.getAuthorName());

        intent.putExtra("PlaceOfBirth", author.getAuthorPlaceOfBirth());
        intent.putExtra("TotalBook", author.getAuthorTotalBook());
        intent.putExtra("AuthorBirth", author.getAuthorBirth());
        intent.putExtra("AuthorDeath", author.getAuthorDeath());
        intent.putExtra("AuthorImage", author.getAuthorImage());
        intent.putExtra("AuthorSummary", author.getAuthorSummary());
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SearchActivity.this, authorImage,"sharedName");
        startActivity(intent,options.toBundle());
    }
}