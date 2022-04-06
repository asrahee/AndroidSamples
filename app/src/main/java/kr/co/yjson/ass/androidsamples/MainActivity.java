package kr.co.yjson.ass.androidsamples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kr.co.yjson.ass.androidsamples.recyclerview.RecyclerViewSampleActivity;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    private BroadcastReceiver api26_over_broadcast_test_receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        registerReceiver(getTestReceiver(), getTestIntentFilter());

//        LocalBroadCaster.registReceiver(this, getTestReceiver());

        findViewById(R.id.btn_testRecyclerView).setOnClickListener(mOnClickListener);

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                // 리사이클러 뷰 특정 아이템 위치 잡기 테스트 액티비티 실행
                case R.id.btn_testRecyclerView :
                    startActivity(new Intent(MainActivity.this, RecyclerViewSampleActivity.class));
                    break;

                default: break;
            }
        }
    };

    @Override
    public void onResume(){
        super.onResume();

//        PackageManager pm= getPackageManager();
//
////        Intent notiIntent = new Intent(LocalBroadCaster.ACTION_USB_DEVICE_ATTACHED);
////        Intent notiIntent = new Intent(LocalBroadCaster.ACTION_USB_DEVICE_DETACHED);
//        Intent notiIntent = new Intent(LocalBroadCaster.ACTION_TEST_1);
//        List<ResolveInfo> matches=pm.queryBroadcastReceivers(notiIntent, 0);
//
//        for (ResolveInfo resolveInfo : matches) {
//            Intent explicit = new Intent(notiIntent);
//            ComponentName cn = new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name);
//
////            explicit.setComponent(cn);
////            activity.sendBroadcast(explicit);
//
//            Log.i(TAG, "resolveInfo.activityInfo.name : "  + resolveInfo.activityInfo.name);
//        }

        LocalBroadCaster.sendLocalBroadcast(this, new Intent(LocalBroadCaster.ACTION_TEST_1));
    }

    @Override
    public void onPause(){
        super.onPause();

//        unregisterReceiver(api26_over_broadcast_test_receiver);
//        LocalBroadCaster.unregistReceiver(this, api26_over_broadcast_test_receiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public BroadcastReceiver getTestReceiver() {
        if(api26_over_broadcast_test_receiver == null) {
            // api 26(OS 8.0)이상 버전에서의 broadcast receiver 테스트
            api26_over_broadcast_test_receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Log.d(TAG, "onReceive : " + intent.getAction());
                }
            };
        }

        return api26_over_broadcast_test_receiver;
    }

    // m2
    // m3
}
