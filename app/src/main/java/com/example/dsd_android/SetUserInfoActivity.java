package com.example.dsd_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SetUserInfoActivity extends AppCompatActivity {
    Button button_setuserinfo_commit;
    Button button_setuserinfo_cancel;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setuserinfo);
        button_setuserinfo_commit = findViewById(R.id.Button_setuserinfo_Commit);
        button_setuserinfo_cancel = findViewById(R.id.Button_setuserinfo_Cancel);
        textView = findViewById(R.id.Text_setuserinfo_Error);

        ArrayList<EditText> editTextArrayList = new ArrayList<EditText>();
        for(int i = 0; i < 3; i++){
            EditText editText = new EditText(this);
            editTextArrayList.add(editText);
        }
        editTextArrayList.set(0, findViewById(R.id.EditText_setuserinfo_birthday));
        editTextArrayList.set(1, findViewById(R.id.EditText_setuserinfo_phonenumber));
        editTextArrayList.set(2, findViewById(R.id.EditText_setuserinfo_email));
        GetFromServer getFromServer = new GetFromServer();

        button_setuserinfo_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> stringArrayList = new ArrayList<String>();
                for(int i = 0; i < 3; i ++){
                    stringArrayList.add(String.valueOf(editTextArrayList.get(i).getText()));
                }
                int result_value = getFromServer.setuserinfo(stringArrayList);
                if(result_value != 0){
                    textView.setText("Connect to Server Failed. Please retry later.");
                }
                else{
                    button_setuserinfo_commit.setEnabled(false);
                    button_setuserinfo_commit.setText("Committed");
                }
            }
        });


        button_setuserinfo_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
