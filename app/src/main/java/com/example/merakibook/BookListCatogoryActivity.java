package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.adapter.BookAdapterHorizontal;
import com.example.model.Book;
import com.example.model.BookItemClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class BookListCatogoryActivity extends AppCompatActivity implements BookItemClickListener {

    ImageView imvBackAllBook;
    //Spinner
    Spinner spSort;
    ArrayList<String> listSort;
    ArrayAdapter<CharSequence> adapter;

    //List book
    ArrayList<Book> books;
    BookAdapterHorizontal bookAdapterHorizontal;
    int item_book_layout;
    RecyclerView rcvListBookCategory;
    TextView txtCategory;
    androidx.appcompat.widget.SearchView searchViewAllBook;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_catogory);

        linkView();
        addEvent();
        loadData();
        addSortList();
        configRecyclerView();
        addEventSpinner();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    private void linkView() {
        spSort = findViewById(R.id.spSort);
        rcvListBookCategory = findViewById(R.id.rcvListBookCategory);
        txtCategory=findViewById(R.id.txtCategory);
        imvBackAllBook = findViewById(R.id.imvBackAllBook);
        searchViewAllBook = findViewById(R.id.actionSearchAllBook);
    }

    private void addEvent() {
        imvBackAllBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        searchViewAllBook.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                bookAdapterHorizontal.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                bookAdapterHorizontal.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void loadData() {
        Intent intent= getIntent();
        String name=intent.getExtras().getString(Constant.CATEGORY);
        txtCategory.setText(name);
    }

    private void addSortList() {
        adapter = ArrayAdapter.createFromResource(this, R.array.sp_sort, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSort.setAdapter(adapter);
    }

    private void addEventSpinner() {
        spSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        initData();
                        break;
                    case 1:
                        initDataNew();
                        break;
                    case 2:
                        initDataOld();
                        break;
                    case 3:
                        initDataBestSeller();
                        break;
                    case 4:
                        initDataFree();
                        break;
                    default:
                        initData();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void configRecyclerView() {
        rcvListBookCategory.setLayoutManager(new GridLayoutManager(this,3));
    }

    private void initData() {
        books = new ArrayList<>();
        books.add(new Book("Ba ??i, m??nh ??i ????u?","Jean-Louis Fournier","178","15,000","51,000","H???i nh?? v??n","25-11-2019","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the));
        books.add(new Book("Khi H??i Th??? H??a Thinh Kh??ng"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong));
        books.add(new Book("????p ??n C???a Th???i Gian","L?? T?? H???o","312","20,000","77,000","Nh?? Xu???t B???n Ph??? N??? Vi???t Nam","2021-02-01","B??a m???m","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian));
        books.add(new Book("B???n M??a Cu???c S???ng","Jim Rohn","164","25,000","75,000","Th??i H??","2018-05-07","B??a m???m","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song));
        books.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nh?? Xu???t B???n Th??? Gi???i","2021-07-14 11:36:27","B??a m???m","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        books.add(new Book("Sinh tr???c v??n tay","RICHARD UNGER","444","85,000","183,000 ","Nh?? Xu???t B???n H???ng ?????c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        books.add(new Book("B???m ?????t gi?? bao nhi??u","V??n T??nh","320","45,000","119,000","NXB V??n H???c","2018-08-01","B??a m???m","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        books.add(new Book("Gia t???c Morgan","Ron Chernow","1092","65,000","279,000"," NXB Th??? Gi???i","30/09/2021","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));
        books.add(new Book("Becoming"," Michelle Obama","448","35,000","579.000","Penguin Books","2021-07-14 11:36:27","Hardback","242 x 164 x 42 mm",R.string.sach_moi,R.drawable.becoming,R.string.sapiens));
        books.add(new Book("Kh??ng gia ????nh","Hector Malot","582","45,000","168,210","NXB V??n H???c","14/01/2016","B??a m???m","16 x 24 cm",R.string.sach_moi,R.drawable.khonggiadinh,R.string.khong_gia_dinh));
        books.add(new Book("Ch??u ??u c?? g?? l??? kh??ng em?","Misa Gjone","192","15,000","69,000","Saigon Books","15/10/2019","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.chauaucogilakhongem,R.string.chau_au_co_gi_la_khong_em));
        books.add(new Book("?????c nh??n t??m","Dale Carnegie","320","15,000","45,000","First News - Tr?? Vi???t","2016-03-18","B??a c???ng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dacnhantam,R.string.dat_nhan_tam));
        books.add(new Book("D???t T??nh","V?? Tr???ng Ph???ng","162","15,000","45,000","NXB V??n H???c","2016-03-18","B??a c???ng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh));
        books.add(new Book("L??o H???c","Nam Cao","208","15,000","35,000","Nh?? Xu???t B???n D??n Tr??","2021","B??a m???m","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac));
        books.add(new Book("Nh???ng quy t???c t?? duy"," Richard Templar","336","45,000","129,000 ","Nh?? Xu???t B???n Lao ?????ng","21/08/2021","B??a m???m","15 x 23 cm",R.string.sach_moi,R.drawable.nhungquytactuduy,R.string.nhung_quy_tac_tu_duy));

        bookAdapterHorizontal = new BookAdapterHorizontal(this,books, this);
        rcvListBookCategory.setAdapter(bookAdapterHorizontal);
    }
    private void initDataNew() {
        books = new ArrayList<>();
        books.add(new Book("Ba ??i, m??nh ??i ????u?","Jean-Louis Fournier","178","15,000","51,000","H???i nh?? v??n","25-11-2019","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the));
        books.add(new Book("Khi H??i Th??? H??a Thinh Kh??ng"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong));
        books.add(new Book("????p ??n C???a Th???i Gian","L?? T?? H???o","312","20,000","77,000","Nh?? Xu???t B???n Ph??? N??? Vi???t Nam","2021-02-01","B??a m???m","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian));
        books.add(new Book("B???n M??a Cu???c S???ng","Jim Rohn","164","25,000","75,000","Th??i H??","2018-05-07","B??a m???m","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song));
        bookAdapterHorizontal = new BookAdapterHorizontal(this,books, this);
        rcvListBookCategory.setAdapter(bookAdapterHorizontal);
    }

    private void initDataOld() {
        books = new ArrayList<>();
        books.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nh?? Xu???t B???n Th??? Gi???i","2021-07-14 11:36:27","B??a m???m","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        books.add(new Book("Sinh tr???c v??n tay","RICHARD UNGER","444","85,000","183,000 ","Nh?? Xu???t B???n H???ng ?????c","2021-01-12","B??a m???m","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        books.add(new Book("B???m ?????t gi?? bao nhi??u","V??n T??nh","320","45,000","119,000","NXB V??n H???c","2018-08-01","B??a m???m","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        bookAdapterHorizontal = new BookAdapterHorizontal(this,books, this);
        rcvListBookCategory.setAdapter(bookAdapterHorizontal);
    }

    private void initDataBestSeller() {
        books = new ArrayList<>();
        books.add(new Book("Gia t???c Morgan","Ron Chernow","1092","65,000","279,000"," NXB Th??? Gi???i","30/09/2021","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));
        books.add(new Book("Kh??ng gia ????nh","Hector Malot","582","45,000","168,210","NXB V??n H???c","14/01/2016","B??a m???m","16 x 24 cm",R.string.sach_moi,R.drawable.khonggiadinh,R.string.khong_gia_dinh));
        bookAdapterHorizontal = new BookAdapterHorizontal(this,books, this);
        rcvListBookCategory.setAdapter(bookAdapterHorizontal);
    }

    private void initDataFree() {
        books = new ArrayList<>();
        books.add(new Book("Ch??u ??u c?? g?? l??? kh??ng em?","Misa Gjone","192","15,000","69,000","Saigon Books","15/10/2019","B??a m???m","14 x 20,5 cm",R.string.sach_moi,R.drawable.chauaucogilakhongem,R.string.chau_au_co_gi_la_khong_em));
        books.add(new Book("?????c nh??n t??m","Dale Carnegie","320","15,000","45,000","First News - Tr?? Vi???t","2016-03-18","B??a c???ng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dacnhantam,R.string.dat_nhan_tam));
        books.add(new Book("D???t T??nh","V?? Tr???ng Ph???ng","162","15,000","45,000","NXB V??n H???c","2016-03-18","B??a c???ng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh));
        books.add(new Book("L??o H???c","Nam Cao","208","15,000","35,000","Nh?? Xu???t B???n D??n Tr??","2021","B??a m???m","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac));
        books.add(new Book("Nh???ng quy t???c t?? duy"," Richard Templar","336","45,000","129,000 ","Nh?? Xu???t B???n Lao ?????ng","21/08/2021","B??a m???m","15 x 23 cm",R.string.sach_moi,R.drawable.nhungquytactuduy,R.string.nhung_quy_tac_tu_duy));
        bookAdapterHorizontal = new BookAdapterHorizontal(this,books, this);
        rcvListBookCategory.setAdapter(bookAdapterHorizontal);
    }

        @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(BookListCatogoryActivity.this,DetailBookActivity.class);

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
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(BookListCatogoryActivity.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }

}