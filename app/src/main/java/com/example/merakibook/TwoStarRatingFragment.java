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

public class TwoStarRatingFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvTwoStarRating;
    ArrayList<Book> myBook;
    BookAdapterVertical bookAdapterVertical;

    public TwoStarRatingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two_star_rating, container, false);

        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVertical(getContext(),myBook,this);
        rcvTwoStarRating.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvTwoStarRating.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvTwoStarRating = view.findViewById(R.id.rcvTwoStarRating);
    }

    private void initData() {
        myBook = new ArrayList<>();
        myBook.add(new Book("Gia tộc Morgan","Ron Chernow","1092","65,000","279,000"," NXB Thế Giới","30/09/2021","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }
}