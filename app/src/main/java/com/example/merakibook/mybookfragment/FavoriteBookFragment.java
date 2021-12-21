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


public class FavoriteBookFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvMyBookFav;
    ArrayList<Book> myBookFav;
    BookAdapterVerticalFragment bookAdapterVertical;

    public FavoriteBookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite_book,container,false);
        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVerticalFragment(myBookFav,this);
        rcvMyBookFav.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvMyBookFav.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvMyBookFav = view.findViewById(R.id.rcvMyBookFav);
    }

    private void initData() {
        myBookFav = new ArrayList<>();
        myBookFav.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        myBookFav.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        myBookFav.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        myBookFav.add(new Book("Gia tộc Morgan","Ron Chernow","1092","65,000","279,000"," NXB Thế Giới","30/09/2021","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(getActivity(), DetailBookActivity.class);
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
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(getActivity(), bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }
}