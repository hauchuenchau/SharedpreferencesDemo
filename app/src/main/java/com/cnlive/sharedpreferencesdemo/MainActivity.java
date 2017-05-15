package com.cnlive.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private EditText input;
    private Button read,write,clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        sharedPreferences=getSharedPreferences(getPackageName(),MODE_PRIVATE);
        editor=sharedPreferences.edit();
        input= (EditText) findViewById(R.id.et_input);
        read= (Button) findViewById(R.id.btn_read);
        write= (Button) findViewById(R.id.btn_write);
        clear= (Button) findViewById(R.id.btn_clear);
        read.setOnClickListener(this);
        write.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_read:
                String str=sharedPreferences.getString("key","没有该数据");
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_write:
                editor.putString("key",input.getText().toString());
                if (editor.commit())Toast.makeText(MainActivity.this,"写入成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_clear:
                editor.clear();
                if (editor.commit())Toast.makeText(MainActivity.this,"清除成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
