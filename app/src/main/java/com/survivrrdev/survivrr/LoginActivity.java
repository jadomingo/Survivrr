package com.survivrrdev.survivrr;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private final AppCompatActivity activity = LoginActivity.this;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private ConstraintLayout constraintLayout;
    private InputValidation inputValidation;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        constraintLayout = findViewById(R.id.constraintLayout);
        editTextUsername = findViewById(R.id.address);
        editTextPassword = findViewById(R.id.password);

        dbHelper = new DBHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onBackPressed(){
    }

    public void login(View view){
        verifyFromSQLite();
    }

    public void goToMainActivity(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void verifyFromSQLite(){
        if(!inputValidation.isInputEditTextFilled(editTextUsername,
                getString(R.string.error_message_username))){
            return;
        }
        if(!inputValidation.isInputEditTextFilled(editTextPassword,
                getString(R.string.error_message_password))){
            return;
        }

        if(dbHelper.checkUserInfo(editTextUsername.getText().toString().trim(),
                editTextPassword.getText().toString().trim())){
            Intent intent = new Intent(activity, MainWindowActivity.class);
            intent.putExtra("USERNAME", editTextUsername.getText().toString().trim());
            emptyInputEditText();
            startActivity(intent);
        } else {
            Snackbar.make(constraintLayout, getString(R.string.error_valid_username_password),
                    Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText(){
        editTextUsername.setText(null);
        editTextPassword.setText(null);
    }
}
