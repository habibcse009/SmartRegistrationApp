package com.habibcse009.registrationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import es.dmoral.toasty.Toasty;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    Button btnAboutUs;
    CardView CardAboutUs, CardSignin, CardFindDoctor;

    //for double back press to exit
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        CardAboutUs = findViewById(R.id.card_aboutus);
        CardSignin = findViewById(R.id.card_signin);
        CardFindDoctor = findViewById(R.id.card_finddoctor);


        sp = getSharedPreferences(Constant.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();



        if (Build.VERSION.SDK_INT>=23) //Android MarshMellow Version or above
        {
            // requestAllPermission();
        }


        Typeface tf = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");
        // CardAboutUs.setTypeface(tf);
       /* CardAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutusActivity.class);
                startActivity(intent);
            }
        });
        CardSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
        CardFindDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DoctorsCategoryActivity.class);
                startActivity(intent);
            }
        });

*/

    }


    //double backpress to exit
    @Override
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
