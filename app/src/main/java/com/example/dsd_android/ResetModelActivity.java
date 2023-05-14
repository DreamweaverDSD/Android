package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ResetModelActivity extends AppCompatActivity {

    Button button_resetmodel_BackToModel;
    Button button_resetmodel_Submit;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetmodel);
        button_resetmodel_BackToModel=findViewById(R.id.Button_resetmodel_BackToModel);
        button_resetmodel_BackToModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        GetFromServer getFromServer = new GetFromServer();
        button_resetmodel_Submit=findViewById(R.id.Button_resetmodel_Submit);
        textView=findViewById(R.id.Text_resetmodel_Error);
        String error_string = new String("Connect to Server Failed. Please retry later.");
        button_resetmodel_Submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                button_resetmodel_Submit.setEnabled(false);
                button_resetmodel_BackToModel.setEnabled(false);
                int result_value = getFromServer.resetmodel();
                if(result_value != 0){
                    button_resetmodel_Submit.setEnabled(true);
                    textView.setText(error_string);
                }
                else{
                    button_resetmodel_Submit.setText("Reseted");
                }
                button_resetmodel_BackToModel.setEnabled(true);
            }
        });
    }
}
