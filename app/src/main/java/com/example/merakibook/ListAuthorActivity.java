package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adapter.AuthorAdapter;
import com.example.adapter.AuthorSearchAdapter;
import com.example.model.Author;
import com.example.model.AuthorItemClickListener;
import com.example.utils.Constant;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAuthorActivity extends AppCompatActivity implements AuthorItemClickListener {
    RecyclerView rcvDanhSachTacGia;
    SearchView searchView;
    ArrayList<Author>authors;
    AuthorAdapter authorAdapter;
    ImageView imvBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_author);
        linkView();
        initData();
        addEvent();
    }

    private void linkView() {
        rcvDanhSachTacGia=findViewById(R.id.rcvDanhSachTacGia);
        searchView=findViewById(R.id.actionSearch);
        imvBack=findViewById(R.id.imvBack);
    }

    private void initData() {

        authors = new ArrayList<>();
        authors.add(new Author("J.K.Rowling","Vương quốc Liên hiệp Anh và Bắc Ireland","6","31/07/1965","Không", R.drawable.jkrowling, "Là một nhà văn, nhà từ thiện, nhà sản xuất phim và truyền hình, nhà biên kịch người Anh. Bà nổi tiếng là tác giả của bộ truyện giả tưởng Harry Potter từng đoạt nhiều giải thưởng và bán được hơn 500 triệu bản"));
        authors.add(new Author("Nam Cao","Xã Hòa Hậu, huyện Lý Nhân, Hà Nam","23","29/10/1915","30/11/1951", R.drawable.namcao, "Là một nhà văn và cũng là một chiến sĩ, liệt sĩ người Việt Nam. Ông là nhà văn hiện thực lớn (trước Cách mạng Tháng Tám), một nhà báo kháng chiến (sau Cách mạng), một trong những nhà văn tiêu biểu nhất thế kỷ 20. Nam Cao có nhiều đóng góp quan trọng đối với việc hoàn thiện phong cách truyện ngắn và tiểu thuyết Việt Nam ở nửa đầu thế kỷ 20."));
        authors.add(new Author("Tô Hoài","Hà Nội, Việt Nam","6","27/09/1920","06/07/2014", R.drawable.tohoai, "Một trong số những gương mặt tiêu biểu Tô Hoài – nhà văn xuất sắc trong nền văn học Việt Nam hiện đại."));
        authors.add(new Author("Paulo Coelho","Rio de Janeiro, Brasil","6","24/08/1947","Không", R.drawable.paulocoel, "Ông mới bắt đầu viết khi 40 tuổi và xuất bản cuốn sách đầu tiên, Paulo Coelho được xem là nhà văn có nhiều người đọc nhất thế giới."));
        authors.add(new Author("Nguyễn Nhật Ánh","Bình Quế, Thăng Bình, Quảng Nam","40","07/05/1955","Không", R.drawable.nguyennhatanh, "Là một nhà văn người Việt Nam, nổi tiếng nhờ các tác phẩm về đề tài tuổi mới lớn, các tác phẩm của ông được nhiều người yêu thích và nhiều tác phẩm được chuyển thành thể phim"));
        authorAdapter = new AuthorAdapter(this, authors, this);
        rcvDanhSachTacGia.setLayoutManager(new GridLayoutManager(this,3));
        rcvDanhSachTacGia.setAdapter(authorAdapter);
    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                authorAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                authorAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public void onAuthorClick(Author author, CircleImageView authorImage) {
        Intent intent = new Intent(ListAuthorActivity.this, Authors.class);
        intent.putExtra(Constant.AUTHOR_NAME, author.getAuthorName());
        intent.putExtra(Constant.PLACE_OF_BIRTH, author.getAuthorPlaceOfBirth());
        intent.putExtra(Constant.TOTAL_BOOK, author.getAuthorTotalBook());
        intent.putExtra(Constant.AUTHOR_BIRTH, author.getAuthorBirth());
        intent.putExtra(Constant.AUTHOR_DEADTH, author.getAuthorDeath());
        intent.putExtra(Constant.AUTHOR_IMAGE, author.getAuthorImage());
        intent.putExtra(Constant.AUTHOR_SUMMARY, author.getAuthorSummary());
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(ListAuthorActivity.this, authorImage,"sharedName");
        startActivity(intent,options.toBundle());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}