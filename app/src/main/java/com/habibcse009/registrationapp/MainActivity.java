package com.habibcse009.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class MainActivity extends AppCompatActivity {
    ShimmerTextView tv,txtsigup,txtlogin;
    Shimmer shimmer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);
        txtsigup = (ShimmerTextView) findViewById(R.id.txt_signup);
        txtlogin = (ShimmerTextView) findViewById(R.id.txt_login);

        //Initialize font
        //Typeface tf = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");
        Typeface tf = Typeface.createFromAsset(getAssets(), "AsapCondensed-Regular.ttf");
        //txtTitle.setTypeface(tf);
        tv.setTypeface(tf);

        shimmer = new Shimmer();
        shimmer.start(tv);
        shimmer.start(txtlogin);
        shimmer.start(txtsigup);

    }
}
