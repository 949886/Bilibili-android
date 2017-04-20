package com.lunareclipse.bilibili.api.support;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by YaeSakura on 16/8/27.
 */
public class DefaultCallback<T> implements okhttp3.Callback
{
    private BilibiliCallback<T> bilibiliCallback;
    private Class<T> clazz;

    public DefaultCallback(BilibiliCallback<T> bilibiliCallback, Class clazz)
    {
        this.bilibiliCallback = bilibiliCallback;
        this.clazz = clazz;
    }

    @Override
    public void onFailure(Call call, IOException e)
    {
        if (bilibiliCallback != null)
            bilibiliCallback.onFailure(null);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException
    {
        String json = response.body().string();
        BilibiliResponse biliResponse = JSON.parseObject(json, BilibiliResponse.class);
        biliResponse.request = response.request();
        biliResponse.response = response;

        String data = (biliResponse.data != null) ? biliResponse.data : biliResponse.result;
        if (data == null) data = json;

        T entity = null;
        if (data.startsWith("{"))
            entity = JSON.parseObject(data, clazz);
        else if (data.startsWith("["))
            entity = (T) JSON.parseArray(data, clazz);

        biliResponse.data = null;
        biliResponse.result = null;

        if (bilibiliCallback != null)
            bilibiliCallback.onSuccess(entity,biliResponse);
    }
}
