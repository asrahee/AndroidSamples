package kr.co.yjson.ass.androidsamples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class LocalBroadCaster {

    private static final String TAG = LocalBroadCaster.class.getSimpleName();

    public static final String ACTION_TEST_1 = "kr.co.yjson.ass.androidsamples.test1";
    public static final String ACTION_USB_DEVICE_ATTACHED = "android.intent.ACTION_USB_DEVICE_ATTACHED";
    public static final String ACTION_USB_DEVICE_DETACHED = "android.intent.ACTION_USB_DEVICE_DETACHED";


    public static void registReceiver(Context context, BroadcastReceiver receiver){
        Log.d(LocalBroadCaster.class.getSimpleName(), "registReceiver ");
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_TEST_1);

        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, filter);
    }


    public static void unregistReceiver(Context context, BroadcastReceiver receiver){
        Log.d(TAG, "unregistReceiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }

    public static void sendLocalBroadcast(Context context, Intent intent){
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
