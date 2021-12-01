package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class BookListCatogoryActivity extends AppCompatActivity {

    //Spinner
    Spinner spSort;
    ArrayList<String> listSort;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_catogory);

        linkView();
        addSortList();

    }

    private void linkView() {
        spSort = findViewById(R.id.spSort);
    }

    private void addSortList() {

        adapter = ArrayAdapter.createFromResource(this, R.array.sp_sort, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSort.setAdapter(adapter);
    }
}