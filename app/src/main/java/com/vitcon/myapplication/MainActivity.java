package com.vitcon.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBack;
    private FloatingActionButton mFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setEvent();
    }

    private void setEvent() {
        mBack.setOnClickListener(this);
        mFavorite.setOnClickListener(this);
    }

    private void initData() {

    }

    private void initView() {
        mBack = findViewById(R.id.btn_back);
        mFavorite = findViewById(R.id.fab);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:{
                onBackPressed();
            }
            break;
            case R.id.fab:{
                Toast.makeText(this, "you have clicked favorite", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }
}
