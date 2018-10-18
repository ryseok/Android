package com.encore.intenttest;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        Button bt_call = (Button)findViewById(R.id.bt_call);


        bt_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString(); //tel:010-1234-5678
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(data));
                startActivity(intent);
            }
        });//전화걸면 이동

        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        Button bt_opnen = (Button)findViewById(R.id.bt_open);
        bt_opnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = editText2.getText().toString();

                if(fileName.length() <1){ //입력된 파일명이 없다면
                    Toast.makeText(getApplicationContext(),
                            "PDF 파일명을 입력",Toast.LENGTH_SHORT).show();
                }else{
                    openPDF(fileName.trim());
                }
            }
        }); //PDF열기

    }//onCreate

    private void openPDF(String fileName){
        String sdcardFolder =  Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.d("myTag","SD카드위치>>>" + sdcardFolder);
        String filepath = sdcardFolder+ File.separator+fileName;
        File f =new File(filepath);

        if(f.exists()){ //파일이 실제 존재한다면
            Uri uri = Uri.fromFile(f);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri,"application/pdf");
            startActivity(intent);
        }else{
            Toast.makeText(this,"PDF파일이 없습니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }//openPDF


}