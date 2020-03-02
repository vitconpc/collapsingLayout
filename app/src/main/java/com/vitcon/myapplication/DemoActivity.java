package com.vitcon.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class DemoActivity extends AppCompatActivity {

    ConstraintLayout clImage;
    AppBarLayout appBar;
    CircleImageView ivActionbarAvatar;
    LinearLayout viewActionbarInf;
    ImageView ivSubBackGround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        initView();
        initData();
    }

    private void initView() {
        clImage = findViewById(R.id.clImage);
        appBar = findViewById(R.id.appBar);
        ivActionbarAvatar = findViewById(R.id.ivActionbarAvatar);
        viewActionbarInf = findViewById(R.id.viewActionbarInf);
        ivSubBackGround = findViewById(R.id.ivSubBackGround);
    }

    private void initData() {
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float offsetAlpha = appBarLayout.getY()/appBarLayout.getTotalScrollRange();
                clImage.setAlpha(1+offsetAlpha);
                if (offsetAlpha*-1 >0.9){
                    ivActionbarAvatar.setAlpha(offsetAlpha*-1);
                    viewActionbarInf.setAlpha(offsetAlpha*-1);
                    ivSubBackGround.setAlpha(offsetAlpha*-1);
                    Log.e("hello", " >0.7    onOffsetChanged: "+ offsetAlpha );
                }
                else {
                    ivActionbarAvatar.setAlpha(0.0f);
                    viewActionbarInf.setAlpha(0.0f);
                    ivSubBackGround.setAlpha(0.0f);
                    Log.e("hello", " <0.7 ---- onOffsetChanged: "+ offsetAlpha );
                }
            }
        });
    }
}
