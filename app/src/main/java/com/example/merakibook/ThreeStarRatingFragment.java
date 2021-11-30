package com.example.merakibook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adapter.BookAdapterVertical;
import com.example.model.Book;
import com.example.model.BookItemClickListener;

import java.util.ArrayList;

public class ThreeStarRatingFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvThreeStarRating;
    ArrayList<Book> myBook;
    BookAdapterVertical bookAdapterVertical;

    public ThreeStarRatingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_three_star_rating, container, false);

        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVertical(getContext(),myBook,this);
        rcvThreeStarRating.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvThreeStarRating.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvThreeStarRating = view.findViewById(R.id.rcvThreeStarRating);
    }

    private void initData() {
        myBook = new ArrayList<>();
          myBook.add(new Book("Bạn đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }
}