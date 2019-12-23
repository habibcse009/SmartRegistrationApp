package com.habibcse009.registrationapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    ShimmerTextView txtgotosigup, txtforlogin;
    Shimmer shimmer;
    private Button buttonlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtgotosigup = (ShimmerTextView) findViewById(R.id.txtgotosignup);
        txtforlogin = (ShimmerTextView) findViewById(R.id.textView2login);

        //Initialize font
        //Typeface tf = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");
        Typeface tf = Typeface.createFromAsset(getAssets(), "AsapCondensed-Regular.ttf");
        //txtTitle.setTypeface(tf);
        txtforlogin.setTypeface(tf);

        shimmer = new Shimmer();
        shimmer.start(txtforlogin);
        shimmer.start(txtgotosigup);

        txtgotosigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });


    }
}
