package com.lunareclipse.bilibili.widget.tabbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.lunareclipse.bilibili.R;

import static android.widget.RelativeLayout.*;
import static android.widget.RelativeLayout.LayoutParams.*;

/**
 * Created by LunarEclipse on 16/8/18.
 */

public class Tab
{
    String name;
    View indicator;
    Class fragment;

    int iconRes;
    int colorRes;

    static final int ID_ICONVIEW = 0 + 1;
    static final int ID_TITLEVIEW = 0 + 2;

    public Tab(String name, Class fragment, int iconRes)
    {
        this.name = name;
        this.indicator = null;
        this.fragment = fragment;
        this.iconRes = iconRes;
    }

    public Tab(String name, Class fragment, int iconRes, int colorRes)
    {
        this(name, fragment, iconRes);
        this.colorRes = colorRes;
    }

    public ImageView getIconView()
    {
        return (ImageView) indicator.findViewById(Tab.ID_ICONVIEW);
    }

    public TextView getTitleView()
    {
        return (TextView) indicator.findViewById(Tab.ID_TITLEVIEW);
    }


    public static View defaultIndicator(Context context, String title, int iconRes)
    {
        return defaultIndicator(context,title, iconRes, 0);
    }

    public static View defaultIndicator(Context context, String title, int iconRes, int colorRes)
    {
        RelativeLayout relativeLayout = new RelativeLayout(context);

        //Initialize IconView
        ImageView iconView = new ImageView(context);
        iconView.setId(ID_ICONVIEW);
        iconView.setPadding(0, DP2PX(context, 6), 0, 0);
        iconView.setImageDrawable(context.getResources().getDrawable(iconRes));

        LayoutParams layout = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        layout.addRule(CENTER_HORIZONTAL);
        layout.addRule(ALIGN_PARENT_TOP);
        iconView.setLayoutParams(layout);

        relativeLayout.addView(iconView);

        //Initialize TitleView
        TextView titleView = new TextView(context);
        titleView.setId(ID_TITLEVIEW);
        titleView.setText(title);
        titleView.setTextSize(11);
        titleView.setPadding(0, DP2PX(context, 2), 0, DP2PX(context, 2));
        if (colorRes != 0)  titleView.setTextColor(context.getResources().getColorStateList(colorRes));

        layout = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        layout.addRule(CENTER_HORIZONTAL);
        layout.addRule(BELOW, ID_ICONVIEW);
        titleView.setLayoutParams(layout);

        relativeLayout.addView(titleView);


        return relativeLayout;
    }

    private static int DP2PX(Context context, int dimensionDp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }
}
