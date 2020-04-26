package com.lxqljc.demo0426;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Author: luoxiaoquan
 * Date: 2020-04-26
 * description: 描述
 */
public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Autowired
    private String name;

    @Autowired("boy")
    private boolean isBoy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        InjectUtils.injectExtra(this);
        Log.d(TAG, "结果是--->" + toString());
    }

    @Override
    public String toString() {
        return "SecondActivity{" +
                "name='" + name + '\'' +
                ", isBoy=" + isBoy +
                '}';
    }
}
