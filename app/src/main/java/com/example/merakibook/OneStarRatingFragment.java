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

public class OneStarRatingFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvOneStarRating;
    ArrayList<Book> myBook;
    BookAdapterVertical bookAdapterVertical;

    public OneStarRatingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one_star_rating, container, false);

        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVertical(getContext(),myBook,this);
        rcvOneStarRating.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvOneStarRating.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvOneStarRating = view.findViewById(R.id.rcvOneStarRating);
    }

    private void initData() {
        myBook = new ArrayList<>();
        myBook.add(new Book("Bốn Mùa Cuộc Sống","Jim Rohn","164","25,000","75,000","Thái Hà","2018-05-07","Bìa mềm","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song));

    }
    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }
}