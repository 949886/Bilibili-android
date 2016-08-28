package com.lunareclipse.bilibili.ui.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lunareclipse.bilibili.R;
import com.lunareclipse.bilibili.ui.home.bangumi.BangumiFragment;
import com.lunareclipse.bilibili.ui.home.live.LiveFragment;
import com.lunareclipse.bilibili.ui.home.recommend.RecommendFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment
{
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.viewpager) ViewPager viewPager;

    private Fragment[] fragments = {
            new LiveFragment(),
            new RecommendFragment(),
            new BangumiFragment(),
    };

    public HomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        viewPager.setAdapter(new Adapter(getChildFragmentManager()));

        return view;
    }

    private class Adapter extends FragmentPagerAdapter
    {
        public Adapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public int getCount()
        {
            return fragments.length;
        }

        @Override
        public Fragment getItem(int position)
        {
            return fragments[position];
        }
    }
}
