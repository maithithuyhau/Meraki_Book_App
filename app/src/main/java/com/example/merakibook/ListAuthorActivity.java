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

        authors.add(new Author("Ayn Rand"," Saint Petersburg, Nga","14","02/02/1905","06/03/1982", R.drawable.annrand, "Bà nổi tiếng vì đã phát triển học thuyết Chủ nghĩa khách quan và vì đã viết một số tác phẩm như We the Living (Chúng ta những kẻ sống), The Fountainhead (Suối nguồn), Atlas Shrugged (Atlas vươn mình), For the new Intellectual (Vì giới tri thức mới) và tiểu thuyết ngắn Anthem (Bài ca tư tưởng). Là người gây ảnh hưởng rộng lớn tới nước Mỹ hậu chiến tranh thế giới thứ 2, các tác phẩm của Rand đã tạo nên sự mến mộ nhiệt thành cũng như phê phán nghiêm khắc."));
        authors.add(new Author("Henry Ford"," Springwells Township, Michigan","3","30/07/1863","07/04/1947", R.drawable.henryfod, "Là người sáng lập Công ty Ford Motor. Ông là một trong những người đầu tiên áp dụng sản xuất kiểu dây chuyền lắp ráp trong sản xuất ô tô. Ông không chỉ cách mạng ngành công nghiệp sản xuất ở Hoa Kỳ và châu Âu mà còn có nhiều ảnh hưởng tới kinh tế và xã hội thế kỷ 20 tới mức sự phối hợp giữa sản xuất hàng loạt, tiền lương cao và giá thành sản phẩm thấp cho người tiêu dùng đã được gọi là \"Chủ nghĩa Ford.\" Ông đã trở thành một trong hai hay ba người giàu nhất thế giới; ông để lại hầu như toàn bộ tài sản của mình cho Quỹ Ford, nhưng vẫn thu xếp để gia đình ông mãi giữ được quyền quản lý công ty."));
        authors.add(new Author("Lewis Carroll"," Daresbury, Vương Quốc Anh","17","27/01/1832","14/01/1898", R.drawable.lewiscarroll, "Được biết đến với bút danh Lewis Carroll. Ông là một nhà văn người Anh, nhà toán học, logic học , Anh giáo phó tế, và nhiếp ảnh gia. Các tác phẩm nổi tiếng nhất của ông là cuộc phiêu lưu của Alice in Wonderland, phần tiếp theo của nó Nhìn qua-tinh, trong đó bao gồm các bài thơ \"Jabberwocky\", và bài thơ The Hunting của Snark, tất cả các ví dụ về các thể loại văn học hư cấu. Ông được ghi nhận cho cơ sở của mình ở chơi chữ, logic, và tưởng tượng. Có những xã hội ở nhiều nơi trên thế giới dành riêng cho sự hưởng thụ và quảng bá tác phẩm của ông và cuộc điều tra của cuộc đời mình."));
        authors.add(new Author("Leo Buscaglia"," Los Angeles, California, Hoa Kỳ","6","31/03/1924","12/06/1998", R.drawable.leobuscaglia, "Leo Buscaglia là tác giả của 13 cuốn sách, hầu hết là về đề tài tình yêu và những vấn đề liên quan đến tình yêu. 5 trong số những cuốn sách của ông đã từng xuất hiện cùng lúc trong danh sách những cuốn sách bán chạy nhất do tạp chí The New York Times bình chọn. Cuốn sách đầu tiên của ông, Love: What Life Is All About, là một cuốn sách giữ vị trí bestseller liên tục trong suốt 20 năm. Trên 18 triệu bản sách của ông đang lưu hành và được dịch ra 17 thứ tiếng.\n" +
                "\n" +
                "Tiến sĩ Buscaglia hiện vẫn đang nghiên cứu, viết lách và diễn thuyết trên khắp thế giới. Ông là giáo sư danh tiếng của trường đại học Southern California, nơi ông đã dạy trong suốt 19 năm và khởi đầu lớp học Tình Yêu nổi tiếng. Trong cuộc sống và qua các tác phẩm của mình, tiến sĩ Buscaglia thể hiện sự quan tâm sâu sắc đối với việc trao tặng và bộc lộ yêu thương để con người ngày càng có được một cuộc sống hạnh phúc và hài lòng về tất cả những giá trị tinh thần quý giá mà mình đang có."));
        authors.add(new Author("Lothar J. Seiwert","Los Angeles, California, Hoa Kỳ","40","07/05/1952","Không", R.drawable.lotharjseiwert, "Lothar J. Seiwert sinh năm 1952, nhà sáng lập và lãnh đạo học viện Seiwert-Institut GmbH. Ông là giáo sư, nhà cố vấn về nghệ thuật lãnh đạo và quản lý thời gian. Ông cũng là tác giả của nhiều quyển sách được dịch ra hơn 20 ngôn ngữ trên thế giới với số lượng phát hành hơn nửa triệu bản.\n" +
                "\n" +
                "Tác phẩm tiêu biểu: Bí quyết đơn giản hóa cuộc sống...."));


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