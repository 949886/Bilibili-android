package com.lunareclipse.bilibili.widget.extra;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by YaeSakura on 16/8/29.
 */

public class ExRecyclerView extends RecyclerView
{
    private View header;
    private View footer;

    private RecyclerView.Adapter exAdapter;

    public ExRecyclerView(Context context)
    {
        super(context);
    }

    public ExRecyclerView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ExRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

//    @Override
//    public void setAdapter(RecyclerView.Adapter adapter)
//    {
//        exAdapter = adapter;
//        super.setAdapter(new RecyclerViewAdapter());
//    }

    public void setHeader(View header)
    {
        this.header = header;
    }

    public void setFooter(View footer)
    {
        this.footer = footer;
    }

    @SuppressWarnings("unchecked")
    private class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>
    {
        private class Type
        {
            public static final int HEADER = 0;
            public static final int CELL = 1;
            public static final int FOOTER = 2;
        }

        @Override
        public final ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            RelativeLayout layout = new RelativeLayout(ExRecyclerView.this.getContext());

            switch (viewType)
            {
                case Type.HEADER: layout.addView(header); break;
                case Type.FOOTER: layout.addView(footer); break;
                default:
                    if (exAdapter != null)
                        return  exAdapter.onCreateViewHolder(parent, viewType);
                    break;
            }

            return new HeaderFooterHolder(layout);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position)
        {

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads)
        {
            super.onBindViewHolder(holder, position, payloads);

            if (position == 0 && header != null)  return;
            if (position == getItemCount() - 1 && footer != null) return;

            position = (header == null) ? position : position - 1;
            if (exAdapter != null)
                 exAdapter.onBindViewHolder(holder, position);
        }

        @Override
        public int getItemCount()
        {
            return exAdapter.getItemCount();
        }

        @Override
        public final int getItemViewType(int position)
        {
            if (position == 0 && header != null) return Type.HEADER;
            else if (position == getItemCount() - 1 && footer != null) return Type.FOOTER;
            return Type.CELL;
        }

        @Override
        public void onViewRecycled(ViewHolder holder)
        {
            if (exAdapter != null)
                exAdapter.onViewRecycled(holder);
        }
    }

    private class HeaderFooterHolder extends RecyclerView.ViewHolder
    {
        public HeaderFooterHolder(View view)
        {
            super(view);
//            view.setLayoutParams(new ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
        }
    }

}
