package com.androidlearn.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidlearn.summary.sumarry.R;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";

    public FirstActivity(){
        Log.d(TAG, "FirstActivity Created");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        TextView tv = findViewById(R.id.textView);
        tv.setText(this.toString()+",taskId="+getTaskId());

        Button btn_first = findViewById(R.id.btn_first);
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button btn_second = findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button btn_third = findViewById(R.id.btn_third);
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(FirstActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        Button btn_startService = findViewById(R.id.btn_StartService);
        btn_startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent =
//                        new Intent(FirstActivity.this, SecondActivity.MyService.class);
//                startService(intent);
            }
        });

        Button btn_stopService = findViewById(R.id.btn_StopService);
        btn_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent =
//                        new Intent(FirstActivity.this, SecondActivity.MyService.class);
//                stopService(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "FirstActivity onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "FirstActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "FirstActivity onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "FirstActivity onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "FirstActivity onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "FirstActivity onRestart");
    }
}
