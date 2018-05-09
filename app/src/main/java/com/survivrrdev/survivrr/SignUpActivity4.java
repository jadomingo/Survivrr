package com.survivrrdev.survivrr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity4 extends AppCompatActivity {
    private final AppCompatActivity activity = SignUpActivity4.this;
    private EditText editTextContactName;
    private EditText editTextContactAddress;
    private EditText editTextContactPhone;
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
        setContentView(R.layout.activity_sign_up4);

        editTextContactName = findViewById(R.id.contactName);
        editTextContactAddress = findViewById(R.id.contactAddress);
        editTextContactPhone = findViewById(R.id.contactPhone);

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
            if (contactName != null){
                editTextContactName.setText(contactName);
            }
            if (contactAddress != null){
                editTextContactAddress.setText(contactAddress);
            }
            if (contactPhone != null){
                editTextContactPhone.setText(contactPhone);
            }
        }

        Log.d("SUA1", name);
        Log.d("SUA1", birthday);
        Log.d("SUA1", phone);
        Log.d("SUA1", address);
        Log.d("SUA1", bloodType);
        Log.d("SUA1", allergies);
        Log.d("SUA1", medicalConditions);
    }

    @Override
    public void onBackPressed(){
    }

    public void goToSignUpActivity3(View view) {
        goToPreviousStep();
    }

    public void goToSignUpPWPrompt(View view) {
        goToNextStep();
    }

    private void goToPreviousStep(){
        Intent intent = new Intent(activity, SignUpActivity3.class);
        Bundle extras = new Bundle();
        extras.putString("NAME",name);
        extras.putString("BIRTHDAY",birthday);
        extras.putString("ADDRESS",address);
        extras.putString("PHONE",phone);
        extras.putString("BLOOD",bloodType);
        extras.putString("ALLERGIES",allergies);
        extras.putString("MEDICAL",medicalConditions);
        extras.putString("CNAME",editTextContactName.getText().toString().trim());
        extras.putString("CADDR",editTextContactAddress.getText().toString().trim());
        extras.putString("CPHONE",editTextContactPhone.getText().toString().trim());
        extras.putString("USERNAME",username);
        intent.putExtras(extras);
        startActivity(intent);
    }

    private void goToNextStep(){
        Intent intent = new Intent(activity, SignUpPWPrompt.class);
        Bundle extras = new Bundle();
        extras.putString("NAME",name);
        extras.putString("BIRTHDAY",birthday);
        extras.putString("ADDRESS",address);
        extras.putString("PHONE",phone);
        extras.putString("BLOOD",bloodType);
        extras.putString("ALLERGIES",allergies);
        extras.putString("MEDICAL",medicalConditions);
        extras.putString("CNAME",editTextContactName.getText().toString().trim());
        extras.putString("CADDR",editTextContactAddress.getText().toString().trim());
        extras.putString("CPHONE",editTextContactPhone.getText().toString().trim());
        extras.putString("USERNAME",username);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
