package com.lunareclipse.bilibili.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LunarEclipse on 16/8/30.
 */

/**
 * Base class of RecyclerView's adapter.
 * All RecyclerView's adapters are inherited from this class.
 *
 * @param <T>   Subclass of RecyclerView.ViewHolder.
 * @param <U>   Type of item, which be stored in ArrayList named items, on behalf of the entity that stores model data.
 *           E.G. LiveHome, RecommendHome etc.
 */
public abstract class RecyclerAdapter<T extends ViewHolder, U> extends Adapter<T>
{
    protected Context context;
    protected List<U> items = new ArrayList<>();

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public List<U> getItems()
    {
        return items;
    }

    public void setItems(List<U> items)
    {
        this.items = items;
    }
}
