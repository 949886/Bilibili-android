package com.lunareclipse.bilibili.widget.pager.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by LunarEclipse on 16/8/28.
 */
public class PageIndicator extends View implements ViewPager.OnPageChangeListener
{

    private int currentPage;
    private int pagesNumber;

    private ViewPager viewPager;

    public PageIndicator(Context context)
    {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (viewPager == null) return;

        pagesNumber = viewPager.getAdapter().getCount();
        if (pagesNumber == 0) return;



    }

    public void bind(ViewPager view)
    {
        if (viewPager == view) return;

        if (view.getAdapter() == null)
            throw new IllegalStateException("ViewPager does not set adapter");

        viewPager = view;
        viewPager.addOnPageChangeListener(this);
        invalidate();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override
    public void onPageSelected(int position)
    {

    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }
}
