package com.lunareclipse.bilibili.widget.tabbar;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import static android.widget.RelativeLayout.*;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabHost;

import static android.widget.RelativeLayout.LayoutParams.*;


/**
 * Created by LunarEclipse on 16/8/18.
 */

public abstract class TabBarActivity extends AppCompatActivity implements TabHost.OnTabChangeListener
{
    private int selectedIndex = 0;

    private TabBar tabBar;

    private RelativeLayout content;    //Root content
    private FrameLayout container;      //contain tab content fragment

    protected static final int ID_CONTENT = 0 + 1;
    protected static final int ID_SUBCONTENT = 0 + 2;
    protected static final int ID_TABBAR = 0 + 3;

    protected abstract Tab[] tabs();
//    protected abstract Color themeColor();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        initTabBar();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID)
    {
        //Initialize content as the content view of TabBarActivity.
        content = new RelativeLayout(this);
        content.setClipChildren(false);
        super.setContentView(content);

        //Sub-content from layoutResID, which is always above the container.
        View subcontent = LayoutInflater.from(this).inflate(layoutResID, null, false);
        subcontent.setId(ID_SUBCONTENT);

        LayoutParams layout = new LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        layout.addRule(ALIGN_PARENT_TOP);
        subcontent.setLayoutParams(layout);

        content.addView(subcontent);

        //Initialize container, which contains fragment that shows content.
        container = new FrameLayout(this);
        container.setId(ID_CONTENT);
        container.setBottom(0);
        container.setClipChildren(false);

        layout = new LayoutParams(MATCH_PARENT, MATCH_PARENT);
        layout.addRule(BELOW, ID_SUBCONTENT);
        layout.addRule(ABOVE, ID_TABBAR);
        container.setLayoutParams(layout);

        content.addView(container);

        //Setup tab bar.
        layout = new LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        layout.addRule(ALIGN_PARENT_BOTTOM);
        tabBar.setLayoutParams(layout);
        tabBar.setId(ID_TABBAR);

        content.addView(tabBar);

        //Adjust hierarchy.
        subcontent.bringToFront();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        tabBar = null;
    }

    @Override
    public void onTabChanged(String tabId)
    {
        //The selected tab will set text color automatically if the color resource has been provided.
        for (int i = 0; i < tabBar.getTabWidget().getTabCount(); i++)
        {
            View view = tabBar.getTabWidget().getChildAt(i);
            if (i == tabBar.getCurrentTab())
                view.setSelected(true);
            else view.setSelected(false);
        }
    }

    private void initTabBar()
    {
        tabBar = new TabBar(this);
        tabBar.setup(this, getSupportFragmentManager(), ID_CONTENT);
        tabBar.getTabWidget().setShowDividers(0);   //Not show dividers.
        tabBar.addTabs(tabs());
        tabBar.setOnTabChangedListener(this);
    }


    /*Encapsulation*/

    private int DP2PX(int dimensionDp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

}
