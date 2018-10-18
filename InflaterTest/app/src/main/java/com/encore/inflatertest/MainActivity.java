package com.encore.inflatertest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //화면정보(뷰컴포넌트,레이아웃)얻기, 메모리할당 (activity_main.xml에 있는 bt버튼 객체생성!!)

        Button bt = (Button)findViewById(R.id.bt);
        Log.d("myTag","bt>>>"+bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"눌렀니?",Toast.LENGTH_SHORT).show();
            }
        });

        //대화상자 띄우기 ===> 데이터 저장
        Button bt_dialog = (Button) findViewById(R.id.bt_dialog);

        bt_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Menu2Activity.class);
                //startActivity(intent);//화면 이동
                startActivityForResult(intent, 101);//화면이동, 이동된 화면에서 저장된 데이터 얻기
            }
        });
    }//onCreate

    //startActivityForResult후에 실행되는 콜백함수!!
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("myTag","requestCode>>>"+requestCode);
        Log.d("myTag","resultCode>>>"+ resultCode);

        if (requestCode== 101){//Menu2Activity를 실행하고 되돌아 왔다면
            /*
               Toast.makeText(getApplicationContext(),
                    "요청코드(호출시 부여된 번호):"+ requestCode+
                ",결과 코드: "+ resultCode, Toast.LENGTH_LONG).show();
                */
            if(resultCode==RESULT_OK){
                String name = data.getExtras().getString("username");
                Toast.makeText(getApplicationContext(),
                        "응답 이름:"+ name,Toast.LENGTH_SHORT).show();
            }
        }


    }
}//클래스
