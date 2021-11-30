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
        myBook.add(new Book("Sapiens","Yuval Noah Harari","560","75,000","155,000","Nhà Xuất Bản Thế Giới","2021-07-14 11:36:27","Bìa mềm","13 x 20.5 cm",R.string.sach_moi,R.drawable.sapiens,R.string.sapiens));
        myBook.add(new Book("Sinh trắc vân tay","RICHARD UNGER","444","85,000","183,000 ","Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm",R.string.sach_moi,R.drawable.sinhtracvantay,R.string.sinh_trac_van_tay));
        myBook.add(new Book("Bạm đắt giá bao nhiêu","Vãn Tình","320","45,000","119,000","NXB Văn Học","2018-08-01","Bìa mềm","14.5 x 20cm",R.string.sach_moi,R.drawable.bandatgiabaonhieu,R.string.ban_dat_gia_bao_nhieu));
        myBook.add(new Book("Gia tộc Morgan","Ron Chernow","1092","65,000","279,000"," NXB Thế Giới","30/09/2021","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.giatocmorgan,R.string.gia_toc_margan));
        myBook.add(new Book("Ba ơi, mình đi đâu?","Jean-Louis Fournier","178","15,000","51,000","Hội nhà văn","25-11-2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the));
        myBook.add(new Book("Khi Hơi Thở Hóa Thinh Không"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong));
        myBook.add(new Book("Bốn Mùa Cuộc Sống","Jim Rohn","164","25,000","75,000","Thái Hà","2018-05-07","Bìa mềm","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song));

    }

    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }
}