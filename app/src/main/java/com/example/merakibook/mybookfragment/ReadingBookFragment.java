package com.example.merakibook.mybookfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adapter.BookAdapterVertical;
import com.example.merakibook.R;
import com.example.model.Book;
import com.example.model.BookItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ReadingBookFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvMyBookReading;
    ArrayList<Book> myBookReading;
    BookAdapterVertical bookAdapterVertical;

    public ReadingBookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reading_book,container,false);
        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVertical(getContext(),myBookReading,this);
        rcvMyBookReading.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvMyBookReading.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvMyBookReading = view.findViewById(R.id.rcvMyBookReading);
    }

    private void initData() {
        myBookReading = new ArrayList<>();
        myBookReading.add(new Book("Becoming"," Michelle Obama","448","35,000","579.000","Penguin Books","2021-07-14 11:36:27","Hardback","242 x 164 x 42 mm",R.string.sach_moi,R.drawable.becoming,R.string.sapiens));
        myBookReading.add(new Book("Không gia đình","Hector Malot","582","45,000","168,210","NXB Văn Học","14/01/2016","Bìa mềm","16 x 24 cm",R.string.sach_moi,R.drawable.khonggiadinh,R.string.khong_gia_dinh));
        myBookReading.add(new Book("Châu Âu có gì lạ không em?","Misa Gjone","192","15,000","69,000","Saigon Books","15/10/2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.chauaucogilakhongem,R.string.chau_au_co_gi_la_khong_em));

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }
}