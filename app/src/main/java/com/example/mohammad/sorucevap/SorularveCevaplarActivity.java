package com.example.mohammad.sorucevap;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SorularveCevaplarActivity extends AppCompatActivity {

    private TextView     soru, zaman, puan;
    private String[]     sorular;
    private String[][]   cevaplar;
    private int[]        cevap;
    private Button       a, b, c, d, pas;
    private int          dogruSayisi=0, clikKontrol, sn=0, soruKontrol=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorularve_cevaplar);

        soru= (TextView) findViewById(R.id.soru);
        puan= (TextView) findViewById(R.id.puan);
        zaman = (TextView) findViewById(R.id.zaman);
        a= (Button) findViewById(R.id.a);
        b= (Button) findViewById(R.id.b);
        c= (Button) findViewById(R.id.c);
        d= (Button) findViewById(R.id.d);
        pas= (Button) findViewById(R.id.pas);

        sorular= new String[]{
                "Galatasaray Futbol Takımı Hangi Tarihte Kurulmuştur.",
                "854*69/5+2 işlemin sonucu kaçtır?",
                "Dağ 2 Filminin Yönetmeni Kimdir?",
                "Aşağıdakilerden Hangisi üzerinde barkotu olan ilk üründür",
                "Daktiloda Yazılan ilk roman aşağıdakilerden hangisidir?"
        };
        //cevap
        cevaplar= new String[][]{
                {"1905","1903","1907","1908"},
                {"12598,89","15874,658","11787,2","13587,4"},
                {"osman sınav","mahsun kırmızı gül","ozan ipek","alper çağlar"},
                {"çikolata","cips","şeker","sakız"},
                {"küçük prens","Tom sawyer","the picture","ayşegül tatilde"}
        };
        // 1 a, 2 b, 3 c, 4 d
        cevap= new int[]{1,3,4,2,4
        };
        //Geri Sayım
        zaman = (TextView) findViewById(R.id.zaman);
        new CountDownTimer(50000,1000) {
            public void onTick(long millisUntilFinished) {
                zaman.setText("" + millisUntilFinished/1000);
                sn++;
                // soru
                soru.setText(sorular[soruKontrol]);
                a.setText(cevaplar[soruKontrol][0]);
                b.setText(cevaplar[soruKontrol][1]);
                c.setText(cevaplar[soruKontrol][2]);
                d.setText(cevaplar[soruKontrol][3]);

                // cevaplar
                a.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(clikKontrol==0) {
                            if (cevap[soruKontrol] == 1) {
                                dogruSayisi += 1;
                                a.setBackgroundColor
                                        (Color.parseColor("#ff669900"));
                                puan.setText("puanınız: "+3*dogruSayisi);
                                // alkis.start();
                            } else {
                                a.setBackgroundColor
                                        (Color.parseColor("red"));
                                //aaaaa.start();
                            }
                            clikKontrol = 1;
                        }
                    }
                });
                b.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(clikKontrol==0) {
                            if (cevap[soruKontrol] == 2) {
                                dogruSayisi += 1;
                                b.setBackgroundColor
                                        (Color.parseColor("#ff669900"));
                                puan.setText("puanınız: "+3*dogruSayisi);
                                // alkis.start();
                            } else {
                                b.setBackgroundColor
                                        (Color.parseColor("red"));
                                //aaaaa.start();
                            }
                            clikKontrol = 1;
                        }
                    }
                });
                c.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(clikKontrol==0) {
                            if (cevap[soruKontrol] == 3) {
                                dogruSayisi += 1;
                                c.setBackgroundColor
                                        (Color.parseColor("#ff669900"));
                                puan.setText("puanınız: "+3*dogruSayisi);
                                // alkis.start();
                            } else {
                                c.setBackgroundColor
                                        (Color.parseColor("red"));
                                //aaaaa.start();
                            }
                            clikKontrol = 1;
                        }
                    }
                });
                d.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(clikKontrol==0) {
                            if (cevap[soruKontrol] == 4) {
                                dogruSayisi += 1;
                                d.setBackgroundColor
                                        (Color.parseColor("#ff669900"));
                                puan.setText("puanınız: "+3*dogruSayisi);
                                // alkis.start();
                            } else {
                                d.setBackgroundColor
                                        (Color.parseColor("red"));
                                //aaaaa.start();
                            }
                            clikKontrol = 1;
                        }
                    }
                });
                // alternatif clikler
                pas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(clikKontrol==0) {
                            clikKontrol = 1;
                        }
                    }
                });
                // yeni soru
                // cevap verdikten yarım sn sonra komut çalışsın
                if(clikKontrol==1){
                    soruKontrol+=1;
                    if (soruKontrol == 4){
                        Toast.makeText(SorularveCevaplarActivity.this,"Oyun Bitti...Puanınız: "+dogruSayisi*3,Toast.LENGTH_LONG).show();
                        Intent i = new Intent(SorularveCevaplarActivity.this,BaslangicActivity.class);
                        startActivity(i);
                        finish();
                    }
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    clikKontrol  =0;
                                    a.setBackgroundColor
                                            (Color.parseColor("#ffd6d7d7"));
                                    b.setBackgroundColor
                                            (Color.parseColor("#ffd6d7d7"));
                                    c.setBackgroundColor
                                            (Color.parseColor("#ffd6d7d7"));
                                    d.setBackgroundColor
                                            (Color.parseColor("#ffd6d7d7"));
                                }
                            }, 500);
                }
            }
            public void onFinish(){
                Toast.makeText(SorularveCevaplarActivity.this,"Oyun Bitti...Puanınız: "+dogruSayisi*3,Toast.LENGTH_LONG).show();
                Intent i = new Intent(SorularveCevaplarActivity.this,BaslangicActivity.class);
                startActivity(i);
                finish();
            }
        }.start();
    }
}
