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

public class ReadedBookFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvMyBookReaded;
    ArrayList<Book> myBookReaded;
    BookAdapterVerticalFragment bookAdapterVertical;

    public ReadedBookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_readed_book,container,false);
        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVerticalFragment(myBookReaded,this);
        rcvMyBookReaded.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvMyBookReaded.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvMyBookReaded = view.findViewById(R.id.rcvMyBookReaded);
    }

    private void initData() {
        myBookReaded = new ArrayList<>();
        myBookReaded.add(new Book("Ba ơi, mình đi đâu?","Jean-Louis Fournier","178","15,000","51,000","Hội nhà văn","25-11-2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the));
        myBookReaded.add(new Book("Khi Hơi Thở Hóa Thinh Không"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong));
        myBookReaded.add(new Book("Đáp Án Của Thời Gian","Lư Tư Hạo","312","20,000","77,000","Nhà Xuất Bản Phụ Nữ Việt Nam","2021-02-01","Bìa mềm","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian));
        myBookReaded.add(new Book("Bốn Mùa Cuộc Sống","Jim Rohn","164","25,000","75,000","Thái Hà","2018-05-07","Bìa mềm","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song));

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