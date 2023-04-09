package com.muliasahpira.tubatu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper myDB;
    private FloatingActionButton fabTambah;
    private RecyclerView rvIdol;
    private AdapterIdol adIdol;
    private ArrayList<String> arrID, arrNama, arrTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvIdol = findViewById(R.id.rv_idol);

        myDB = new MyDatabaseHelper(MainActivity.this);

        fabTambah = findViewById(R.id.fab_tambah);
        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tampilIdol();
    }

    private void SQliteToArrayList(){
        Cursor varCursor = myDB.bacaDataPlayer();
        if (varCursor.getCount() == 0){
            Toast.makeText(this, "Tidak Ada Data", Toast.LENGTH_SHORT).show();
        }
        else {
            while (varCursor.moveToNext()){
                arrID.add(varCursor.getString(0));
                arrNama.add(varCursor.getString(1));
                arrTanggal.add(varCursor.getString(2));
            }
        }
    }

    private void tampilIdol(){
        arrID = new ArrayList<>();
        arrNama = new ArrayList<>();
        arrTanggal = new ArrayList<>();

        SQliteToArrayList();

        adIdol = new AdapterIdol(MainActivity.this, arrID, arrNama, arrTanggal);

        rvIdol.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvIdol.setAdapter(adIdol);
    }
}