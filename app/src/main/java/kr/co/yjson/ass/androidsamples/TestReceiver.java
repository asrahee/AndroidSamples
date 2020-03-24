package kr.co.yjson.ass.androidsamples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TestReceiver extends BroadcastReceiver {
    private final static String TAG = TestReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive action : " + intent.getAction());

        // 0325 master 1
        // 0325 master 2
        // 0325 home 1
        // 0325 home 2
    }
}