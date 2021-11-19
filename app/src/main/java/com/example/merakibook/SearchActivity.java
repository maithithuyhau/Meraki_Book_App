package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.BookAdapterHorizontal;
import com.example.adapter.Search_BookList_Adapter;
import com.example.model.Book;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchActivity extends AppCompatActivity {
    GridView gvBookItem;

    Search_BookList_Adapter adapter;
    ImageView imvHinh;
    CircleImageView imvTacGiaImage;
    TextView txtName, txtTacGia, txtTacGiaView;
    RecyclerView rcvTacGia;
    ArrayList<Book> books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        linkViews();
        configRecyclerView();
        initData();
        loadData();
    }



    private void linkViews() {
        imvHinh = findViewById(R.id.imvHinh);
        imvTacGiaImage = findViewById(R.id.imvTacGiaImage);
        txtName = findViewById(R.id.txtName);
        txtTacGia = findViewById(R.id.txtTacGia);
        txtTacGiaView = findViewById(R.id.txtTacGiaView);
        gvBookItem = findViewById(R.id.gvBookItem);
        rcvTacGia = findViewById(R.id.rcvTacGia);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvTacGia.setLayoutManager(manager);
    }

    private void initData() {
        books = new ArrayList<>();
        books.add(new Book("Ba ơi, mình đi đâu?","Jean-Louis Fournier","178","15,000","51,000","Hội nhà văn","25-11-2019","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.baoiminhdidau,R.string.ba_oi_minh_di_dau_the,R.drawable.icon_heart,R.drawable.icon_fivestar));
        books.add(new Book("Khi Hơi Thở Hóa Thinh Không"," Paul Kalanithi","236","35,000","85,000","Omega Plus","2017-07-26","Bìa mềm","14 x 20,5 cm",R.string.sach_moi,R.drawable.whenbreathbecomesair,R.string.khi_hoi_tho_hoa_thinh_khong,R.drawable.icon_heart,R.drawable.icon_fivestar));
        books.add(new Book("Đáp Án Của Thời Gian","Lư Tư Hạo","312","20,000","77,000","Nhà Xuất Bản Phụ Nữ Việt Nam","2021-02-01","Bìa mềm","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.dapancuathoigian,R.string.dap_an_cua_thoi_gian,R.drawable.icon_heart,R.drawable.icon_fivestar));
        books.add(new Book("Bốn Mùa Cuộc Sống","Jim Rohn","164","25,000","75,000","Thái Hà","2018-05-07","Bìa mềm","13x19x2 cm",R.string.sach_moi,R.drawable.bonmuacuocsong,R.string.bon_mua_cuoc_song,R.drawable.icon_heart,R.drawable.icon_fivestar));
        books.add(new Book("Đắc nhân tâm","Dale Carnegie","320","15,000","45,000","First News - Trí Việt","2016-03-18","Bìa cứng","14.5 x 20.5 cm",R.string.sach_moi,R.drawable.datnhantam,R.string.dat_nhan_tam,R.drawable.icon_heart,R.drawable.icon_fivestar));
        books.add(new Book("Dứt Tình","Vũ Trọng Phụng","162","15,000","45,000","NXB Văn Học","2016-03-18","Bìa cứng","13 x 20.5 cm",R.string.sach_moi,R.drawable.duttinh,R.string.dut_tinh,R.drawable.icon_heart,R.drawable.icon_fivestar));

    }

    private void loadData() {
        adapter = new Search_BookList_Adapter(SearchActivity.this, R.layout.bookitem, books);
        gvBookItem.setAdapter(adapter);
    }
}