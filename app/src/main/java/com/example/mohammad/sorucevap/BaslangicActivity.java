package com.example.mohammad.sorucevap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BaslangicActivity extends AppCompatActivity {

    private Button yenioyun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baslangic);

        yenioyun = (Button) findViewById(R.id.yeni);
        yenioyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BaslangicActivity.this,SorularveCevaplarActivity.class);
                startActivity(i);
                finish();


            }
        });
    }
}
