package com.cnlive.sharedpreferencesdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @Author Mr.hou
 * @time 2017/5/15
 * @Desc
 */

public class UitlTestActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_input;
    private Button insert, query, delete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utiltest);
        initview();
    }

    private void initview() {
        et_input= (EditText) findViewById(R.id.et_input);
        insert= (Button) findViewById(R.id.btn_write);
        query= (Button) findViewById(R.id.btn_read);
        delete= (Button) findViewById(R.id.btn_clear);
        insert.setOnClickListener(this);
        query.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_write:
                String str=et_input.getText().toString();
                SharedPreferencesHelper.getInstance(UitlTestActivity.this).setValue("hou",str);
                break;
            case R.id.btn_read:
                SharedPreferencesHelper.getInstance(UitlTestActivity.this).getValue("hou");
                String text=SharedPreferencesHelper.getInstance(UitlTestActivity.this).getValue("hou");
                break;
            case R.id.btn_clear:
                SharedPreferencesHelper.getInstance(UitlTestActivity.this).clear();
                break;
        }
    }
}
