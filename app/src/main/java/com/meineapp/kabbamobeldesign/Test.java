package com.meineapp.kabbamobeldesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_KabbaMöbelStore);
        setContentView(R.layout.activity_test);

    }
}