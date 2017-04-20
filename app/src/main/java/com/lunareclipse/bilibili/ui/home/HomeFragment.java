package com.lunareclipse.bilibili.ui.home;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lunareclipse.bilibili.App;
import com.lunareclipse.bilibili.R;
import com.lunareclipse.bilibili.ui.home.bangumi.BangumiFragment;
import com.lunareclipse.bilibili.ui.home.live.LiveFragment;
import com.lunareclipse.bilibili.ui.home.recommend.RecommendFragment;
import com.lunareclipse.bilibili.utility.DensityUtility;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.graphics.Path.Direction.CW;

public class HomeFragment extends Fragment
{
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.viewpager) ViewPager viewPager;

    private Fragment[] fragments = {
            new LiveFragment(),
            new RecommendFragment(),
            new BangumiFragment()
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

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        viewPager.setAdapter(new Adapter(getChildFragmentManager()));
        viewPager.setClipChildren(true);
        viewPager.setOffscreenPageLimit(3);

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

class RoundViewPager extends ViewPager
{
    public RoundViewPager(Context context)
    {
        super(context);
    }

    public RoundViewPager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        Path clipPath = new Path();
        RectF rectF = new RectF(canvas.getClipBounds());
        rectF.bottom += 20;
        clipPath.addRoundRect(rectF, DensityUtility.dp2px(5), DensityUtility.dp2px(5), CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}
