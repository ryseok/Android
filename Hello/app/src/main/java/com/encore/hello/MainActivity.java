package com.encore.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //이벤트 핸들러(버튼 클릭시 실행할 메소드)
    public void onButton1Cilcked(View v){
        Toast t = Toast.makeText(getApplicationContext(),"시작 버튼이 눌렸어요", Toast.LENGTH_LONG);
        t.show();
    }

    public void moveBrowser (View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    public void moveCall (View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234-5678"));
        startActivity(myIntent);
    }

    //버튼 클릭시 새로운 액티비티 이동
    public void moveOtherActivity(View v){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }
}
