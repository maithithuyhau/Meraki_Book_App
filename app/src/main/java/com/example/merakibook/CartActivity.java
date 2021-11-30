package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adapter.CartAdapter;
import com.example.model.Book;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView rcvGioHang;
    ArrayList<Book> books;
    CartAdapter adapter;

    Button btnMuaHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        linkView();
        initData();

    }

    private void linkView() {

        rcvGioHang = findViewById(R.id.rcvGioHang);
        btnMuaHang = findViewById(R.id.btnMuaHang);
    }

    private void initData() {
        books = new ArrayList<>();
        books.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        books.add(new Book("Dứt Tình","Vũ Trọng Phụng","162","15,000","45,000","NXB Văn Học","2016-03-18","Bìa cứng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh));
        books.add(new Book("Lão Hạc","Nam Cao","208","15,000","35,000","Nhà Xuất Bản Dân Trí","2021","Bìa mềm","13 x 20cm",R.string.sach_moi,R.drawable.laohac,R.string.lao_hac));



        adapter = new CartAdapter(getApplicationContext(), books);
        rcvGioHang.setAdapter(adapter);


        rcvGioHang.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

}