package com.androidlearn.activity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidlearn.service.MyService;
import com.androidlearn.summary.sumarry.R;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button btn1 = findViewById(R.id.btn3_changeToMain);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(ThirdActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button btn = findViewById(R.id.btn3_changeToSec);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        TextView tv = findViewById(R.id.third_tv);
        tv.setText(this.toString()+",taskId="+getTaskId());

        Button btn_service = findViewById(R.id.third_service);
        btn_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mService != null){
                    Message msg = new Message();
                    msg.what = 1;
                    try {
                        mService.send(msg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        bindService(new Intent(this, MyService.class), conn, Service.BIND_AUTO_CREATE);

    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mService = new Messenger(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mService = null;
        }
    };

    private Messenger mService = null;
}
