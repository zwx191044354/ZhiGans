package com.example.zhigan;

import android.app.Application;
import android.content.Context;

/**
 * Created by 朱文祥 on 2016/9/21.
 */
public class MyApp extends Application{
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
