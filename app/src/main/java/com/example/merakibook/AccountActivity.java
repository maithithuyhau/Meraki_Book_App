package com.example.merakibook;

import static com.example.merakibook.R.id.btnAcGioiThieuNext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AccountActivity extends Fragment {

    private ImageButton btnAcGioiThieuNext;
    private Button btnAcSaw, btnAcRate,btnAcCart;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_account,container,false);

        linkView();
        addEvent();

//        btnAcGioiThieuNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(getActivity(),AboutMerakiBook.class);
//                startActivity(intent);
//            }
//        });

        return view;

    }

    private void linkView() {
        btnAcGioiThieuNext=view.findViewById(R.id.btnAcGioiThieuNext);
        btnAcCart = view.findViewById(R.id.btnAcCart);
        btnAcSaw = view.findViewById(R.id.btnAcSaw);
        btnAcRate = view.findViewById(R.id.btnAcRate);
    }

    private void addEvent() {
        btnAcCart.setOnClickListener(myClick);
        btnAcSaw.setOnClickListener(myClick);
        btnAcRate.setOnClickListener(myClick);
        btnAcGioiThieuNext.setOnClickListener(myClick);
    }

    View.OnClickListener myClick = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnAcCart:
                    intent = new Intent(getActivity(),PurchaseOrderActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnAcSaw:
                    intent = new Intent(getActivity(),RecentlyBookActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnAcRate:
                    intent = new Intent(getActivity(),MyRatingActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnAcGioiThieuNext:
                    intent = new Intent(getActivity(),AboutMerakiBook.class);
                    startActivity(intent);
                    break;
            }
        }
    };


}