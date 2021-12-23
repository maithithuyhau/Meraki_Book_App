package com.example.merakibook;

import static com.example.merakibook.AddressActivity.REFERENCE_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.adapter.CartAdapter;
import com.example.model.Book;
import com.example.model.Cart;

import java.io.File;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView rcvGioHang;
    ArrayList<Cart> carts;
    CartAdapter adapter;

    ImageButton btnBack;
    Button btnMuaHang;

    public  static final String REFERENCE_PATH = "/shared_prefs/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        linkView();
        initData();
        addEvent();
        DeleteItem();

    }

    private void linkView() {

        rcvGioHang = findViewById(R.id.rcvGioHang);
        btnMuaHang = findViewById(R.id.btnMuaHang);
        btnBack = findViewById(R.id.btnBack);
    }

    private void initData() {
        carts = new ArrayList<>();
        carts.add(new Cart("Bạm đắt giá bao nhiêu","Vãn Tình", 119000, R.drawable.bandatgiabaonhieu,1));
        carts.add(new Cart("Dứt Tình","Vũ Trọng Phụng", 45000, R.drawable.duttinh,1));
        carts.add(new Cart("Lão Hạc","Nam Cao", 35000, R.drawable.laohac,1));


        adapter = new CartAdapter(getApplicationContext(), carts);
        rcvGioHang.setAdapter(adapter);


        rcvGioHang.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    private void DeleteItem() {
        adapter.setOnItemClickListener(new CartAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);

            }
        });
    }

    private void addEvent() {
        btnMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataPath = getApplicationInfo().dataDir + REFERENCE_PATH + REFERENCE_NAME;
                File f = new File(getApplicationInfo().dataDir + REFERENCE_PATH );
                if(!f.exists()){
                    Intent intent = new Intent(CartActivity.this, AddressActivity.class);
                    startActivity(intent);
                    Toast.makeText(CartActivity.this, "paymentinfo ko tồn tại", Toast.LENGTH_SHORT).show();
                }else if(f.exists()){
                    Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                    startActivity(intent);
                    Toast.makeText(CartActivity.this, "paymentinfo tồn tại", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void removeItem(int position) {
        carts.remove(position);
        adapter.notifyItemRemoved(position);
    }

}