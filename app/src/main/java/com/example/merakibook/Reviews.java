package com.example.merakibook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adapter.CommentAdapter;
import com.example.data.CommentDataBaseHelper;
import com.example.model.Comment;

import java.util.ArrayList;

public class Reviews extends AppCompatActivity {
    ImageView imvBack;
    RecyclerView rcvCmt;
    EditText edtAddcmt;
    ImageView imvSend;
    public static SQLiteDatabase db;
    CommentDataBaseHelper cmtDB;
    ArrayList<String> cmt_content, cmt_id;

    CommentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        linkView();

        addEvent();

//        loadData();
    }

    private void linkView() {
        imvBack=findViewById(R.id.imvBack);
        rcvCmt=findViewById(R.id.rcvCmt);
        imvSend=findViewById(R.id.imvSend);
        edtAddcmt=findViewById(R.id.edtAddcmt);
    }

    private void loadData() {
        adapter=new CommentAdapter(Reviews.this,cmt_id,cmt_content);
        rcvCmt.setAdapter(adapter);
        rcvCmt.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        imvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommentDataBaseHelper cmtDB = new CommentDataBaseHelper(Reviews.this);
                cmtDB.addComment(edtAddcmt.getText().toString().trim());
                loadData();
//                ContentValues values=new ContentValues();
//                values.put("Comment",edtAddcmt.getText().toString());
//
//                int flat=Reviews.db.update("Comment",values,
//                        "CommentId=?", new String[]{String.valueOf(cmt_id)});
            }
        });
        cmtDB = new CommentDataBaseHelper(Reviews.this);
        cmt_id = new ArrayList<>();
        cmt_content = new ArrayList<>();
        storeDataInArrays();

        rcvCmt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return false;
            }
        });

    }

    private void storeDataInArrays() {
        Cursor cursor = cmtDB.readAllData();
        if(cursor.getCount() == 0){
//            empty_imageview.setVisibility(View.VISIBLE);
//            no_data.setVisibility(View.VISIBLE);
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                cmt_id.add(cursor.getString(0));
                cmt_content.add(cursor.getString(1));
                loadData();
            }
//            empty_imageview.setVisibility(View.GONE);
//            no_data.setVisibility(View.GONE);
            cursor.close();
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        loadData();
    }



}