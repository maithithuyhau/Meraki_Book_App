package com.example.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public interface AuthorItemClickListener {
    void onAuthorClick(Author author, CircleImageView authorImage);

    void onCreate(Bundle savedInstanceState);

    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState);
}
