package com.lunareclipse.bilibili.api.support;

/**
 * Created by YaeSakura on 16/8/25.
 */

public abstract  class BilibiliCallback<T>
{
    public abstract void onSuccess(T object, BilibiliResponse biliResponse);

    public abstract void onFailure(BilibiliResponse biliResponse);

    public void onProgress(double progress)
    {

    }
}
