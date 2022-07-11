package kr.co.yjson.ass.androidsamples.recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.co.yjson.ass.androidsamples.R;

public class RecyclerViewSampleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager layoutManager;

    private ScrollHandler mScrollHandler;

    private final int TEN       = 10;
    private final int TWEENTY   = 20;
    private final int THIRTY    = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recyclerview);

        recyclerView = findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(getSampleList().toArray(new String[getSampleList().size()]));
        recyclerView.setAdapter(mAdapter);

        findViewById(R.id.btnFocus10).setOnClickListener(mOnClickListener);
        findViewById(R.id.btnFocus20).setOnClickListener(mOnClickListener);
        findViewById(R.id.btnFocus30).setOnClickListener(mOnClickListener);

        mScrollHandler = new ScrollHandler();
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                // 리사이클러 뷰 특정 아이템 위치 잡기 테스트 액티비티 실행
                case R.id.btnFocus10 :
//                    mScrollHandler.sendEmptyMessageDelayed(TEN, 100);
                    layoutManager.scrollToPositionWithOffset(TEN, 0);
                    break;

                case R.id.btnFocus20 :
//                    mScrollHandler.sendEmptyMessageDelayed(TWEENTY, 100);
                    layoutManager.scrollToPositionWithOffset(TWEENTY, 0);
                    break;

                case R.id.btnFocus30 :
//                    mScrollHandler.sendEmptyMessageDelayed(THIRTY, 100);
                    layoutManager.scrollToPositionWithOffset(THIRTY, 0);
                    break;

                default: break;
            }
        }
    };

    private class ScrollHandler extends Handler {
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);

            switch(msg.what){
                case TEN :
//                    layoutManager.scrollToPosition(TEN);
                    layoutManager.scrollToPositionWithOffset(TEN, 0);
                    break;

                case TWEENTY :
//                    layoutManager.scrollToPosition(TWEENTY);
//                    recyclerView.scrollToPosition(TWEENTY);
                    layoutManager.scrollToPositionWithOffset(TWEENTY, 0);
                    break;

                case THIRTY :
//                    layoutManager.scrollToPosition(THIRTY);
//                    recyclerView.scrollToPosition(THIRTY);
                    layoutManager.scrollToPositionWithOffset(THIRTY, 0);
                    break;
            }
        }
    }

    private ArrayList<String> getSampleList(){
        ArrayList<String> sampleList = new ArrayList<>();
        for(int i = 0 ; i < 50 ; i++){
            sampleList.add(String.valueOf(i));
        }

        return sampleList;
    }

}
