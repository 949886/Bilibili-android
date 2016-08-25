package com.lunareclipse.bilibili.widget.tabbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LunarEclipse on 16/8/18.
 */

public class TabBar extends FragmentTabHost
{
    private List<Tab> tabs = new ArrayList<>();

    public TabBar(Context context)
    {
        super(context);
        setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.LTGRAY);
        canvas.drawLine(0, 0, canvas.getWidth(), 0, paint);
    }

    @Override
    public void onTabChanged(String tabId)
    {
        super.onTabChanged(tabId);

    }

    public Tab getTab(int index)
    {
        if (index > tabs.size()) return null;
        return  this.tabs.get(index);
    }

    public void addTabs(Tab[] tabs)
    {
        for (Tab tab : tabs)
        {
            this.tabs.add(tab);

            if (tab.indicator == null)
                tab.indicator = Tab.defaultIndicator(getContext(), tab.name, tab.iconRes, tab.colorRes);

            TabHost.TabSpec tabSpec = newTabSpec(tab.name).setIndicator(tab.indicator);
            addTab(tabSpec, tab.fragment, null);
        }
    }

}
