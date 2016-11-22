package com.kevin.tech.coordinatordemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kevin.tech.coordinatordemo.adapter.FirstRecyclerAdapter;
import com.kevin.tech.coordinatordemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/11/22.
 * Blog:http://blog.csdn.net/student9128
 * Description:
 */

public class FirstActivity extends AppCompatActivity{
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private List<String> mData = new ArrayList<>();
    private FirstRecyclerAdapter mAdapter;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinaotr_layout);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(FirstActivity.this));
        mAdapter = new FirstRecyclerAdapter(mData, FirstActivity.this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            mData.add("Android" + i);
        }
    }
}
