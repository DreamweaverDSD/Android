package com.example.dsd_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SetUserInfoActivity extends AppCompatActivity {
    Button button_setuserinfo_commit;
    Button button_setuserinfo_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setuserinfo);

        button_setuserinfo_commit = findViewById(R.id.Button_setuserinfo_Commit);
        button_setuserinfo_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_setuserinfo_cancel = findViewById(R.id.Button_setuserinfo_Cancel);
        button_setuserinfo_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
