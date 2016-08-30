package com.lunareclipse.bilibili;

import android.app.Application;
import android.content.Context;

/**
 * Created by LunarEclipse on 16/8/12.
 */

public class App extends Application
{
    private static App instance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
    }

    public static Context getInstance()
    {
        return instance;
    }

    public static int dp2px(float dpValue) {
        final float scale = instance.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(float pxValue) {
        final float scale = instance.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
