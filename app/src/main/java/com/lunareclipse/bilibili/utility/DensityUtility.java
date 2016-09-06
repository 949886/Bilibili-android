package com.lunareclipse.bilibili.utility;

import android.content.Context;

import com.lunareclipse.bilibili.App;

/**
 * Created by LunarEclipse on 16/9/2.
 */
public class DensityUtility
{
    private static Context context = App.getInstance();

    public static int dp2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
