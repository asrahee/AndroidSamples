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

        // 0324 master 1ss
        // 0324 master 1ss

        // 0324 master test 1

        // 0324 home 0324 test 1
        // 0324 home 0324 test 2

        // 0324 home 0324 test 3
        // 0324 home 0324 test 4
    }
}