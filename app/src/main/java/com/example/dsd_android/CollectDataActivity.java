package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CollectDataActivity extends AppCompatActivity {

    Button button_collectdata_BackToEquip;
    Button button_collectdata_Start;
    Button button_collectdata_End;
    TextView textView_Error;
    TextView textView_Notion;
    int type;
    ArrayList<RadioButton> arrayList = new ArrayList<RadioButton>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectdata);
        button_collectdata_BackToEquip = findViewById(R.id.Button_collectdata_BackToEquip);
        button_collectdata_Start = findViewById(R.id.Button_collectdata_Start);
        button_collectdata_End = findViewById(R.id.Button_collectdata_End);
        textView_Error = findViewById(R.id.Text_collectdata_Error);
        textView_Notion = findViewById(R.id.Text_collectdata_Notion);
        button_collectdata_End.setEnabled(false);
        GetFromServer getFromServer = new GetFromServer();

        button_collectdata_BackToEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for(int i = 0; i < 7; i++){
            RadioButton radioButton = new RadioButton(this);
            arrayList.add(radioButton);
        }

        arrayList.set(0, findViewById(R.id.radio_collectdata_data0));
        arrayList.set(1, findViewById(R.id.radio_collectdata_data1));
        arrayList.set(2, findViewById(R.id.radio_collectdata_data2));
        arrayList.set(3, findViewById(R.id.radio_collectdata_data3));
        arrayList.set(4, findViewById(R.id.radio_collectdata_data4));
        arrayList.set(5, findViewById(R.id.radio_collectdata_data5));
        arrayList.set(6, findViewById(R.id.radio_collectdata_data6));

        for(int i = 0; i < 7; i++){
            int finalI = i;
            arrayList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    type = finalI;
                }
            });
        }

        button_collectdata_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_collectdata_Start.setEnabled(false);
                textView_Error.setText("");
                textView_Notion.setText("");
                int result_value = getFromServer.collectdata_start(type);
                if(result_value != 0){
                    button_collectdata_Start.setEnabled(true);
                    textView_Error.setText("Connection failed. Please retry it later");
                }
                else{
                    button_collectdata_End.setEnabled(true);
                    textView_Notion.setText("Collecting Data. Press 'End' to stop.");
                }
            }
        });

        button_collectdata_End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_collectdata_End.setEnabled(false);
                textView_Error.setText("");
                textView_Notion.setText("");
                int result_value = getFromServer.collectdata_end(type);
                if(result_value != 0){
                    button_collectdata_End.setEnabled(true);
                    textView_Error.setText("Connection failed. Please retry it later");
                }
                else{
                    button_collectdata_Start.setEnabled(true);
                    textView_Notion.setText("Collecting Data stopped.");
                }
            }
        });
    }
}
