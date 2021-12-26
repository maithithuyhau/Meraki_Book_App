package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.adapter.BookAdapterHorizontal;
import com.example.model.Book;
import com.example.model.BookItemClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class DetailBookActivity extends AppCompatActivity implements BookItemClickListener {
    private TextView txtTenSach,txtDesc, txtTacGia,txtTacGia2,
            txtPage,txtDateTime, txtPublisher,txtBia,txtBookSize, txtmenuDitailBook,
    txtPriceEbook, txtPriceBook ;
    private ImageView imvImages, imvHinh, imvComment, imvBack,imvCartDetail;
    private RecyclerView rcvcung_the_loai;
    private Button btnMuaSach, btnDocNgay, btnDoc;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);
        linkView();
        loadData();
        initData();
        addEvent();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
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
        txtPriceEbook=findViewById(R.id.txtPriceEbook);
        txtPriceBook=findViewById(R.id.txtPriceBook);



        imvImages=findViewById(R.id.imvDetail_Images);
        imvHinh=findViewById(R.id.imvHinh);
        imvComment=findViewById(R.id.imvComment);
        imvBack=findViewById(R.id.imvBack);
        imvCartDetail=findViewById(R.id.imvCartDetail);

        btnMuaSach=findViewById(R.id.btnMuaSach);
        btnDocNgay=findViewById(R.id.btnDocNgay);
        btnDoc=findViewById(R.id.btnDoc);
    }

    private void loadData() {
        Intent intent= getIntent();
        String bookName=intent.getExtras().getString(Constant.BOOK_NAME);
        String bookAuthor= intent.getExtras().getString(Constant.BOOK_AUTHOR);


        String bookPage=intent.getExtras().getString(Constant.BOOK_PAGE);
        String ebookPrice= intent.getExtras().getString(Constant.BOOK_E_PRICE);
        String bookPrice=intent.getExtras().getString(Constant.BOOK_PRICE);
        String bookPublisher= intent.getExtras().getString(Constant.BOOK_PUBLISHER);
        String dateTime=intent.getExtras().getString(Constant.BOOK_DATETIME);
        String loaiBia= intent.getExtras().getString(Constant.BOOK_LOAI_BIA);
        String bookSize= intent.getExtras().getString(Constant.BOOK_SIZE);


        int Summary= intent.getExtras().getInt(Constant.BOOK_SUMMARY);
        int bookImage =intent.getExtras().getInt(Constant.BOOK_IMAGE);


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
        txtPriceEbook.setText(ebookPrice);
        txtPriceBook.setText(bookPrice);

    }

    private void initData() {
        List<Book> list_book1= new ArrayList<>();
        list_book1.add(new Book("Ba ơi, mình đi đâu?","Jean-Louis Fournier","178","15,000","51,000","Hội nhà văn","25-11-2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the));
        list_book1.add(new Book("Khi Hơi Thở Hóa Thinh Không"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong));
        list_book1.add(new Book("Đáp Án Của Thời Gian","Lư Tư Hạo","312","20,000","77,000","Nhà Xuất Bản Phụ Nữ Việt Nam","2021-02-01","Bìa mềm","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian));
        list_book1.add(new Book("Bốn Mùa Cuộc Sống","Jim Rohn","164","25,000","75,000","Thái Hà","2018-05-07","Bìa mềm","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song));

        list_book1.add(new Book("Đắc nhân tâm","Dale Carnegie","320","15,000","45,000","First News - Trí Việt","2016-03-18","Bìa cứng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dacnhantam,R.string.dat_nhan_tam));
        list_book1.add(new Book("Dứt Tình","Vũ Trọng Phụng","162","15,000","45,000","NXB Văn Học","2016-03-18","Bìa cứng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh));
        list_book1.add(new Book("Lão Hạc","Nam Cao","208","15,000","35,000","Nhà Xuất Bản Dân Trí","2021","Bìa mềm","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac));
        list_book1.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        list_book1.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        list_book1.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
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
//                                AddCart();
                                return true;
                            case R.id.muaebook:
                                ShowPopup(Gravity.CENTER);
                                return true;
                            default:
                                return false;
                        }

                    }
                });
                popupMenu.show();
            }
        });
        imvComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailBookActivity.this,Reviews.class);
                startActivity(intent);
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1HnNpFJUcWMS2Ws0wNDNg-Au6XXtkl-2R/view"));
                startActivity(intent);
            }
        });


            imvBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            imvCartDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(DetailBookActivity.this,CartActivity.class);
                    startActivity(intent);
                }
            });
            txtTacGia2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent= new Intent(DetailBookActivity.this,Authors.class);
//                    startActivity(intent);
                }
            });
    }

    private void AddCart() {
        Intent intent=new Intent(this,CartActivity.class);

        startActivity(intent);
    }

    public void ShowPopup(int gravity){
        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_payment_successful);

        Window window=dialog.getWindow();
        if(window==null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        window.setAttributes(windowAttributes);
        if(Gravity.CENTER==gravity){
            dialog.setCancelable(true);
        }else{
            dialog.setCancelable(false);
        }
          btnDocNgay=dialog.findViewById(R.id.btnDocNgay);
          btnDocNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1HnNpFJUcWMS2Ws0wNDNg-Au6XXtkl-2R/view"));
                startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog.show();

    }


    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(this,DetailBookActivity.class);

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
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(DetailBookActivity.this, bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}