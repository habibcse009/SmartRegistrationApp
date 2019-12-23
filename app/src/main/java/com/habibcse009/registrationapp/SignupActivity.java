package com.habibcse009.registrationapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    ShimmerTextView txtgotologin, txtsubtitlecreateacc;
    Shimmer shimmer;
    private TextView textView, subtitle_header, buttongotologin, txtregistration;
    private Button btnSignUp;
    private EditText etxtName, etxtPassword, etxtMobile, etxtDivision, etxtBloodGroup;
    ProgressDialog loading;
    private RadioGroup radioGroup;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    MaterialSpinner txtSubArea;
    LinearLayout layout;
    String division;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtgotologin = (ShimmerTextView) findViewById(R.id.txtgotologin);
        txtsubtitlecreateacc = (ShimmerTextView) findViewById(R.id.sinup_subtitle_header);
        txtSubArea = findViewById(R.id.sinup_txt_area_signup2);

        subtitle_header = findViewById(R.id.sinup_subtitle_header);
        txtregistration = findViewById(R.id.sinup_textView2);
        buttongotologin = findViewById(R.id.txtgotologin);

        btnSignUp = findViewById(R.id.sinup_button);

        etxtName = findViewById(R.id.sinup_txt_fullname_signup);
        etxtPassword = findViewById(R.id.sinup_txt_password_signup);
        etxtMobile = findViewById(R.id.sinup_txt_mobile_signup);
        //editText4 = findViewById(R.id.txt_area_signup);
        radioGroup = findViewById(R.id.sinup_radiogroup);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        layout = (LinearLayout) findViewById(R.id.sinup_radiogrplayout);

        // sCountry = findViewById(R.id.txt_area_signup);
        etxtDivision = findViewById(R.id.sinup_txt_area_signup);
        etxtBloodGroup = findViewById(R.id.sinup_txt_bloodgroup_signup);
        Typeface tf = Typeface.createFromAsset(getAssets(), "Milkshake.ttf");
        Typeface tf1 = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");

        //txtTitle.setTypeface(tf);
        txtregistration.setTypeface(tf);
       // btnSignUp.setTypeface(tf1);


        // passing animation and start it
     /*   imageView.startAnimation(smalltobig);

        textView.startAnimation(sinup_btta);
        subtitle_header.startAnimation(sinup_btta);

        btnSignUp.startAnimation(sinup_btta2);

        etxtName.startAnimation(sinup_btta2);
        etxtPassword.startAnimation(sinup_btta2);
        etxtMobile.startAnimation(sinup_btta2);
        etxtDivision.startAnimation(sinup_btta2);
        etxtBloodGroup.startAnimation(sinup_btta2);
        layout.startAnimation(sinup_btta2);
*/

        etxtDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] cityList={"Dhaka","Chittagong","Sylhet","Rajshahi","Barishal","Khulna","Rangpur","Mymensingh"};

                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this, R.style.MyDialogTheme);
                builder.setTitle("SELECT DIVISION");
                builder.setIcon(R.drawable.ic_location);


                builder.setCancelable(false);
                builder.setItems(cityList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        switch (position) {
                            case 0:

                                etxtDivision.setText(cityList[position]);
                                division =cityList[position];
                                break;

                            case 1:

                                etxtDivision.setText(cityList[position]);
                                division =cityList[position];
                                break;

                            case 2:

                                etxtDivision.setText(cityList[position]);
                                division =cityList[position];

                                break;

                            case 3:

                                etxtDivision.setText(cityList[position]);
                                division =cityList[position];
                                break;

                            case 4:

                                etxtDivision.setText(cityList[position]);
                                division =cityList[position];
                                break;

                            case 5:

                                etxtDivision.setText(cityList[position]);
                                division =cityList[position];
                                break;

                            case 6:

                                etxtDivision.setText(cityList[position]);
                                division =cityList[position];
                                break;

                            case 7:

                                etxtDivision.setText(cityList[position]);
                                division =cityList[position];
                                break;
                        }



                        String div=etxtDivision.getText().toString();
                        txtSubArea.setText("Select Sub Area");
                        //call method for district
                        list.clear();
                        //            i comment tis                      getDistrict(div);

                        //for better ui response
                        //sleep(500);
                        Log.d("CALL","GET District");
                        // layoutDistrict.setVisibility(View.VISIBLE);

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        dialog.dismiss();
                    }
                });


                AlertDialog locationTypeDialog = builder.create();

                locationTypeDialog.show();



            }

        });



       /* txtSubArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtSubArea.setItems(list);


                txtSubArea.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {


                    @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                        Toast.makeText(SignupActivity.this, "Clicked "+item, Toast.LENGTH_SHORT).show();



                    }
                });




            }
        });*/

        // blood group
        etxtBloodGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] bloodList = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};

                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this, R.style.MyDialogTheme);
                builder.setTitle("SELECT BLOOD GROUP");
                builder.setIcon(R.drawable.ic_blood);


                builder.setCancelable(false);
                builder.setItems(bloodList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        switch (position) {
                            case 0:

                                etxtBloodGroup.setText("A+");
                                break;

                            case 1:

                                etxtBloodGroup.setText("A-");
                                break;

                            case 2:

                                etxtBloodGroup.setText("B+");
                                break;

                            case 3:

                                etxtBloodGroup.setText("B-");
                                break;

                            case 4:

                                etxtBloodGroup.setText("AB+");
                                break;

                            case 5:

                                etxtBloodGroup.setText("AB-");
                                break;

                            case 6:

                                etxtBloodGroup.setText("O+");
                                break;

                            case 7:

                                etxtBloodGroup.setText("O-");
                                break;
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        dialog.dismiss();
                    }
                });


                AlertDialog locationTypeDialog = builder.create();

                locationTypeDialog.show();
            }

        });

        buttongotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        shimmer = new Shimmer();
        shimmer.start(txtgotologin);
        shimmer.start(txtsubtitlecreateacc);
    }
}
