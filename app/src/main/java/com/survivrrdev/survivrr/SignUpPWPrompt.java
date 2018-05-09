package com.survivrrdev.survivrr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SignUpPWPrompt extends AppCompatActivity {
    private final AppCompatActivity activity = SignUpPWPrompt.this;
    private InputValidation inputValidation;
    private DBHelper dbHelper;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextPassConfirm;
    private String name;
    private String birthday;
    private String address;
    private String phone;
    private String bloodType;
    private String allergies;
    private String medicalConditions;
    private String contactName;
    private String contactAddress;
    private String contactPhone;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_pwprompt);

        editTextUsername = findViewById(R.id.address);
        editTextPassword = findViewById(R.id.password);
        editTextPassConfirm = findViewById(R.id.confirmPassword);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            name = extras.getString("NAME");
            birthday = extras.getString("BIRTHDAY");
            address = extras.getString("ADDRESS");
            phone = extras.getString("PHONE");
            bloodType = extras.getString("BLOOD");
            allergies = extras.getString("ALLERGIES");
            medicalConditions = extras.getString("MEDICAL");
            contactName = extras.getString("CNAME");
            contactAddress = extras.getString("CADDR");
            contactPhone = extras.getString("CPHONE");
            username = extras.getString("USERNAME");
        }

        Log.d("SUA1", name);
        Log.d("SUA1", phone);
        Log.d("SUA1", address);
        Log.d("SUA1", birthday);
        Log.d("SUA1", contactName);
        Log.d("SUA1", contactPhone);
        Log.d("SUA1", contactAddress);
        Log.d("SUA1", bloodType);
        Log.d("SUA1", allergies);
        Log.d("SUA1", medicalConditions);

        dbHelper = new DBHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onBackPressed(){
    }

    public void goToLoginActivity(View view) {
        goToNextStep();
    }

    public void gotoSignUpActivity4(View view) {
        goToPreviousStep();
    }

    private void goToNextStep(){
        if(!inputValidation.isInputEditTextFilled(editTextUsername,
                getString(R.string.error_message_username))){
            return;
        }
        if(!inputValidation.isInputEditTextFilled(editTextPassword,
                getString(R.string.error_message_password))){
            return;
        }
        if(!inputValidation.isInputEditTextFilled(editTextPassConfirm,
                getString(R.string.error_message_confirm_password))){
            return;
        }
        if(!inputValidation.isInputEditTextMatches(editTextPassword,editTextPassConfirm,
                getString(R.string.error_message_password_mismatch))){
            return;
        }
        //  Check if username already exists
        if(dbHelper.checkUserInfo(editTextPassword.getText().toString().trim())){
            editTextUsername.setError(getText(R.string.error_message_username_already_exists));
            return;
        } else {
            editTextUsername.setError(null);
        }

        dbHelper.insertUserInfo(username,editTextPassword.getText().toString(),name,phone,address,
                birthday,null,contactName,contactPhone,contactAddress,bloodType,allergies,
                medicalConditions);

        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
    }

    private void goToPreviousStep(){
        Intent intent = new Intent(activity, SignUpActivity4.class);
        Bundle extras = new Bundle();
        extras.putString("NAME",name);
        extras.putString("BIRTHDAY",birthday);
        extras.putString("ADDRESS",address);
        extras.putString("PHONE",phone);
        extras.putString("BLOOD",bloodType);
        extras.putString("ALLERGIES",allergies);
        extras.putString("MEDICAL",medicalConditions);
        extras.putString("CNAME",contactName);
        extras.putString("CADDR",contactAddress);
        extras.putString("CPHONE",contactPhone);
        extras.putString("USERNAME",editTextUsername.getText().toString().trim());
        intent.putExtras(extras);
        startActivity(intent);
    }
}
