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
    private View view;

    private List<RecommendHome> items;

    private RecommendAdapter adapter;

    @BindView(R.id.recyclerView) ExRecyclerView recyclerView;

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
                //Setup Recycler View, then refresh UI on main thread.
                items = object;

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
            }

            @Override
            public void onFailure(BilibiliResponse biliResponse) {}

        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        if (view == null)
            view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);

        //Initialize Recycler View.
        if (recyclerView.getLayoutManager() == null)
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (adapter == null)
        {
            adapter = new RecommendAdapter(getContext());
            recyclerView.setAdapter(adapter);
        }

        return view;
    }
}
