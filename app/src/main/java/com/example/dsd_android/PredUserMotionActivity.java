package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PredUserMotionActivity extends AppCompatActivity {

    Button button_predusermotion_BackToModel;

    private BaseLinerView baseLinerView;
    private Random r=new Random();

    public int t;

    private void initLine() {
        baseLinerView = new BaseLinerView() {
            @Override
            public String getLineName() {
                return "prediction";
            }
        };
        baseLinerView.mView = findViewById(R.id.liner);
        baseLinerView.lineColor = "#FF6655";
        baseLinerView.lineColor2 = "#FF9593";
        baseLinerView.zeroLine = 0;
        baseLinerView.minValue = 0;
        baseLinerView.maxValue = 6;
        baseLinerView.initView();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predusermotion);
        initLine();
        for(int i=0;i<10;i++){
            baseLinerView.onUdata(r.nextInt(6));
        }
        button_predusermotion_BackToModel=findViewById(R.id.Button_predusermotion_BackToModel);
        button_predusermotion_BackToModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        new Thread(){
            public void run(){
                for(int i=0;i<100;i++){
                    try {
                        sleep(900);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    t=r.nextInt(6);
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            baseLinerView.onUdata(t);
                        }
                    });
                }
            }
        }.start();
    }
}
