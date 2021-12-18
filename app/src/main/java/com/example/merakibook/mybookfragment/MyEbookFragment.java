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

import java.util.ArrayList;

public class MyEbookFragment extends Fragment implements BookItemClickListener {

    View view;
    RecyclerView rcvMyEbook;
    ArrayList<Book> myEbook;
    BookAdapterVerticalFragment bookAdapterVertical;

    public MyEbookFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_ebook,container,false);
        linkView();
        initData();

        bookAdapterVertical = new BookAdapterVerticalFragment(myEbook,this);
        rcvMyEbook.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvMyEbook.setAdapter(bookAdapterVertical);

        return view;
    }

    private void linkView() {
        rcvMyEbook = view.findViewById(R.id.rcvMyEbook);
    }

    private void initData() {

        myEbook = new ArrayList<>();
        myEbook.add(new Book("Becoming"," Michelle Obama","448","35,000","579.000","Penguin Books","2021-07-14 11:36:27","Hardback","242 x 164 x 42 mm",R.string.sach_moi,R.drawable.becoming,R.string.sapiens));
        myEbook.add(new Book("Không gia đình","Hector Malot","582","45,000","168,210","NXB Văn Học","14/01/2016","Bìa mềm","16 x 24 cm",R.string.sach_moi,R.drawable.khonggiadinh,R.string.khong_gia_dinh));
        myEbook.add(new Book("Châu Âu có gì lạ không em?","Misa Gjone","192","15,000","69,000","Saigon Books","15/10/2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.chauaucogilakhongem,R.string.chau_au_co_gi_la_khong_em));

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {
        Intent intent=new Intent(getActivity(), DetailBookActivity.class);
        intent.putExtra("Title",book.getBookName());
        intent.putExtra("Summary",book.getBookSummary());
        intent.putExtra("Image",book.getBookImage());
        intent.putExtra("Author",book.getBookAuthor());
        intent.putExtra("Page",book.getBookPage());
        intent.putExtra("EbookPrice",book.getEbookPrice());
        intent.putExtra("bookPrice",book.getBookPrice());
        intent.putExtra("Publisher",book.getBookPublisher());
        intent.putExtra("DateTime",book.getDateTime());
        intent.putExtra("LoaiBia",book.getLoaiBia());
        intent.putExtra("BookSize",book.getBookSize());


//        startActivity(intent);

        //Animation
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(getActivity(), bookImageView,"sharedName");
        startActivity(intent,options.toBundle());
    }
}