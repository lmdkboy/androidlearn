package com.androidlearn.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private final static String TAG = "MyService";
    private final int MESSAGE_ID = 1;

    private class IncomingHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MESSAGE_ID:
                    //Log.d(TAG, "Service has receive message.");
                    Toast.makeText(MyService.this,
                            "Service has receive msg.", Toast.LENGTH_SHORT).show();

                    break;
            }
            super.handleMessage(msg);
        }
    }


    private Messenger msger = new Messenger(new IncomingHandler());

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return msger.getBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
