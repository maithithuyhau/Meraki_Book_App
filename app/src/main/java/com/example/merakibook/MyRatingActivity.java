package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MyRatingActivity extends AppCompatActivity {

    Button btnAllStar, btnFiveStar, btnFourStar, btnThreeStar, btnTwoStar, btnOneStar;
    LinearLayout linearLayoutContainer;
    Fragment fragment;
    ImageView imvBackRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rating);

        linkView();
        addEvent();
    }

    private void linkView() {
        btnAllStar = findViewById(R.id.btnAllStar);
        btnFiveStar = findViewById(R.id.btnFiveStar);
        btnFourStar = findViewById(R.id.btnFourStar);
        btnThreeStar = findViewById(R.id.btnThreeStar);
        btnTwoStar = findViewById(R.id.btnTwoStar);
        btnOneStar = findViewById(R.id.btnOneStar);
        imvBackRating = findViewById(R.id.imvBackRating);

        linearLayoutContainer = findViewById(R.id.linearLayoutContainer);
    }

    private void addEvent() {
        btnAllStar.setOnClickListener(myClick);
        btnFiveStar.setOnClickListener(myClick);
        btnFourStar.setOnClickListener(myClick);
        btnThreeStar.setOnClickListener(myClick);
        btnTwoStar.setOnClickListener(myClick);
        btnOneStar.setOnClickListener(myClick);
        imvBackRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            switch (view.getId()){
                case R.id.btnAllStar:
                    fragment = new AllStarRatingFragment();
                    break;
                case R.id.btnFiveStar:
                    fragment = new FiveStarRatingFragment();
                    break;
                case R.id.btnFourStar:
                    fragment = new FourStarRatingFragment();
                    break;
                case R.id.btnThreeStar:
                    fragment = new ThreeStarRatingFragment();
                    break;
                case R.id.btnTwoStar:
                    fragment = new TwoStarRatingFragment();
                    break;
                case R.id.btnOneStar:
                    fragment = new OneStarRatingFragment();
                    break;
                default:
                    fragment = new AllStarRatingFragment();
                    break;
            }

            transaction.replace(R.id.linearLayoutContainer,fragment);
            transaction.commit();

        }
    };
}