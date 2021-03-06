package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
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
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchActivity extends AppCompatActivity implements BookItemClickListener, AuthorItemClickListener {
    RecyclerView rcvItemBook;
    Search_BookList_Adapter adapter;
    ImageView imvHinh, imvBackSearch;
    CircleImageView imvTacGiaImage;
    TextView txtName, txtTacGia, txtTacGiaView;
    SearchView svSearch;
    EditText edtSearch;
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
        addEvents();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }


    private void linkViews() {
        imvHinh = findViewById(R.id.imvHinh);
        imvTacGiaImage = findViewById(R.id.imvTacGiaImage);
        imvBackSearch=findViewById(R.id.imvBackSearch);
        txtName = findViewById(R.id.txtName);
        txtTacGia = findViewById(R.id.txtTacGia);
        txtTacGiaView = findViewById(R.id.txtTacGiaView);
        rcvItemBook = findViewById(R.id.rcvBookItem);
        rcvTacGia = findViewById(R.id.rcvTacGia);
        edtSearch=findViewById(R.id.edtSearch);

    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvTacGia.setLayoutManager(manager);
    }

    private void initData() {
        books = new ArrayList<>();
        books.add(new Book("Ba ??i, m??nh ??i ????u?","Jean-Louis Fournier","178","15,000","51,000","H???i nh?? v??n","25-11-2019","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the));
        books.add(new Book("Khi H??i Th??? H??a Thinh Kh??ng"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong));
        books.add(new Book("????p ??n C???a Th???i Gian","L?? T?? H???o","312","20,000","77,000","Nh?? Xu???t B???n Ph??? N??? Vi???t Nam","2021-02-01","B??a m???m","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian));
        books.add(new Book("B???n M??a Cu???c S???ng","Jim Rohn","164","25,000","75,000","Th??i H??","2018-05-07","B??a m???m","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song));
        books.add(new Book("?????c nh??n t??m","Dale Carnegie","320","15,000","45,000","First News - Tr?? Vi???t","2016-03-18","B??a c???ng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dacnhantam,R.string.dat_nhan_tam));
        books.add(new Book("D???t T??nh","V?? Tr???ng Ph???ng","162","15,000","45,000","NXB V??n H???c","2016-03-18","B??a c???ng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh));
        adapter = new Search_BookList_Adapter(this, books,this);
        rcvItemBook.setAdapter(adapter);
        rcvItemBook.setLayoutManager(new GridLayoutManager(this,2));


        authors = new ArrayList<>();
        authors.add(new Author("J.K.Rowling","V????ng qu???c Li??n hi???p Anh v?? B???c Ireland","6","31/07/1965","Kh??ng", R.drawable.jkrowling, "L?? m???t nh?? v??n, nh?? t??? thi???n, nh?? s???n xu???t phim v?? truy???n h??nh, nh?? bi??n k???ch ng?????i Anh. B?? n???i ti???ng l?? t??c gi??? c???a b??? truy???n gi??? t?????ng Harry Potter t???ng ??o???t nhi???u gi???i th?????ng v?? b??n ???????c h??n 500 tri???u b???n"));
        authors.add(new Author("Nam Cao","X?? H??a H???u, huy???n L?? Nh??n, H?? Nam","23","29/10/1915","30/11/1951", R.drawable.namcao, "L?? m???t nh?? v??n v?? c??ng l?? m???t chi???n s??, li???t s?? ng?????i Vi???t Nam. ??ng l?? nh?? v??n hi???n th???c l???n (tr?????c C??ch m???ng Th??ng T??m), m???t nh?? b??o kh??ng chi???n (sau C??ch m???ng), m???t trong nh???ng nh?? v??n ti??u bi???u nh???t th??? k??? 20. Nam Cao c?? nhi???u ????ng g??p quan tr???ng ?????i v???i vi???c ho??n thi???n phong c??ch truy???n ng???n v?? ti???u thuy???t Vi???t Nam ??? n???a ?????u th??? k??? 20."));
        authors.add(new Author("T?? Ho??i","H?? N???i, Vi???t Nam","6","27/09/1920","06/07/2014", R.drawable.tohoai, "M???t trong s??? nh???ng g????ng m???t ti??u bi???u T?? Ho??i ??? nh?? v??n xu???t s???c trong n???n v??n h???c Vi???t Nam hi???n ?????i."));
        authors.add(new Author("Paulo Coelho","Rio de Janeiro, Brasil","6","24/08/1947","Kh??ng", R.drawable.paulocoel, "??ng m???i b???t ?????u vi???t khi 40 tu???i v?? xu???t b???n cu???n s??ch ?????u ti??n, Paulo Coelho ???????c xem l?? nh?? v??n c?? nhi???u ng?????i ?????c nh???t th??? gi???i."));
        authors.add(new Author("Nguy???n Nh???t ??nh","B??nh Qu???, Th??ng B??nh, Qu???ng Nam","40","07/05/1955","Kh??ng", R.drawable.nguyennhatanh, "L?? m???t nh?? v??n ng?????i Vi???t Nam, n???i ti???ng nh??? c??c t??c ph???m v??? ????? t??i tu???i m???i l???n, c??c t??c ph???m c???a ??ng ???????c nhi???u ng?????i y??u th??ch v?? nhi???u t??c ph???m ???????c chuy???n th??nh th??? phim"));
        authorSearchAdapter = new AuthorSearchAdapter(this, authors, this);
        rcvTacGia.setAdapter(authorSearchAdapter);
    }



    private void addEvents() {

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
                authorSearchAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        imvBackSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
        intent.putExtra(Constant.AUTHOR_NAME, author.getAuthorName());
        intent.putExtra(Constant.PLACE_OF_BIRTH, author.getAuthorPlaceOfBirth());
        intent.putExtra(Constant.TOTAL_BOOK, author.getAuthorTotalBook());
        intent.putExtra(Constant.AUTHOR_BIRTH, author.getAuthorBirth());
        intent.putExtra(Constant.AUTHOR_DEADTH, author.getAuthorDeath());
        intent.putExtra(Constant.AUTHOR_IMAGE, author.getAuthorImage());
        intent.putExtra(Constant.AUTHOR_SUMMARY, author.getAuthorSummary());
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SearchActivity.this, authorImage,"sharedName");
        startActivity(intent,options.toBundle());
    }


}