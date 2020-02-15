package com.lunareclipse.bilibili.adapter.base;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by YaeSakura on 16/8/30.
 */

@SuppressWarnings("unchecked")
public abstract class ExAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T>
{
    private class Type
    {
        public static final int HEADER = -1;
        public static final int CELL = -2;
        public static final int FOOTER = -3;
    }

    private T header;
    private T footer;

    private boolean hasHeader;
    private boolean hasFooter;

    protected Context context;

    private int spanCount = 1;

    public ExAdapter(Context context)
    {
        this.context = context;
        init();
    }

    private void init()
    {
        if (onCreateHeader(null) != null) hasHeader = true;
        if (onCreateFooter(null) != null) hasFooter = true;
    }

    /**
     * For onCreateViewHolder(ViewGroup, int) is final, this method is a replacement of it.
     * Override this to return SegmentHolder instead.
     */
    public abstract  T onCreateViewHolder(ViewGroup parent, long viewType);

    public  T onCreateHeader(ViewGroup parent) {
        return  null;
    }

    public  T onCreateFooter(ViewGroup parent){
        return null;
    }

    /**
     * For getItemViewType(int) is final, this method is a replacement of it.
     * Override this to get view type instead.
     */
    public int getItemViewType(Integer position)
    {
        return Type.CELL;
    }

    /**
     * For getItemCount() is final, this method is a replacement of it.
     * Override this to return numbers of items instead.
     */
    public abstract int getCount();


    @Override
    public final T onCreateViewHolder(ViewGroup parent, int viewType)
    {
        switch (viewType)
        {
            case Type.HEADER:
                T header = onCreateHeader(parent);
                if (header.itemView != null && header.itemView.getParent() != null)
                    ((ViewGroup)header.itemView.getParent()).removeView(header.itemView);
                return header;
            case Type.FOOTER:
                T footer = onCreateFooter(parent);
                if (footer.itemView != null && footer.itemView.getParent() != null)
                    ((ViewGroup)footer.itemView.getParent()).removeView(footer.itemView);
                return footer;
            default: break;
        }
        return onCreateViewHolder(parent,(long)viewType);
    }

    @Override
    public void onBindViewHolder(T holder, int position, List<Object> payloads)
    {
        if(getItemViewType(position) == Type.HEADER) return;
        if(getItemViewType(position) == Type.FOOTER) return;
        if (hasHeader) position -= 1;

        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public final int getItemCount()
    {
        int count = 0;
        if (hasHeader) count += 1;
        if (hasFooter) count += 1;
        return getCount() + count;
    }

    @Override
    public final int getItemViewType(int position)
    {
        if (position == 0 && hasHeader) return Type.HEADER;
        else if (position == getItemCount() - 1 && hasFooter) return Type.FOOTER;
        return getItemViewType((Integer)position);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager)
        {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            spanCount = gridManager.getSpanCount();
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (getItemViewType(position) == Type.HEADER) return spanCount;
                    if (getItemViewType(position) == Type.FOOTER) return spanCount;
                    return 1;
                }
            });
        }
    }


    public Context getContext()
    {
        return context;
    }
}