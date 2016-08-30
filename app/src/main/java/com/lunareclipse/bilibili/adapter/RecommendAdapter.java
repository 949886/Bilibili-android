package com.lunareclipse.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lunareclipse.bilibili.R;
import com.lunareclipse.bilibili.adapter.base.RecyclerAdapter;
import com.lunareclipse.bilibili.model.RecommendHome;
import com.lunareclipse.bilibili.widget.extra.ExRecyclerView;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LunarEclipse on 16/8/30.
 */

//Used in RecommendFragment
public class RecommendAdapter extends RecyclerAdapter<RecommendAdapter.ViewHolder, RecommendHome>
{
    public RecommendAdapter(Context context)
    {
        super(context);
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.home_segment, null);
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
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        }

        public void setup(RecommendHome item)
        {
            this.item = item;

            titleTextView.setText(item.getTitle());

            //Refresh UI on main thread.
            itemView.post(new Runnable()
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

                Glide.with(context).load(item.getCover()).into(coverImageView);
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
                View view = LayoutInflater.from(context).inflate(R.layout.home_video, null);
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
}
