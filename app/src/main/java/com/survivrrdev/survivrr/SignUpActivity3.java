package com.survivrrdev.survivrr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class SignUpActivity3 extends AppCompatActivity {
    private final AppCompatActivity activity = SignUpActivity3.this;
    private EditText editTextAllergies;
    private EditText editTextMedicalConditions;
    private Spinner spinnerBloodType;
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
        setContentView(R.layout.activity_sign_up3);

        editTextAllergies = findViewById(R.id.allergies);
        editTextMedicalConditions = findViewById(R.id.medConditions);
        //get the spinner from the xml.
        spinnerBloodType = findViewById(R.id.spinner);
        //create a list of items for the spinner.
        String[] items = new String[]{"O", "A", "B", "AB"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        spinnerBloodType.setAdapter(adapter);

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
            if (bloodType != null){
                spinnerBloodType.setSelection(adapter.getPosition(bloodType));
            }
            if (allergies != null){
                editTextAllergies.setText(allergies);
            }
            if (medicalConditions != null){
                editTextMedicalConditions.setText(medicalConditions);
            }
        }

        Log.d("SUA1", name);
        Log.d("SUA1", birthday);
        Log.d("SUA1", phone);
        Log.d("SUA1", address);
    }

    @Override
    public void onBackPressed(){
    }

    public void gotoSignUpActivity2(View view) {
        goToPreviousStep();
    }

    public void gotoSignUpActivity4(View view) {
        goToNextStep();
    }

    private void goToPreviousStep(){
        Intent intent = new Intent(activity, SignUpActivity2.class);
        Bundle extras = new Bundle();
        extras.putString("NAME",name);
        extras.putString("BIRTHDAY",birthday);
        extras.putString("ADDRESS",address);
        extras.putString("PHONE",phone);
        extras.putString("BLOOD",spinnerBloodType.getSelectedItem().toString().trim());
        extras.putString("ALLERGIES",editTextAllergies.getText().toString().trim());
        extras.putString("MEDICAL",editTextMedicalConditions.getText().toString().trim());
        extras.putString("CNAME",contactName);
        extras.putString("CADDR",contactAddress);
        extras.putString("CPHONE",contactPhone);
        extras.putString("USERNAME",username);
        intent.putExtras(extras);
        startActivity(intent);
    }

    private void goToNextStep(){
        Intent intent = new Intent(activity, SignUpActivity4.class);
        Bundle extras = new Bundle();
        extras.putString("NAME",name);
        extras.putString("BIRTHDAY",birthday);
        extras.putString("ADDRESS",address);
        extras.putString("PHONE",phone);
        extras.putString("BLOOD",spinnerBloodType.getSelectedItem().toString().trim());
        extras.putString("ALLERGIES",editTextAllergies.getText().toString().trim());
        extras.putString("MEDICAL",editTextMedicalConditions.getText().toString().trim());
        extras.putString("CNAME",contactName);
        extras.putString("CADDR",contactAddress);
        extras.putString("CPHONE",contactPhone);
        extras.putString("USERNAME",username);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
