package com.lxqljc.demo0426;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * 注解 + 反射 demo
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("name","lance");
        intent.putExtra("boy",true);
        startActivity(intent);
    }
}
