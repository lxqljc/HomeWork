package com.lxqljc.demo0428;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: luoxiaoquan
 * Date: 2020-05-05
 * description: 反射工具
 */
public class InjectUtils {

    /**
     * 解析注解
     *
     * @param activity
     */
    public static void inject(Activity activity) {
        try {
            Class clz = activity.getClass();
            Method[] methods = clz.getDeclaredMethods();
            for (Method method : methods) {
                if(method.isAnnotationPresent(Click.class)){
                    Click click = method.getAnnotation(Click.class);
                    int[] ids = click.value();
                    for (int id : ids) {
                        final View view = activity.findViewById(id);
                        //动态代理
                        final Object o = proxy(activity);
                        view.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                OnClick onClick = (OnClick) o;
                                onClick.abc(view);
                            }
                        });
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态代理
     */
    public static Object proxy(final Activity activity) {

        return Proxy.newProxyInstance(activity.getClassLoader(), new Class[]{OnClick.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(activity, args);
            }
        });
    }
}
