package com.muliasahpira.tubatu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etTanggal;
    private Button btnTambah;

    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etTanggal = findViewById(R.id.et_tanggal);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, tanggal;

                nama = etNama.getText().toString();
                tanggal = etTanggal.getText().toString();

                if (nama.trim().equals(""))
                {
                    etNama.setError("Nama Idol Tidak Boleh Kosong");
                }
                else if (tanggal.trim().equals(""))
                {
                    etTanggal.setError("Tanggal Lahir Tidak Boleh Kosong");
                }
                else
                {
                    long eks = myDB.tambahIdol(nama, tanggal);
                    if (eks == -1){
                        Toast.makeText(TambahActivity.this, "Gagal Manambah Data", Toast.LENGTH_SHORT).show();
                        etNama.requestFocus();
                    }
                    else
                    {
                        Toast.makeText(TambahActivity.this, "Berhasil Menambah Data", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}