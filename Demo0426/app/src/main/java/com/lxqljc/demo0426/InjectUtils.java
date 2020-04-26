package com.lxqljc.demo0426;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Author: luoxiaoquan
 * Date: 2020-04-26
 * description: 描述
 */
public class InjectUtils {

    /**
     * 1.自定义注解，将value值(key) 与 成员变量绑定。
     * 2.反射处理，遍历成员变量上的注解标签，拿到value值(key)，再通过反射赋值给变量。
     *
     * @param activity
     */
    public static void injectExtra(Activity activity) {

        Field[] fields = activity.getClass().getDeclaredFields();
        for (Field field : fields) {
            //找到注解标记
            if (field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);
                //得到注解值
                Autowired autowired = field.getAnnotation(Autowired.class);
                String value = autowired.value();
                try {
                    //赋值给变量
                    //Log.d("SecondActivity", "value: " + value);
                    //Log.d("SecondActivity", "injectExtra: " + field.getType());
                     field.set(activity, activity.getIntent().getExtras().get(value));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
