package com.example.merakibook.mybookfragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adapter.BookAdapterVertical;
import com.example.adapter.BookAdapterVerticalFragment;
import com.example.merakibook.DetailBookActivity;
import com.example.merakibook.R;
import com.example.model.Book;
import com.example.model.BookItemClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class ReadingBookFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvMyBookReading;
    ArrayList<Book> myBookReading;
    BookAdapterVerticalFragment bookAdapterVertical;

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
        view = inflater.inflate(R.layout.fragment_reading_book, container, false);
        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVerticalFragment(myBookReading, this);
        rcvMyBookReading.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvMyBookReading.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvMyBookReading = view.findViewById(R.id.rcvMyBookReading);
    }

    private void initData() {
        myBookReading = new ArrayList<>();
        myBookReading.add(new Book("Những quy tắc tư duy"," Richard Templar","336","45,000","129,000 ","Nhà Xuất Bản Lao Động","21/08/2021","Bìa mềm","15 x 23 cm",R.string.sach_moi,R.drawable.nhungquytactuduy,R.string.nhung_quy_tac_tu_duy));
        myBookReading.add(new Book("Không gia đình", "Hector Malot", "582", "45,000", "168,210", "NXB Văn Học", "14/01/2016", "Bìa mềm", "16 x 24 cm", R.string.sach_moi, R.drawable.khonggiadinh, R.string.khong_gia_dinh));
        myBookReading.add(new Book("Châu Âu có gì lạ không em?", "Misa Gjone", "192", "15,000", "69,000", "Saigon Books", "15/10/2019", "Bìa mềm", "14 x 20,5 cm", R.string.sach_moi, R.drawable.chauaucogilakhongem, R.string.chau_au_co_gi_la_khong_em));

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent = new Intent(getActivity(), DetailBookActivity.class);
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
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), bookImageView, "sharedName");
        startActivity(intent, options.toBundle());
    }
}