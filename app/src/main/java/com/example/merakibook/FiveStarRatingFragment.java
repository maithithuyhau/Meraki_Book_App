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

public class FiveStarRatingFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvFiveStarRating;
    ArrayList<Book> myBook;
    BookAdapterVertical bookAdapterVertical;

    public FiveStarRatingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_five_star_rating, container, false);

        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVertical(getContext(),myBook,this);
        rcvFiveStarRating.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvFiveStarRating.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvFiveStarRating = view.findViewById(R.id.rcvFiveStarRating);
    }

    private void initData() {
        myBook = new ArrayList<>();
        myBook.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        myBook.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }
}