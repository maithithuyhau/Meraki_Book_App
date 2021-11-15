package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.adapter.BookAdapterHorizontal;
import com.example.model.Book;
import com.example.model.BookItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class DetailBookActivity extends AppCompatActivity implements BookItemClickListener {
    private TextView txtTenSach,txtDesc, txtTacGia,txtTacGia2,
            txtPage,txtDateTime, txtPublisher,txtBia,txtBookSize, txtmenuDitailBook;
    private ImageView imvImages, imvHinh;
    private RecyclerView rcvcung_the_loai;
    private Button btnMuaSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);
        linkView();
        loadData();
        initData();
        addEvent();
    }

    private void linkView() {
        rcvcung_the_loai=findViewById(R.id.rcvcung_the_loai);

        txtTenSach=findViewById(R.id.txtTenSach);
        txtDesc=findViewById(R.id.txtDesc);
        txtTacGia=findViewById(R.id.txtTacGia);
        txtTacGia2=findViewById(R.id.txtTacGia2);
        txtDateTime=findViewById(R.id.txtDateTime);
        txtBookSize=findViewById(R.id.txtBookSize);
        txtBia=findViewById(R.id.txtBia);
        txtPublisher=findViewById(R.id.txtPublisher);
        txtPage=findViewById(R.id.txtPage);
        txtmenuDitailBook=findViewById(R.id.txtmenuDitailBook);

        imvImages=findViewById(R.id.imvDetail_Images);
        imvHinh=findViewById(R.id.imvHinh);

        btnMuaSach=findViewById(R.id.btnMuaSach);
    }

    private void loadData() {
        Intent intent= getIntent();
        String bookName=intent.getExtras().getString("Title");
        String bookAuthor= intent.getExtras().getString("Author");


        String bookPage=intent.getExtras().getString("Page");
        String ebookPrice= intent.getExtras().getString("EbookPrice");
        String bookPrice=intent.getExtras().getString("bookPrice");
        String bookPublisher= intent.getExtras().getString("Publisher");
        String dateTime=intent.getExtras().getString("DateTime");
        String loaiBia= intent.getExtras().getString("LoaiBia");
        String bookSize= intent.getExtras().getString("BookSize");


        int Summary= intent.getExtras().getInt("Summary");
        int bookImage =intent.getExtras().getInt("Image");


        imvImages.setImageResource(bookImage);
        imvHinh.setImageResource(bookImage);

        txtTenSach.setText(bookName);
        txtDesc.setText(Summary);
        txtTacGia.setText(bookAuthor);
        txtTacGia2.setText(bookAuthor);
        txtPage.setText(bookPage);
        txtPublisher.setText(bookPublisher);
        txtBia.setText(loaiBia);
        txtDateTime.setText(dateTime);
        txtBookSize.setText(bookSize);
        txtmenuDitailBook.setText(bookName);

    }

    private void initData() {
        List<Book> list_book1= new ArrayList<>();
        list_book1.add(new Book("Ba ơi, mình đi đâu?","Jean-Louis Fournier","178","15,000","51,000","Hội nhà văn","25-11-2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Khi Hơi Thở Hóa Thinh Không"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Đáp Án Của Thời Gian","Lư Tư Hạo","312","20,000","77,000","Nhà Xuất Bản Phụ Nữ Việt Nam","2021-02-01","Bìa mềm","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Bốn Mùa Cuộc Sống","Jim Rohn","164","25,000","75,000","Thái Hà","2018-05-07","Bìa mềm","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song,R.drawable.icon_heart,R.drawable.icon_fivestar));

        list_book1.add(new Book("Đắc nhân tâm","Dale Carnegie","320","15,000","45,000","First News - Trí Việt","2016-03-18","Bìa cứng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.datnhantam,R.string.dat_nhan_tam,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Dứt Tình","Vũ Trọng Phụng","162","15,000","45,000","NXB Văn Học","2016-03-18","Bìa cứng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Lão Hạc","Nam Cao","208","15,000","35,000","Nhà Xuất Bản Dân Trí","2021","Bìa mềm","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay,R.drawable.icon_heart,R.drawable.icon_fivestar));
        list_book1.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu,R.drawable.icon_heart,R.drawable.icon_fivestar));
        BookAdapterHorizontal adapter2=new BookAdapterHorizontal(this, list_book1,this);
        rcvcung_the_loai.setAdapter(adapter2);
        rcvcung_the_loai.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

    }

    private void addEvent() {
        btnMuaSach.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PopupMenu popupMenu= new PopupMenu(DetailBookActivity.this,view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_muasach,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.muabook:

                                return true;
                            case R.id.muaebook:
//
                                return true;
                            default:
                                return false;
                        }

                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(this,DetailBookActivity.class);
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
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(DetailBookActivity.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }
}