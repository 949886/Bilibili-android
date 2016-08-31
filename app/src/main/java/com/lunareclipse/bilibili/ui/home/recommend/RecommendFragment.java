package com.lunareclipse.bilibili.ui.home.recommend;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lunareclipse.bilibili.App;
import com.lunareclipse.bilibili.R;
import com.lunareclipse.bilibili.adapter.RecommendAdapter;
import com.lunareclipse.bilibili.api.app.BilibiliAppAPI;
import com.lunareclipse.bilibili.api.support.BilibiliCallback;
import com.lunareclipse.bilibili.api.support.BilibiliResponse;
import com.lunareclipse.bilibili.model.RecommendHome;
import com.lunareclipse.bilibili.model.RecommendHome.BannersBean.BannerBean;
import com.lunareclipse.bilibili.widget.extra.ExRecyclerView;
import com.lunareclipse.bilibili.widget.pager.imageslider.ImageSlider;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class RecommendFragment extends Fragment
{
    private List<RecommendHome> items;

    @BindView(R.id.recyclerView) ExRecyclerView recyclerView;

    private RecommendAdapter adapter;

    public RecommendFragment()
    {
        // Required empty public constructor
    }

    public static RecommendFragment newInstance()
    {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Fetch homepage data then process asynchronously.
        BilibiliAppAPI.getRecommendHome(new BilibiliCallback<List<RecommendHome>>()
        {
            @Override
            public void onSuccess(List<RecommendHome> object, BilibiliResponse biliResponse)
            {
                //Setup Recycler View.
                items = object;

                //Refresh UI on main thread.
                getActivity().runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (recyclerView != null && recyclerView.getAdapter() != null)
                        {
                            adapter.setItems(items);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });

                //Refresh image slider on main thread.
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        if (items.get(0) == null || items.get(0).getBanner() == null || items.get(0).getBanner().getTop() == null) return;

                        List<BannerBean> topBanners = items.get(0).getBanner().getTop();
                        List<ImageView> imageViews = new ArrayList<>();
                        for (BannerBean banner : topBanners)
                        {
                            final ImageView imageView = new ImageView(getContext());
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageViews.add(imageView);

                            Glide.with(getContext()).load(banner.getImage()).into(imageView);
                        }

                        ImageSlider imageSlider = adapter.getImageSlider();
                        imageSlider.setImageViews(imageViews);
                    }
                });

            }

            @Override
            public void onFailure(BilibiliResponse biliResponse) {}

        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);


        //Initialize Recycler View.
        if (adapter == null)
            adapter = new RecommendAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
