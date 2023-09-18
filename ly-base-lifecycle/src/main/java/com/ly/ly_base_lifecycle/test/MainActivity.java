package com.ly.ly_base_lifecycle.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ly.ly_base_lifecycle.R;
import com.ly.ly_base_lifecycle.code.AppLifeCycleManage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}