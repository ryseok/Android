package com.encore.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //이벤트 핸들러 추가
    public void onBackButtonClicked(View v){
        Toast.makeText(getApplicationContext(),"되돌아가기", Toast.LENGTH_SHORT).show();
        finish(); //현재 화면 종료
    }
}
