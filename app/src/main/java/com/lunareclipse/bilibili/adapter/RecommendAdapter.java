package com.lunareclipse.bilibili.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lunareclipse.bilibili.App;
import com.lunareclipse.bilibili.R;
import com.lunareclipse.bilibili.adapter.base.ExAdapter;
import com.lunareclipse.bilibili.model.RecommendHome;
import com.lunareclipse.bilibili.model.RecommendHome.BannersBean.BannerBean;
import com.lunareclipse.bilibili.widget.pager.imageslider.ImageSlider;
import com.makeramen.roundedimageview.RoundedImageView;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by LunarEclipse on 16/8/30.
 */

//Used in RecommendFragment
public class RecommendAdapter extends ExAdapter<RecommendAdapter.SegmentHolder>
{
    protected List<RecommendHome> items;
    private ImageSlider imageSlider;

    public RecommendAdapter(Context context)
    {
        super(context);
    }

    @Override
    public SegmentHolder onCreateViewHolder(ViewGroup parent, long viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.home_segment, parent, false);
        return new SegmentHolder(view);
    }

    @Override
    public SegmentHolder onCreateHeader(ViewGroup parent)
    {
        //Initialize Image Slider.
        imageSlider = new ImageSlider(getContext());
        imageSlider.setLayoutParams(new ViewGroup.LayoutParams(WRAP_CONTENT, App.dp2px(105)));

        return new SegmentHolder(imageSlider);
    }

    @Override
    public void onBindViewHolder(SegmentHolder holder, int position)
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

    /* Encapsulation */

    //Refresh image slider (must be on main thread).
    private void setupBanners()
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

        imageSlider.setImageViews(imageViews);
    }

    /* Getter & Setter */

    public List<RecommendHome> getItems()
    {
        return items;
    }

    /**
     * Run this method on UI thread.
     */
    public void setItems(List<RecommendHome> items)
    {
        this.items = items;
        setupBanners();
    }

    public ImageSlider getImageSlider()
    {
        return imageSlider;
    }


    /* SegmentHolder  for RecommendAdapter*/
    //On behalf of every segment in recommend home page. E.G. Music zone, anime zone, game zone etc..
    class SegmentHolder extends RecyclerView.ViewHolder
    {
        private RecommendHome item;

        @Nullable @BindView(R.id.icon) ImageView iconImageView;
        @Nullable @BindView(R.id.title) TextView titleTextView;
        @Nullable @BindView(R.id.moreInfo) Button moreInfoButton;
        @Nullable @BindView(R.id.rank) ImageView rankImageView;
        @Nullable @BindView(R.id.recyclerView) RecyclerView recyclerView;
        @Nullable @BindView(R.id.header) LinearLayout header;
        @Nullable @BindView(R.id.footer) LinearLayout footer;

        public SegmentHolder(View itemView)
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

            if (titleTextView != null)
                titleTextView.setText(item.getTitle());

            //Refresh UI of recyclerView.
            if (recyclerView != null && recyclerView.getAdapter() != null)
                recyclerView.getAdapter().notifyDataSetChanged();

            //Setup more info text.
            if (moreInfoButton != null)
            {
                if (rankImageView != null) rankImageView.setVisibility(View.GONE);
                moreInfoButton.setTextColor(context.getResources().getColorStateList(android.R.color.darker_gray));

                switch (item.getType())
                {
                    case "recommend":
                        moreInfoButton.setText(R.string.home_recommend_rank);
                        moreInfoButton.setTextColor(context.getResources().getColorStateList(R.color.homeRecommendRank));
                        if (rankImageView != null) rankImageView.setVisibility(View.VISIBLE);
                        break;
                    case "live":
                        int count = item.getExt().getLiveCount();
                        moreInfoButton.setText(context.getResources().getQuantityString(R.plurals.home_live_more_info, count, count));
                        break;
                    default:
                        String text = context.getResources().getString(R.string.home_recommend_more)
                                + StringUtils.substring(item.getTitle(), 0, 2);
                        moreInfoButton.setText(text);
                        break;
                }
            }

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

        //=====================Video=========================
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

        //For RecommendAdapter.SegmentHolder.VideoViewHolder
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
        //=====================Video=========================
    }
}
