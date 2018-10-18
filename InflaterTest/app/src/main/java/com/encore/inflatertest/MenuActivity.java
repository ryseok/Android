package com.encore.inflatertest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //activity_menu.xml파일내의 컴포넌트 객체생성  ===> 인플레이션 작업!!
        //sub1.xml파일의 객체생성 X

        //MenuActivity에 정의된 리니어레이아웃객체 얻기
        final LinearLayout container = (LinearLayout) findViewById(R.id.sub_container);

        Button bt_sub = (Button) findViewById(R.id.bt_sub);

        bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sub1.xml에 대한 객체생성(인플레이션작업)
                LayoutInflater inflater =
                        (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.sub1,container,true);

                CheckBox cb1 = (CheckBox)container.findViewById(R.id.cb1);//사과
                CheckBox cb2 = (CheckBox)container.findViewById(R.id.cb2);//딸기
                CheckBox cb3 = (CheckBox)container.findViewById(R.id.cb3);//바나나

                //한글텍스트를 영문텍스트로 변경
                cb1.setText("Apple");
                cb2.setText("Strawberry");
                cb3.setText("Banana");

                Toast.makeText(getApplicationContext(),"영문으로 변경하였습니다!!",
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
