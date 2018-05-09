package com.survivrrdev.survivrr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity2 extends AppCompatActivity {
    private final AppCompatActivity activity = SignUpActivity2.this;
    private InputValidation inputValidation;
    private EditText editTextAddress;
    private EditText editTextPhone;
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
        setContentView(R.layout.activity_sign_up2);

        editTextAddress = findViewById(R.id.address);
        editTextPhone = findViewById(R.id.phone);

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
            if (address != null){
                editTextAddress.setText(address);
            }
            if (phone != null){
                editTextPhone.setText(phone);
            }
        }

        Log.d("SUA1", name);
        Log.d("SUA1", birthday);

        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onBackPressed(){
    }

    public void gotoSignUpActivity1(View view) {
        goToPreviousStep();
    }

    public void gotoSignUpActivity3(View view) {
        goToNextStep();
    }

    private void goToPreviousStep(){
        Intent intent = new Intent(activity, SignUpActivity1.class);
        Bundle extras = new Bundle();
        extras.putString("NAME",name);
        extras.putString("BIRTHDAY",birthday);
        extras.putString("ADDRESS",editTextAddress.getText().toString().trim());
        extras.putString("PHONE",editTextPhone.getText().toString().trim());
        extras.putString("BLOOD",bloodType);
        extras.putString("ALLERGIES",allergies);
        extras.putString("MEDICAL",medicalConditions);
        extras.putString("CNAME",contactName);
        extras.putString("CADDR",contactAddress);
        extras.putString("CPHONE",contactPhone);
        extras.putString("USERNAME",username);
        intent.putExtras(extras);
        startActivity(intent);
    }

    private void goToNextStep(){
        if(!inputValidation.isInputEditTextFilled(editTextAddress,
                getString(R.string.error_message_no_address))){
            return;
        }
        if(!inputValidation.isInputEditTextFilled(editTextPhone,
                getString(R.string.error_message_no_phone))){
            return;
        }
        Intent intent = new Intent(activity, SignUpActivity3.class);
        Bundle extras = new Bundle();
        extras.putString("NAME",name);
        extras.putString("BIRTHDAY",birthday);
        extras.putString("ADDRESS",editTextAddress.getText().toString().trim());
        extras.putString("PHONE",editTextPhone.getText().toString().trim());
        extras.putString("BLOOD",bloodType);
        extras.putString("ALLERGIES",allergies);
        extras.putString("MEDICAL",medicalConditions);
        extras.putString("CNAME",contactName);
        extras.putString("CADDR",contactAddress);
        extras.putString("CPHONE",contactPhone);
        extras.putString("USERNAME",username);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
