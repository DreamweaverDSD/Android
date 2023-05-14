package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowModelInfoActivity extends AppCompatActivity {

    Button button_showmodelinfo_BackToModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmodelinfo);
        button_showmodelinfo_BackToModel=findViewById(R.id.Button_showmodelinfo_BackToModel);
        button_showmodelinfo_BackToModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<TextView> textViewArrayList = new ArrayList<TextView>();
        ArrayList<String> stringArrayList = new ArrayList<String>();
        GetFromServer getFromServer = new GetFromServer();
        stringArrayList = getFromServer.showmodelinfo();
        //ready to get information
        for(int i = 0; i < 2; i++){
            TextView textView = new TextView(this);
            textViewArrayList.add(textView);
        }

        textViewArrayList.set(0, findViewById(R.id.Text_showmodelinfo_info1_right));
        textViewArrayList.set(1, findViewById(R.id.Text_showmodelinfo_info2_right));

        for(int i = 0; i < 2; i++){
            textViewArrayList.get(i).setText(stringArrayList.get(i));
        }
    }
}
