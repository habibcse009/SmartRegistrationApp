package com.habibcse009.registrationapp;
public class Constant {


    public static final String MAIN_URL="http://bloodbank24.cf";

    public static final String DOCTOR_APPOINTMENT_URL = MAIN_URL+"/android/dr_appointment.php";
    public static final String PATIENT_PROFILE_URL = MAIN_URL+"/android/patient_profile.php?cell=";

    public static final String DONOR_PROFILE_URL = MAIN_URL+"/android/donor_profile.php?cell=";

    public static final String PATIENT_PROFILE_UPDATE_URL = MAIN_URL+"/android/update_patient_profile.php";

    public static final String DONOR_PROFILE_UPDATE_URL = MAIN_URL+"/android/update_donor_profile.php";

    public static final String DOCTOR_PROFILE_UPDATE_URL = MAIN_URL+"/android/update_doctor_profile.php";
    //access db from device
    public static final String LOGIN_URL = MAIN_URL+"/android/login.php";
    public static final String ADMIN_LOGIN_URL = MAIN_URL+"/android/login_administrator.php";


    public static final String GET_AREA_URL = MAIN_URL+"/android/get_area.php?division=";



    public static final String SHOW_DONOR_URL = MAIN_URL+"/android/donor_list.php";


    public static final String SHOW_NEWS_URL = MAIN_URL+"/android/news_list.php";



    public static final String SIGNUP_URL = MAIN_URL+"/android/signup.php";
    public static final String ADMIN_SIGNUP_URL = MAIN_URL+"/android/signup_administrator.php";

    public static final String BLOOD_REQUEST_URL = MAIN_URL+"/android/blood_request.php";


    public static final String KEY_DISTRICT = "district";
    public static final String KEY_SUB_AREA = "sub_area";

    //If server response is equal to this that means login is successful
    public static final String SIGNUP_SUCCESS = "success";
    public static final String USER_EXISTS = "exists";


    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_TEST_ID = "test_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PRICE = "price";
    public static final String KEY_CELL = "cell";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_CABIN = "cabin";
    public static final String KEY_LOCATION = "location";

    public static final String KEY_LATITUDE = "latitude";

    public static final String KEY_LONGITUDE = "longitude";

    public static final String KEY_DONATE_DATE = "donate_date";
    public static final String KEY_STATUS = "status";
    public static final String KEY_PROFILE_NOT_COMPLETED = "0";

    public static final String KEY_AGE = "age";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_BLOOD_GROUP = "blood_group";
    public static final String KEY_DATE = "date";
    public static final String KEY_DIAGONOSTIC_CENTER_ID = "diago_id";






    public static final String KEY_DIAGO_NAME = "diago_name";
    public static final String KEY_TEST_NAME = "test_name";

    public static final String KEY_DR_NAME = "dr_name";

    public static final String KEY_DR_DEGREE = "dr_degree";

    public static final String KEY_DR_TIME = "dr_time";


    public static final String KEY_AC_TYPE = "ac_type";

    public static final String KEY_APPOINT_DATE= "appoint_date";
    public static final String KEY_NOTE= "note";





    public static final String KEY_DR_GENDER = "dr_gender";
    public static final String KEY_DR_FEE= "dr_fee";
    public static final String KEY_DR_SPECIALITY = "dr_speciality";

    public static final String KEY_DR_ADDRESS = "dr_address";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_DIVISION = "division";
    public static final String KEY_BAG= "bag";
    public static final String KEY_CONTACT = "contact";

    public static final String KEY_TYPE = "type";
    public static final String KEY_USER_CELL= "user_cell";





    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_SPECIALIST = "specialist";
    public static final String KEY_DR_MODE = "dr_mode";
    public static final String JSON_ARRAY = "result";

    public static final String KEY_PRESCRIPTION = "prescription";
    public static final String KEY_INFO = "info";
    public static final String KEY_PULSE = "pulse";
    public static final String KEY_DISEASE = "disease";
    public static final String KEY_WEIGHT = "weight";
    public static final String KEY_TEST = "test";


    public static final String KEY_TIME = "time";
    public static final String KEY_FULL_ADDRESS = "full_address";
    public static final String KEY_DEGREE= "degree";
    public static final String KEY_FEE= "fee";
    public static final String KEY_SPECIALITY = "speciality";

    public static final String KEY_MODE = "mode";
    public static final String KEY_ID = "id";

    //We will use this to store the user cell number into shared preference
    public static final String SHARED_PREF_NAME = "com.app.android.userlogin"; //pcakage name+ id

    //This would be used to store the cell of current logged in user
    public static final String CELL_SHARED_PREF = "cell";
    public static final String PASSWORD_SHARED_PREF = "password";
    public static final String AC_TYPE_SHARED_PREF = "ac_type";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";

}
