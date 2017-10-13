package com.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.widget.view.MyStatusView;
import com.widget.view.StatusLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout_container;
    StatusLayout statusLayout;
    MyStatusView statusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout_container = ((LinearLayout) findViewById(R.id.layout_container));
        statusView = MyStatusView.getInstance(this, "暂时没有数据...", new MyStatusView.onRetryClickLister() {
            @Override
            public void onRetryClick() {
                Toast.makeText(MainActivity.this,"正在重試中...",Toast.LENGTH_SHORT).show();
            }
        });
        statusLayout = new StatusLayout.Builder()
                .setContentView(layout_container)
                .setStatusView(statusView)
                .build();
    }

    public void click1(View view) {
        statusLayout.showLoading();
    }

    public void click2(View view) {
        statusLayout.showEmpty();
    }

    public void click3(View view) {
        statusLayout.showContent();
    }

    public void click4(View view) {
        statusLayout.showRetry();
    }

    public void click5(View view) {
        statusLayout.showSetting();
    }
}
