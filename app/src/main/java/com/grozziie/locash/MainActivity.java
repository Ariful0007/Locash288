package com.grozziie.locash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.grozziie.mylibrary.MessageLibrary;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // MessageLibrary messageLibrary=new MessageLibrary();
       // messageLibrary.mymessage(MainActivity.this,"mY nAME IS ARIF");
        MessageLibrary messageLibrary=new MessageLibrary();

    }
}