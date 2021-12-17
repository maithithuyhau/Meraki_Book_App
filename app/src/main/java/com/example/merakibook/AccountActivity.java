package com.example.merakibook;

import static com.example.merakibook.R.id.btnAcGioiThieuNext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AccountActivity extends Fragment {
private ImageView btnAcGioiThieuNext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_account,container,false);

        btnAcGioiThieuNext=view.findViewById(R.id.btnAcGioiThieuNext);
        btnAcGioiThieuNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(),AboutMerakiBook.class);
                startActivity(intent);
            }
        });


        return view;

    }
}