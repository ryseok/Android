package com.encore.client;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Server extends AppCompatActivity {

    Button bt_conn,bt_led1,bt_led2,bt_led3,bt_led4,bt_exit;

    String ip = "192.168.0.24"; //라즈베리파이 ip
    int port = 20000; //라즈베리파이 port

    Socket s;
    BufferedReader in;
    OutputStream out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);


        bt_conn = (Button)findViewById(R.id.bt_conn);
        bt_led1 = (Button)findViewById(R.id.bt_led1);
        bt_led2 = (Button)findViewById(R.id.bt_led2);
        bt_led3 = (Button)findViewById(R.id.bt_led3);
        bt_led4 = (Button)findViewById(R.id.bt_led4);
        bt_exit = (Button)findViewById(R.id.bt_exit);

        bt_conn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect();
            }
        }); //연결하기


        bt_led1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg("1");
                if(bt_led1.getText().toString().equals("1번ON")){
                    bt_led1.setText("1번OFF");
                }else{
                    bt_led1.setText("1번ON");
                }
            }
        }); //led1 제어

        bt_led2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg("2");
                if(bt_led1.getText().toString().equals("2번ON")){
                    bt_led1.setText("2번OFF");
                }else{
                    bt_led1.setText("2번ON");
                }
            }
        }); //led2 제어

        bt_led3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg("3");
                if(bt_led1.getText().toString().equals("3번ON")){
                    bt_led1.setText("3번OFF");
                }else{
                    bt_led1.setText("3번ON");
                }
            }
        }); //led3 제어

        bt_led4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg("4");
                if(bt_led1.getText().toString().equals("4번ON")){
                    bt_led1.setText("4번OFF");
                }else{
                    bt_led1.setText("4번ON");
                }
            }
        }); //led4 제어

        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    s.close();
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }); //exit 제어
    }


    //내부클래스
    private void connect() {//라즈베리파이 서버와 (소켓)연결
        try {
            s = new Socket(ip, port);
            in = new BufferedReader( new InputStreamReader(s.getInputStream(),"UTF-8") );
            out = s.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//connect

    private void sendMsg(String msg) {
        try {
            out.write(msg.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//sendMsg


}
