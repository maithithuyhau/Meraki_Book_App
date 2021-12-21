package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Author;
import com.example.model.AuthorItemClickListener;
import com.example.model.Book;
import com.example.model.BookItemClickListener;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Authors extends AppCompatActivity implements BookItemClickListener, AuthorItemClickListener {
    private TextView txtTenTacGia1, txtTenTacGia2, txtNamSinh, txtNamMat, txtSoLuongTacPham, txtQueQuan, txtTomTat, txtXemTatCa;
    private CircleImageView imvAuthor;
    private RecyclerView rcvCacTacPham;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors);

        linkViews();
        loadData();
        addEvent();
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
    }

    private void addEvent() {

    }

    private void loadData() {
        Intent intent= getIntent();
        String authorName=intent.getExtras().getString("AuthorName");
        String authorPlaceOfBirth= intent.getExtras().getString("PlaceOfBirth");
        String authorBirth=intent.getExtras().getString("AuthorBirth");
        String authorDeath= intent.getExtras().getString("AuthorDeath");
        String authorTotalBook= intent.getExtras().getString("TotalBook");

        String authorSummary= intent.getExtras().getString("AuthorSummary");
        int authorImage =intent.getExtras().getInt("AuthorImage");

        imvAuthor.setImageResource(authorImage);

        txtTenTacGia1.setText(authorName);
        txtNamSinh.setText(authorBirth);
        txtNamMat.setText(authorDeath);
        txtQueQuan.setText(authorPlaceOfBirth);
        txtSoLuongTacPham.setText(authorTotalBook);
        txtTomTat.setText(authorSummary);
    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

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