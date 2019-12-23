package com.habibcse009.registrationapp;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class MainActivity extends AppCompatActivity {
    ShimmerTextView tv,txtsigup,txtlogin;
    Shimmer shimmer;
    private Button buttonlogin,buttonsignup;
    //for double back press to exit
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);
        txtsigup = (ShimmerTextView) findViewById(R.id.txt_signup);
        txtlogin = (ShimmerTextView) findViewById(R.id.txt_login);
        buttonlogin = findViewById(R.id.btn_login);
        buttonsignup = findViewById(R.id.btn_signup);

        //Initialize font
        //Typeface tf = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");
        Typeface tf = Typeface.createFromAsset(getAssets(), "AsapCondensed-Regular.ttf");
        //txtTitle.setTypeface(tf);
        tv.setTypeface(tf);
        Typeface tf1 = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");

        buttonsignup.setTypeface(tf);
        buttonlogin.setTypeface(tf);
        //  textView.setTypeface(tf1);


        shimmer = new Shimmer();
        shimmer.start(tv);
        shimmer.start(txtlogin);
        shimmer.start(txtsigup);



        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });


    }
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();

            finishAffinity();

        } else {
            Toasty.warning(this, "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();

        }
        back_pressed = System.currentTimeMillis();
    }
}
