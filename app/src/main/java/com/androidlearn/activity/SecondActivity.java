package com.androidlearn.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidlearn.summary.sumarry.R;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    public SecondActivity(){
        Log.d(TAG, "SecondActivity Created");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn = findViewById(R.id.btn_changeToSec);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button btn_sec = findViewById(R.id.btn_changeToThird);
        btn_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        TextView tv = findViewById(R.id.sec_tv);
        tv.setText(this.toString()+",taskId="+getTaskId());
    }
}
