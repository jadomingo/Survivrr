package com.survivrrdev.survivrr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainWindowActivity extends AppCompatActivity {
    private final AppCompatActivity activity = MainWindowActivity.this;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            username = extras.getString("USERNAME");
        }
    }

    @Override
    public void onBackPressed(){
    }

    public void onAmbulancePressed(){

    }

    public void onPolicePressed(){

    }

    public void onFireDeptPressed(){

    }
}
