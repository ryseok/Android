package com.encore.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SmSActivity extends AppCompatActivity {
    EditText editText;      // 메세지 입력 뷰
    TextView textView;      // 작성 글자 수 나타내는 뷰
    Button button;          // 작성 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm_s);


        editText = (EditText) findViewById(R.id.editText);      // 뷰 지정
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        editText.addTextChangedListener(new TextWatcher() {     // addTextChangedListener 텍스트가 입력에 따라 변경될 때마다 확인하는 기능
            // TextWatcher 텍스트가 변경될 때마다 발생하는 이벤트 처리하는 인터페이스
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                InputFilter[] filter = new InputFilter[1];
                filter[0] = new InputFilter.LengthFilter(40);       // 쓸 수 있는 글자 수 최대 40자로 제한
                editText.setFilters(filter);

                int currentBytes = s.toString().getBytes().length;      // 텍스트 내용을 받아와서 바이트 수를 가져온다.
                String txt = String.valueOf(currentBytes) + " / 80 바이트";
                textView.setText(txt);                                  // 텍스트뷰에 현재 바이트수 표시

            }

            public void afterTextChanged(Editable s) {}

        });
    }

    public void smsClicked(View v) {
        Toast.makeText(getApplicationContext(), (CharSequence) editText.getText(), Toast.LENGTH_LONG).show();
    }   // 전송 버튼을 클릭하면 작성된 메시지를 토스트로 띄어준다.
    // editText.getText()의 반환형은 editable 이므로 CharSequence 타입으로 형변환 해준다.

    public void smsClicked2(View v) {
        finish();
    }
}
