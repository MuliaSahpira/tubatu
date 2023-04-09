package com.muliasahpira.tubatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tampilctivity extends AppCompatActivity {
    private Button btn_back;
    private TextView tv_Id, tv_nama, tv_tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilctivity);

        btn_back = (Button) findViewById(R.id.btn_back);
        tv_Id = findViewById(R.id.tv_id);
        tv_nama = findViewById(R.id.tv_nama);
        tv_tanggal = findViewById(R.id.tv_tanggal);

        Intent varIntent = getIntent();
        String id = varIntent.getStringExtra("varId");
        String nama = varIntent.getStringExtra("varNama");
        String Tanggal = varIntent.getStringExtra("varTanggal");

        tv_Id.setText(id);
        tv_nama.setText(nama);
        tv_tanggal.setText(Tanggal);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Tampilctivity.this, MainActivity.class);
                startActivity(back);
            }
        });
    }
}