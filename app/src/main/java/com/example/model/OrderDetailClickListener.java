package com.example.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public interface OrderDetailClickListener {
    void onOrderClick(Order order, ImageView orderImage);

    void onCreate(Bundle savedInstanceState);

    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState);
}
