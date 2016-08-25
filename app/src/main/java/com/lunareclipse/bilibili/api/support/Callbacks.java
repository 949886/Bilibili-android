package com.lunareclipse.bilibili.api.support;

/**
 * Created by LunarEclipse on 16/8/25.
 */
public abstract  class Callbacks<T>
{
    public abstract void onSuccess(T object);
    public abstract void onFailure();

    public void onProgress()
    {

    }
}
