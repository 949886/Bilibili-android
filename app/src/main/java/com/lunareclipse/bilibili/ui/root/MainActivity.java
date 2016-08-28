package com.lunareclipse.bilibili.ui.root;

import android.os.Bundle;

import com.lunareclipse.bilibili.R;
import com.lunareclipse.bilibili.ui.attention.AttentionFragment;
import com.lunareclipse.bilibili.ui.categories.CategoriesFragment;
import com.lunareclipse.bilibili.ui.discover.DiscoverFragment;
import com.lunareclipse.bilibili.ui.home.HomeFragment;
import com.lunareclipse.bilibili.ui.profile.ProfileFragment;
import com.lunareclipse.bilibili.widget.tabbar.Tab;
import com.lunareclipse.bilibili.widget.tabbar.TabBarActivity;


public class MainActivity extends TabBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Tab[] tabs()
    {
        String home = getString(R.string.tabbar_home);
        String categories = getString(R.string.tabbar_categories);
        String attention = getString(R.string.tabbar_attention);
        String discover = getString(R.string.tabbar_discover);
        String profile = getString(R.string.tabbar_profile);

        return new Tab[] {
                new Tab(home, HomeFragment.class, R.drawable.tab_icon_explore, R.color.tabbar_text),
                new Tab(categories, CategoriesFragment.class, R.drawable.tab_icon_explore, R.color.tabbar_text),
                new Tab(attention, AttentionFragment.class, R.drawable.tab_icon_explore, R.color.tabbar_text),
                new Tab(discover, DiscoverFragment.class, R.drawable.tab_icon_explore, R.color.tabbar_text),
                new Tab(profile, ProfileFragment.class, R.drawable.tab_icon_profile, R.color.tabbar_text)
        };
    }

}
