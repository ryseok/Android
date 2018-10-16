package com.encore.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImgChViewActivity extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_ch_view);

        img1=findViewById(R.id.image1);
        img2=findViewById(R.id.image2);
    }

    public void onButtonClick(View v) {
        flag = !flag;

        if (!flag) {
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
        } else {
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);

        }
    }
    public void onButtonClick2(View v) {
        flag = !flag;

        if (!flag) {
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
        } else {
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);

        }
    }
}
