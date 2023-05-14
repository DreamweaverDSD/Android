package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UnbindEquipActivity extends AppCompatActivity {

    Button button_unbindequip_BackToEquip;
    Button button_unbindequip_Submit;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unbindequip);
        button_unbindequip_BackToEquip=findViewById(R.id.Button_unbindequip_BackToEquip);
        button_unbindequip_BackToEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        GetFromServer getFromServer = new GetFromServer();
        button_unbindequip_Submit=findViewById(R.id.Button_unbindequip_Submit);
        textView=findViewById(R.id.Text_unbindequip_Error);
        String error_string = new String("Connect to Server Failed. Please retry later.");
        button_unbindequip_Submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                button_unbindequip_Submit.setEnabled(false);
                button_unbindequip_BackToEquip.setEnabled(false);
                int result_value = getFromServer.unbindequip();
                if(result_value != 0){
                    button_unbindequip_Submit.setEnabled(true);
                    textView.setText(error_string);
                }
                else{
                    button_unbindequip_Submit.setText("Reseted");
                }
                button_unbindequip_BackToEquip.setEnabled(true);
            }
        });
    }
}
