package com.lxqljc.demo0428;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * 利用反射、注解、动态代理实现OnClick事件的自动注入
 * 步骤：
 * 1.自定义Click注解
 * 2.利用反射解析注解
 * 3.自定义OnClick接口，使用动态代理实现接口回调
 * 4.view设置setOnClickListener，通过动态代理对象回调abc方法
 */
public class MainActivity extends AppCompatActivity implements OnClick {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.inject(this);

    }

    @Click({R.id.btn1, R.id.btn2})
    public void abc(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Log.d(TAG, "onClick: 点击事件1");
                break;

            case R.id.btn2:
                Log.d(TAG, "onClick: 点击事件2");
                break;
        }
    }
}
