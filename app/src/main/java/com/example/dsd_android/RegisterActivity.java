package com.example.dsd_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    Button button_register_Commit;
    Button button_register_Cancel;
    ArrayList<EditText> editTextArrayList = new ArrayList<EditText>();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        button_register_Cancel = findViewById(R.id.Button_register_Cancel);
        button_register_Commit = findViewById(R.id.Button_register_Commit);
        textView = findViewById(R.id.Text_register_Error);
        for(int i = 0; i < 6; i++){
            EditText editText = new EditText(this);
            editTextArrayList.add(editText);
        }
        editTextArrayList.set(0, findViewById(R.id.EditText_register_UserName));
        editTextArrayList.set(1, findViewById(R.id.EditText_register_Password));
        editTextArrayList.set(2, findViewById(R.id.EditText_register_ReinputPassword));
        editTextArrayList.set(3, findViewById(R.id.EditText_register_Birthday));
        editTextArrayList.set(4, findViewById(R.id.EditText_register_PhoneNumber));
        editTextArrayList.set(5, findViewById(R.id.EditText_register_Email));
        GetFromServer getFromServer = new GetFromServer();

        button_register_Commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                String textstring = new String();
                int result_value = -1;
                ArrayList<String> strings = new ArrayList<String>();
                for(int i = 0; i < 6; i++){
                    String string = new String();
                    string = String.valueOf(editTextArrayList.get(i).getText());
                    strings.add(string);
                }
                if(Objects.equals(strings.get(1), strings.get(2))){
                    result_value = getFromServer.register(strings);
                }
                else{
                    textstring = "Two passwords is not equal!";
                }
                if(result_value == 0){
                    button_register_Commit.setEnabled(false);
                    button_register_Commit.setText("Registered");
                }
                else{
                    textstring = textstring + "\nRegister Failed. Please check your information.";
                    textView.setText(textstring);
                }
            }
        });

        button_register_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
