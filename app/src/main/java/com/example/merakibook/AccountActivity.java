package com.example.merakibook;

import static com.example.merakibook.R.id.btnAcGioiThieuNext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
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

    Button btnAcSaw, btnAcRate,btnAcCart;
    ImageButton  btnBack;
    View view;

    ConstraintLayout layoutChinhSach, layoutGioiThieu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_account,container,false);

        linkView();
        addEvent();


        return view;

    }

    private void linkView() {
        layoutChinhSach = view.findViewById(R.id.layoutChinhSach);
        layoutGioiThieu = view.findViewById(R.id.layoutGioiThieu);
        btnAcCart = view.findViewById(R.id.btnAcCart);
        btnAcSaw = view.findViewById(R.id.btnAcSaw);
        btnAcRate = view.findViewById(R.id.btnAcRate);
        btnBack = view.findViewById(R.id.btnBack);
    }

    private void addEvent() {
        btnAcCart.setOnClickListener(myClick);
        btnAcSaw.setOnClickListener(myClick);
        btnAcRate.setOnClickListener(myClick);
        layoutGioiThieu.setOnClickListener(myClick);
        layoutChinhSach.setOnClickListener(myClick);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

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
                case R.id.layoutGioiThieu:
                    intent = new Intent(getActivity(),AboutMerakiBook.class);
                    startActivity(intent);
                    break;
                case R.id.layoutChinhSach:
                    intent = new Intent(getActivity(),PolicyActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    };

}