package com.lunareclipse.bilibili.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lunareclipse.bilibili.App;
import com.lunareclipse.bilibili.R;
import com.lunareclipse.bilibili.adapter.base.ExAdapter;
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

/**
 * Created by LunarEclipse on 16/8/30.
 */

//Used in RecommendFragment
public class RecommendAdapter extends ExAdapter<RecommendAdapter.ViewHolder>
{
    private List<RecommendHome> items;

    private ImageSlider imageSlider;

    public RecommendAdapter(Context context)
    {
        super(context);
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, long viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.home_segment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public ViewHolder onCreateHeader(ViewGroup parent)
    {
        //Initialize Image Slider.
        imageSlider = new ImageSlider(getContext());
        imageSlider.setLayoutParams(new ViewGroup.LayoutParams(WRAP_CONTENT, App.dp2px(105)));

        return new ViewHolder(imageSlider);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.setup(items.get(position));
    }

    @Override
    public int getCount()
    {
        if (items != null)
            return items.size();
        return 0;
    }

    //On behalf of every segment in recommend home page. E.G. Music zone, anime zone, game zone etc..
    class ViewHolder extends RecyclerView.ViewHolder
    {
        private RecommendHome item;

        @Nullable @BindView(R.id.icon) ImageView iconImageView;
        @Nullable @BindView(R.id.title) TextView titleTextView;
        @Nullable @BindView(R.id.moreInfo) TextView moreInfoTextView;
        @Nullable @BindView(R.id.recyclerView) RecyclerView recyclerView;
        @Nullable @BindView(R.id.footer) LinearLayout footer;

        public ViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);

            //Initialize Recycler View.
            if (recyclerView != null)
            {
                recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
                recyclerView.setAdapter(new VideoAdapter());
            }

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

            //Setup banner in footer.

            if (footer != null)
                footer.removeAllViews();

            if (item.getBanner() != null && item.getBanner().getBottom() != null)
            {
                List<BannerBean> bottomBanners = item.getBanner().getBottom();

                List<ImageView> imageViews = new ArrayList<>();
                for (BannerBean banner : bottomBanners)
                {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageViews.add(imageView);

                    Glide.with(context).load(banner.getImage()).into(imageView);
                }

                ImageSlider imageSlider = new ImageSlider(getContext());
                imageSlider.setLayoutParams(new ViewGroup.LayoutParams(WRAP_CONTENT, App.dp2px(105)));
                imageSlider.setImageViews(imageViews);

                if (footer != null)
                    footer.addView(imageSlider);
            }
        }

        //On behalf of every clickable video in every zone segment.
        class VideoViewHolder extends RecyclerView.ViewHolder
        {
            private RecommendHome.BodyBean item;

            @BindView(R.id.cover) RoundedImageView coverImageView;
            @BindView(R.id.title) TextView titleTextView;
            @BindView(R.id.playCount) TextView playCountTextView;
            @BindView(R.id.danmakuCount) TextView danmakuCountTextView;

            public VideoViewHolder(View itemView)
            {
                super(itemView);
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
                View view = LayoutInflater.from(context).inflate(R.layout.home_video, parent, false);
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

    public List<RecommendHome> getItems()
    {
        return items;
    }

    public void setItems(List<RecommendHome> items)
    {
        this.items = items;
    }

    public ImageSlider getImageSlider()
    {
        return imageSlider;
    }
}
