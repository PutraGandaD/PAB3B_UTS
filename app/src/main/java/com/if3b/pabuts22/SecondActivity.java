package com.if3b.pabuts22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvNamaSecond;
    TextView tvNoSecond;
    TextView tvJalurSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Top title
        getSupportActionBar().setTitle("Hasil");

        // Define the ID for each variable
        tvNamaSecond = findViewById(R.id.tv_nama_second);
        tvNoSecond = findViewById(R.id.tv_no_second);
        tvJalurSecond = findViewById(R.id.tv_jalur_second);

        // Intent
        Intent secondActivity = getIntent();
        String secondName = secondActivity.getStringExtra("inputName");
        String secondNoPD = secondActivity.getStringExtra("inputNoPD");
        String secondJalur = secondActivity.getStringExtra("selectedJalur");

        // SetText to each variable (value from firstActivity intent)
        tvNamaSecond.setText(secondName);
        tvNoSecond.setText(secondNoPD);
        tvJalurSecond.setText(secondJalur);

        // All condition/logic/code that i used here based on my own knowledge and research without asking to anyone.
        // by Putra Ganda Dewata, November 3rd 2022.
    }
}