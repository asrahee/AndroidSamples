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

        // master 0310 1
        // home11 0310 1
        // master 0301 2

    }
}
