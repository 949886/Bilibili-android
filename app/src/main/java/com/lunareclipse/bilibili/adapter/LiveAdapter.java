package com.lunareclipse.bilibili.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.lunareclipse.bilibili.App;
import com.lunareclipse.bilibili.R;
import com.lunareclipse.bilibili.adapter.base.ExAdapter;
import com.lunareclipse.bilibili.model.Live;
import com.lunareclipse.bilibili.model.LiveHome;
import com.lunareclipse.bilibili.model.LiveHome.BannerBean;
import com.lunareclipse.bilibili.model.LiveHome.PartitionsBean;
import com.lunareclipse.bilibili.widget.pager.imageslider.ImageSlider;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by YaeSakura on 16/9/1.
 */

public class LiveAdapter extends ExAdapter<LiveAdapter.SegmentHolder>
{
    private LiveHome liveHomeData;
    private ImageSlider imageSlider;

    public LiveAdapter(Context context)
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
        if (imageSlider == null)
        {
            imageSlider = new ImageSlider(getContext());
            imageSlider.setLayoutParams(new ViewGroup.LayoutParams(WRAP_CONTENT, App.dp2px(105)));
        }

        return new SegmentHolder(imageSlider);
    }

    @Override
    public int getCount()
    {
        if (liveHomeData != null)
            return liveHomeData.getPartitions().size();
        return 0;
    }

    @Override
    public void onBindViewHolder(SegmentHolder holder, int position)
    {
        holder.setup(liveHomeData.getPartitions().get(position));
    }

    public LiveHome getLiveHomeData()
    {
        return liveHomeData;
    }

    //Refresh image slider (must be on main thread).
    private void setupBanners()
    {
        if (liveHomeData == null) return;

        final List<BannerBean> banners = liveHomeData.getBanner();
        if (banners == null) return;

        List<ImageView> imageViews = new ArrayList<>();
        for (BannerBean banner : banners)
        {
            final ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);

            Glide.with(getContext()).load(banner.getImg()).into(imageView);
        }

        imageSlider.setImageViews(imageViews);
    }

    /**
     * Run this method on UI thread.
     */
    public void setLiveHomeData(LiveHome liveHomeData)
    {
        this.liveHomeData = liveHomeData;

        setupBanners();
    }


    /* SegmentHolder  for RecommendAdapter*/
    //On behalf of every segment in live home page. E.G. ..
    class SegmentHolder extends RecyclerView.ViewHolder
    {
        public boolean isRecommend;

        private PartitionsBean item;

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
                recyclerView.setAdapter(new LivesAdapter());
            }

            //Initialize moreInfoButton.
            if (moreInfoButton != null)
            {
                Drawable drawable= context.getResources().getDrawable(R.mipmap.common_arrow_right_shadow);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                moreInfoButton.setCompoundDrawables(null, null, drawable, null);
            }
        }

        public void setup(PartitionsBean item)
        {
            this.item = item;

            if (recyclerView != null)
                recyclerView.getAdapter().notifyDataSetChanged();

            if (titleTextView != null)
                titleTextView.setText(item.getPartition().getName());

            if (iconImageView != null)
                Glide.with(context)
                        .load(item.getPartition().getSub_icon().getSrc())
                        .into(iconImageView);
        }


        //====================Live========================
        class LivesAdapter extends RecyclerView.Adapter<LivesAdapter.Holder>
        {
            @Override
            public Holder onCreateViewHolder(ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(context).inflate(R.layout.home_live, parent, false);
                return new Holder(view);
            }

            @Override
            public void onBindViewHolder(Holder holder, int position)
            {
                holder.setup(item.getLives().get(position));
            }

            @Override
            public int getItemCount()
            {
                if (isRecommend) return 12;
                if (item != null)
                {
                    int size = item.getLives().size();
                    if (size < 4) return size;
                    return 4;
                }
                return 0;
            }

            //On behalf of every clickable live in every zone.
            class Holder extends RecyclerView.ViewHolder
            {
                private Live item;

                @BindView(R.id.cover) RoundedImageView coverImageView;
                @BindView(R.id.title) TextView titleTextView;
                @BindView(R.id.owner) TextView ownerTextView;
                @BindView(R.id.onlineCount) TextView onlineCountTextView;

                public Holder(View itemView)
                {
                    super(itemView);
                    ButterKnife.bind(this, itemView);
                }

                public void setup(Live item)
                {
                    this.item = item;

                    Glide.with(context)
                            .load(item.getCover().getSrc())
                            .into(coverImageView);

                    titleTextView.setText(item.getTitle());
                    ownerTextView.setText(item.getOwner().getName());
                    onlineCountTextView.setText(Integer.toString(item.getOnline()));
                }
            }
        }
        //=====================Live=========================

    }
}
