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

public class FourStarRatingFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvFourStarRating;
    ArrayList<Book> myBook;
    BookAdapterVertical bookAdapterVertical;

    public FourStarRatingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_four_star_rating, container, false);

        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVertical(getContext(),myBook,this);
        rcvFourStarRating.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvFourStarRating.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvFourStarRating = view.findViewById(R.id.rcvFourStarRating);
    }

    private void initData() {
        myBook = new ArrayList<>();
        myBook.add(new Book("Ba ơi, mình đi đâu?","Jean-Louis Fournier","178","15,000","51,000","Hội nhà văn","25-11-2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the));
        myBook.add(new Book("Khi Hơi Thở Hóa Thinh Không"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong));
    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }
}