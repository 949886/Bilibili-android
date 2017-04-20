package com.lunareclipse.bilibili.utility;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by YaeSakura on 16/8/18.
 */
public class ViewUtility
{
    public static void removeFromParent(View view)
    {
        if (view == null) return;

        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) parent.removeView(view);
    }
}
