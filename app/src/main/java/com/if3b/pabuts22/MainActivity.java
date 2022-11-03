package com.if3b.pabuts22;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etNamaLengkap;
    EditText etNoPendaftaran;
    Spinner selJalurPendaftaran;
    CheckBox cboxConfirm;
    Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Top Title
        getSupportActionBar().setTitle("Formulir Pendaftaran");

        // Define the ID for each variable
        etNamaLengkap = findViewById(R.id.et_nama_lengkap);
        etNoPendaftaran = findViewById(R.id.et_no_pendaftaran);
        selJalurPendaftaran = findViewById(R.id.sel_jalur_pendaftaran);
        cboxConfirm = findViewById(R.id.cbox_confirm);
        btnDaftar = findViewById(R.id.btn_daftar);

        // Array Adapter, inspired from https://developer.android.com/develop/ui/views/components/spinner#java
        String jalur[] = getResources().getStringArray(R.array.arr_jalur_pendaftaran); // get array values from strings.xml
        ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, jalur);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selJalurPendaftaran.setAdapter(adapter);
        selJalurPendaftaran.setPrompt("Jalur Pendaftaran");

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNamaLengkap.getText().toString();
                String nomorPd = etNoPendaftaran.getText().toString();
                String selectedJalurPD = selJalurPendaftaran.getSelectedItem().toString();

                // Intent
                Intent firstActivity = new Intent(MainActivity.this, SecondActivity.class);
                firstActivity.putExtra("inputName", nama);
                firstActivity.putExtra("inputNoPD", nomorPd);
                firstActivity.putExtra("selectedJalur", selectedJalurPD);

                // Condition for StartActivity and error set.
                // All condition/logic/code that i used here based on my own knowledge and research without asking to anyone.
                // by Putra Ganda Dewata, November 3rd 2022.
                if (nama.trim().equals("") && nomorPd.trim().equals("") && selectedJalurPD.trim().equalsIgnoreCase("pilih jalur pendaftaran...")) {
                    Toast.makeText(MainActivity.this, "Harap lengkapi data anda sebelum melanjutkan!", Toast.LENGTH_SHORT).show();
                } else if (nama.trim().equals("")) {
                    etNamaLengkap.setError("Field nama wajib diisi!");
                } else if (nomorPd.trim().equals("")) {
                    etNoPendaftaran.setError("Field Nomor Pendaftaran wajib diisi!");
                } else if (selectedJalurPD.trim().equalsIgnoreCase("pilih jalur pendaftaran...")) {
                    Toast.makeText(MainActivity.this, "Harap pilih Jalur Pendaftaran sebelum lanjut!", Toast.LENGTH_SHORT).show();
                } else {
                    // cbox state
                    if (cboxConfirm.isChecked()) {
                        startActivity(firstActivity);
                    } else {
                        Toast.makeText(MainActivity.this, "Harap centang Konfirmasi Pendaftaran sebelum melanjutkan!", Toast.LENGTH_SHORT).show();
                    }
                }

                // Debug
                // Toast.makeText(MainActivity.this, "Selected Jalur = " + selectedJalurPD , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
