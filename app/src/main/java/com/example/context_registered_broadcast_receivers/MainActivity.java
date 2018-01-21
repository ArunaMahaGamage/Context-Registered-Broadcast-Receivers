package com.example.context_registered_broadcast_receivers;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BroadcastReceiver br = new MyBroadcastReceiver();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(br, filter);


        // Incoming Call

        IntentFilter filter1 = new IntentFilter();
//        filter1.addAction("android.intent.action.PHONE_STATE");
        filter1.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        this.registerReceiver(br,filter1);

    }
}
