package com.example.dsd_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserInfoActivity extends AppCompatActivity {

    Button button_userinfo_BackToMain;
    Button button_userinfo_SetUserinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        button_userinfo_SetUserinfo = findViewById(R.id.Button_userinfo_SetUserInfo);
        button_userinfo_SetUserinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, SetUserInfoActivity.class);
                startActivity(intent);
            }
        });

        button_userinfo_BackToMain = findViewById(R.id.Button_userinfo_BackToMain);
        button_userinfo_BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
