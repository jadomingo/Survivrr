package com.survivrrdev.survivrr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity1 extends AppCompatActivity {
    private final AppCompatActivity activity = SignUpActivity1.this;
    private InputValidation inputValidation;
    private EditText editTextName;
    private EditText editTextBirthday;

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
        setContentView(R.layout.activity_sign_up1);

        editTextName = findViewById(R.id.name);
        editTextBirthday = findViewById(R.id.birthday);

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

            if (name != null){
                editTextName.setText(name);
            }
            if (birthday != null){
                editTextBirthday.setText(birthday);
            }
        }

        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onBackPressed(){
    }

    public void gotoMainActivity(View view) {
        Intent intent = new Intent(activity, MainActivity.class);
        startActivity(intent);
    }

    public void gotoSignUpActivity2(View view) {
        goToNextStep();
    }

    private void goToNextStep(){
        if(!inputValidation.isInputEditTextFilled(editTextName,
                getString(R.string.error_message_no_name))){
            return;
        }
        if(!inputValidation.isInputEditTextFilled(editTextBirthday,
                getString(R.string.error_message_no_birthday))){
            return;
        }
        Intent intent = new Intent(activity, SignUpActivity2.class);
        Bundle extras = new Bundle();
        extras.putString("NAME",editTextName.getText().toString().trim());
        extras.putString("BIRTHDAY",editTextBirthday.getText().toString().trim());
        extras.putString("ADDRESS",address);
        extras.putString("PHONE",phone);
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
