package com.lunareclipse.bilibili;

import android.app.Application;
import android.content.Context;

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

}
