package com.habibcse009.registrationapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {
    ShimmerTextView txtgotosigup, txtforlogin;
    Shimmer shimmer;
    private Button buttonlogin;
    ProgressDialog loading;
    String UserCell, UserPassword;
    SharedPreferences sharedPreferences;

    private EditText etxtCell,etxtPassword;

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

        etxtCell=findViewById(R.id.txt_mobile_signup);
        etxtPassword=findViewById(R.id.txt_password_signup);
        buttonlogin = findViewById(R.id.btnlogin_button);


        //Fetching cell from shared preferences
        sharedPreferences = getSharedPreferences(Constant.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String cell = sharedPreferences.getString(Constant.CELL_SHARED_PREF, "Not Available");
        String get_password = sharedPreferences.getString(Constant.PASSWORD_SHARED_PREF, "0");
        UserCell = cell;
        UserPassword = get_password;

        Log.d("Value",UserCell+"  "+UserPassword);

        if (!UserCell.equals("Not Available") && !UserPassword.equals("0") ) {
            etxtCell.setText(UserCell);
            etxtPassword.setText(UserPassword);


           // login();

        }


        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login();
            }
        });

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


//login work start
    private void login() {
        //Getting values from edit texts
        final String userCell = etxtCell.getText().toString().trim();
        final String password = etxtPassword.getText().toString().trim();



        if (userCell.length()!= 11 || userCell.contains(" ") || userCell.charAt(0) != '0' || userCell.charAt(1) != '1') {
            etxtCell.setError("Please enter correct cell !");
            etxtCell.requestFocus();
        }

        //Checking password field/validation
        else if (password.length() < 4) {

            etxtPassword.setError("Password at least 4 character long !");
            etxtPassword.requestFocus();

        } else {
            //showing progress dialog
            loading = new ProgressDialog(this);
            loading.setMessage("Please wait....");
            loading.show();

            //Creating a string request
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.ADMIN_LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            //If we are getting success from server
                            if (response.equalsIgnoreCase("success")) {
                                //Creating a shared preference
                                sharedPreferences= LoginActivity.this.getSharedPreferences(Constant.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                                //Creating editor to store values to shared preferences
                                SharedPreferences.Editor editor = sharedPreferences.edit();

                                //Adding values to editor
                                editor.putBoolean(Constant.LOGGEDIN_SHARED_PREF, true);
                                editor.putString(Constant.CELL_SHARED_PREF, userCell);
                                editor.putString(Constant.PASSWORD_SHARED_PREF, password);

                                //editor.putString(Config.NAME_SHARED_PREF, name);

                                //Saving values to editor
                                editor.apply();

                                loading.dismiss();
                                //Starting profile activity

                                Toasty.success(LoginActivity.this, "Login Success!", Toast.LENGTH_SHORT, true).show();

                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);





                            } else {
                                //If the server response is not success
                                //Displaying an error message on toast

                                Toasty.error(LoginActivity.this, "Invalid cell or password", Toast.LENGTH_SHORT, true).show();
                                //Toast.makeText(LoginActivity.this, "Invalid Cell or password", Toast.LENGTH_LONG).show();
                                loading.dismiss();
                            }
                        }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //You can handle error here if you want

                            Toasty.error(LoginActivity.this, "Error in connection!!", Toast.LENGTH_SHORT, true).show();
                            // Toast.makeText(LoginActivity.this, "Error in connection!!!", Toast.LENGTH_LONG).show();
                            loading.dismiss();
                        }
                    }) {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    //Adding parameters to request
                    params.put(Constant.KEY_CELL, userCell);
                    params.put(Constant.KEY_PASSWORD, password);


                    //returning parameter
                    return params;
                }
            };

            //Adding the string request to the queue
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }

    }
}
