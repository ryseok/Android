package com.encore.layout;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class ScrollActivity extends AppCompatActivity {
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        ScrollView scrollView = findViewById(R.id.scrollView);//스크롤뷰 컴포넌트 얻기
        ImageView imageView = findViewById(R.id.imageView); //이미지뷰 컴포넌트 얻기
        scrollView.setHorizontalScrollBarEnabled(true);//수평스크롤바 사용

        Resources res = getResources();
        BitmapDrawable bitmap =  (BitmapDrawable)res.getDrawable(R.drawable.image01);
        int w =bitmap.getIntrinsicWidth();
        int h =bitmap.getIntrinsicHeight();


        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width=w;
        imageView.getLayoutParams().height=h;

    }

    public void changeImage(View v){
        ImageView imageView = findViewById(R.id.imageView); //이미지뷰 컴포넌트 얻기

        Resources res = getResources();
        BitmapDrawable bitmap;
        if(flag) {
            bitmap= (BitmapDrawable) res.getDrawable(R.drawable.image01);
        }else{
            bitmap =  (BitmapDrawable)res.getDrawable(R.drawable.image02);
        }
        flag=!flag;

        int w =bitmap.getIntrinsicWidth();
        int h =bitmap.getIntrinsicHeight();

        System.out.println("가로" + w + "세로" + h);
        Log.d("myTag",">>>w:"+w);
        Log.i("myTag",">>>w:"+w);

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width=w;
        imageView.getLayoutParams().height=h;

    }
}