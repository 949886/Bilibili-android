package com.lunareclipse.bilibili.widget.pager.imageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Created by YaeSakura on 16/8/28.
 */

public class ImageSlider extends ViewPager implements ViewPager.OnPageChangeListener
{
    private int[] imageResources;
    private List<ImageView> imageViews = new ArrayList<>();

    private Adapter adapter;

    public ImageSlider(Context context)
    {
        super(context);
        init();
    }

    public ImageSlider(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private void init()
    {
        adapter = new Adapter();
        setAdapter(adapter);

        //default height = 300px
        setLayoutParams(new ViewGroup.LayoutParams(MATCH_PARENT,300));
    }

    @Override
    public void onPageScrolled(int position, float offset, int offsetPixels)
    {
        super.onPageScrolled(position, offset, offsetPixels);
    }

    @Override
    public void onPageSelected(int position)
    {

    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }

    public void setImageResources(int[] imageResources)
    {
        this.imageResources = imageResources;
        for(int res : imageResources)
        {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(res);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);
        }

        if (adapter != null)
            adapter.notifyDataSetChanged();
    }

    public void setImageViews(List<ImageView> imageViews)
    {
        this.imageViews.clear();

        for (ImageView imageView : imageViews)
        {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.imageViews.add(imageView);
        }

        if (adapter != null)
            adapter.notifyDataSetChanged();

//        this.imageViews = imageViews;
//
//        adapter = new Adapter();
//        setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    private class Adapter extends PagerAdapter
    {
        @Override
        public int getCount()
        {
            if (imageViews != null)
                return imageViews.size();
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            ImageView imageView = imageViews.get(position);
            addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            ImageView imageView = imageViews.get(position);
            removeView(imageView);
        }
//
//        @Override
//        public int getItemPosition(Object object) {
//            return POSITION_NONE;
//        }
    }
}
