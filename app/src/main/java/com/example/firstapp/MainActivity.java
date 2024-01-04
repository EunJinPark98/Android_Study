package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_test;


    private Button btn_move;
    private EditText et_str;
    private String str;

    EditText et_save;
    String shared = "file";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);


        btn_test = findViewById(R.id.btn_test);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_id.setText("나는왜앱을개발하는가");
            }
        });

        et_str = findViewById(R.id.et_str);

        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_str.getText().toString();
                Intent intent = new Intent(MainActivity.this , SubActivity.class);
                intent.putExtra("str", str);
                startActivity(intent);
            }
        });

        /*데이터 공유하기*/
        et_save = (EditText) findViewById(R.id.et_save);
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("eunjin", "");
        et_save.setText(value);



    }

    @Override
    protected void onDestroy() {        /*앱 나갔을 때 실행*/
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();
        editor.putString("eunjin", value);
        editor.commit();
    }
}