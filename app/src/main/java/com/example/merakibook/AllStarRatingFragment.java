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

public class AllStarRatingFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvAllStarRating;
    ArrayList<Book> myBook;
    BookAdapterVertical bookAdapterVertical;

    public AllStarRatingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_all_star_rating, container, false);

        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVertical(getContext(),myBook,this);
        rcvAllStarRating.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvAllStarRating.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvAllStarRating = view.findViewById(R.id.rcvAllStarRating);
    }

    private void initData() {
        myBook = new ArrayList<>();
       }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }
}