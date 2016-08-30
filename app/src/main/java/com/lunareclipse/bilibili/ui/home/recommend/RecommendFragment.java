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
import com.lunareclipse.bilibili.api.app.BilibiliAppAPI;
import com.lunareclipse.bilibili.api.support.BilibiliCallback;
import com.lunareclipse.bilibili.api.support.BilibiliResponse;
import com.lunareclipse.bilibili.model.RecommendHome;
import com.lunareclipse.bilibili.widget.extra.ExRecyclerView;
import com.lunareclipse.bilibili.widget.pager.imageslider.ImageSlider;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class RecommendFragment extends Fragment
{
    private List<RecommendHome> items;

    @BindView(R.id.recyclerView) ExRecyclerView recyclerView;

    private ImageSlider imageSlider;


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
                            recyclerView.getAdapter().notifyDataSetChanged();
                    }
                });

                //Setup image slider that shows banners.

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

        //Initialize Image Slider.
        imageSlider = new ImageSlider(getContext());
        imageSlider.setLayoutParams(new ViewGroup.LayoutParams(WRAP_CONTENT, App.dp2px(105)));
        imageSlider.setImageResources(new int[]{ R.mipmap.image1,  R.mipmap.image2, R.mipmap.image3});

        //Initialize Recycler View.
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter());
        recyclerView.setHeader(imageSlider);

        return view;
    }

    //On behalf of every segment in recommend home page. E.G. Music zone, anime zone, game zone etc..
     class ViewHolder extends RecyclerView.ViewHolder
    {
        private View itemView;

        private RecommendHome item;

        @BindView(R.id.icon) ImageView iconImageView;
        @BindView(R.id.title) TextView titleTextView;
        @BindView(R.id.moreInfo) TextView moreInfoTextView;
        @BindView(R.id.recyclerView) ExRecyclerView recyclerView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);

            recyclerView.setAdapter(new VideoAdapter());
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }

        public void setup(RecommendHome item)
        {
            this.item = item;

            titleTextView.setText(item.getTitle());

            //Refresh UI on main thread.
            getActivity().runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    if (recyclerView != null && recyclerView.getAdapter() != null)
                        recyclerView.getAdapter().notifyDataSetChanged();
                }
            });
        }


        //On behalf of every clickable video in every zone segment.
        class VideoViewHolder extends RecyclerView.ViewHolder
        {
            private View itemView;
            private RecommendHome.BodyBean item;

            @BindView(R.id.cover) RoundedImageView coverImageView;
            @BindView(R.id.title) TextView titleTextView;
            @BindView(R.id.playCount) TextView playCountTextView;
            @BindView(R.id.danmakuCount) TextView danmakuCountTextView;

            public VideoViewHolder(View itemView)
            {
                super(itemView);
                this.itemView = itemView;
                ButterKnife.bind(this, itemView);
            }

            public void setup(RecommendHome.BodyBean item)
            {
                this.item = item;

                Glide.with(getContext()).load(item.getCover()).into(coverImageView);
                titleTextView.setText(item.getTitle());
                playCountTextView.setText(Integer.toString(item.getPlay()));
                danmakuCountTextView.setText(Integer.toString(item.getDanmaku()));
            }
        }

        //For RecommendFragment.ViewHolder.VideoViewHolder
        class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder>
        {

            @Override
            public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.home_video, null);
                return new VideoViewHolder(view);
            }

            @Override
            public void onBindViewHolder(VideoViewHolder holder, int position)
            {
                holder.setup(item.getBody().get(position));
            }

            @Override
            public int getItemCount()
            {
                if (item != null)
                    return item.getBody().size();
                return 0;
            }
        }
    }

    //For RecommendFragment.ViewHolder
    private class Adapter extends RecyclerView.Adapter<ViewHolder>
    {
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.home_segment, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position)
        {
            holder.setup(items.get(position));
        }

        @Override
        public int getItemCount()
        {
            if (items != null)
                return items.size();
            return 0;
        }
    }

}
