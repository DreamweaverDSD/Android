package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GetEquipInfoActivity extends AppCompatActivity {

    Button button_getequipinfo_BackToEquip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getequipinfo);
        button_getequipinfo_BackToEquip=findViewById(R.id.Button_getequipinfo_BackToEquip);
        button_getequipinfo_BackToEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<TextView> textViewArrayList = new ArrayList<TextView>();
        ArrayList<String> stringArrayList = new ArrayList<String>();
        GetFromServer getFromServer = new GetFromServer();
        stringArrayList = getFromServer.getequipinfo();
        //ready to get information
        for(int i = 0; i < 12; i++){
            TextView textView = new TextView(this);
            textViewArrayList.add(textView);
        }

        textViewArrayList.set(0, findViewById(R.id.Text_getequipinfo_info1_right));
        textViewArrayList.set(1, findViewById(R.id.Text_getequipinfo_info2_right));
        textViewArrayList.set(2, findViewById(R.id.Text_getequipinfo_info3_right));
        textViewArrayList.set(3, findViewById(R.id.Text_getequipinfo_info4_right));
        textViewArrayList.set(4, findViewById(R.id.Text_getequipinfo_info5_right));
        textViewArrayList.set(5, findViewById(R.id.Text_getequipinfo_info6_right));
        textViewArrayList.set(6, findViewById(R.id.Text_getequipinfo_info7_right));
        textViewArrayList.set(7, findViewById(R.id.Text_getequipinfo_info8_right));
        textViewArrayList.set(8, findViewById(R.id.Text_getequipinfo_info9_right));
        textViewArrayList.set(9, findViewById(R.id.Text_getequipinfo_info10_right));
        textViewArrayList.set(10, findViewById(R.id.Text_getequipinfo_info11_right));
        textViewArrayList.set(11, findViewById(R.id.Text_getequipinfo_info12_right));

        for(int i = 0; i < 12; i++){
            textViewArrayList.get(i).setText(stringArrayList.get(i));
        }

    }
}
