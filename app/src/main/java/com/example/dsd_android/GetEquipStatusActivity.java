package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GetEquipStatusActivity extends AppCompatActivity {

    Button button_getequipstatus_BackToEquip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getequipstatus);
        button_getequipstatus_BackToEquip=findViewById(R.id.Button_getequipstatus_BackToEquip);
        button_getequipstatus_BackToEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<TextView> textViewArrayList = new ArrayList<TextView>();
        ArrayList<String> stringArrayList = new ArrayList<String>();
        GetFromServer getFromServer = new GetFromServer();
        stringArrayList = getFromServer.getequipstatus();
        //ready to get status
        for(int i = 0; i < 12; i++){
            TextView textView = new TextView(this);
            textViewArrayList.add(textView);
        }

        textViewArrayList.set(0, findViewById(R.id.Text_getequipstatus_status1_right));
        textViewArrayList.set(1, findViewById(R.id.Text_getequipstatus_status2_right));
        textViewArrayList.set(2, findViewById(R.id.Text_getequipstatus_status3_right));
        textViewArrayList.set(3, findViewById(R.id.Text_getequipstatus_status4_right));
        textViewArrayList.set(4, findViewById(R.id.Text_getequipstatus_status5_right));
        textViewArrayList.set(5, findViewById(R.id.Text_getequipstatus_status6_right));
        textViewArrayList.set(6, findViewById(R.id.Text_getequipstatus_status7_right));
        textViewArrayList.set(7, findViewById(R.id.Text_getequipstatus_status8_right));
        textViewArrayList.set(8, findViewById(R.id.Text_getequipstatus_status9_right));
        textViewArrayList.set(9, findViewById(R.id.Text_getequipstatus_status10_right));
        textViewArrayList.set(10, findViewById(R.id.Text_getequipstatus_status11_right));
        textViewArrayList.set(11, findViewById(R.id.Text_getequipstatus_status12_right));

        for(int i = 0; i < 12; i++){
            textViewArrayList.get(i).setText(stringArrayList.get(i));
        }
    }
}
