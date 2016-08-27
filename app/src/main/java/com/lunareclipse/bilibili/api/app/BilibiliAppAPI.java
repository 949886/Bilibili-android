package com.lunareclipse.bilibili.api.app;

import android.net.Uri;

import com.lunareclipse.bilibili.api.support.BilibiliCallback;
import com.lunareclipse.bilibili.api.support.DefaultCallback;
import com.lunareclipse.bilibili.api.support.URLConstants;
import com.lunareclipse.bilibili.model.BangumiHome;
import com.lunareclipse.bilibili.model.LiveHome;
import com.lunareclipse.bilibili.model.RecommendHome;

import java.util.List;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by LunarEclipse on 16/8/26.
 */

public class BilibiliAppAPI
{
    private static final OkHttpClient client = new OkHttpClient();

    //[API]http://live.bilibili.com/AppIndex/home?device=phone&platform=ios&scale=2
    public static void getLiveHome(BilibiliCallback<LiveHome> biliCallback)
    {
        String url = Uri.parse(URLConstants.BILIBILI_LIVE_HOME).buildUpon()
                .appendQueryParameter("device", "phone")
                .appendQueryParameter("platform", "ios")
                .appendQueryParameter("scale", "2")
                .build().toString();

        Request request = new Request.Builder().url(url).build();

        Callback callback = new DefaultCallback<>(biliCallback, LiveHome.class);
        client.newCall(request).enqueue(callback);
    }

    //[API]http://app.bilibili.com/x/v2/show?build=3430
    public static void getRecommendHome(BilibiliCallback<List<RecommendHome>> biliCallback)
    {
        String url = Uri.parse(URLConstants.BILIBILI_RECOMMEND_HOME).buildUpon()
                .appendQueryParameter("build", "3430")
                .build().toString();

        Request request = new Request.Builder().url(url).build();

        Callback callback = new DefaultCallback<>(biliCallback, RecommendHome.class);
        client.newCall(request).enqueue(callback);
    }

    //[API]http://bangumi.bilibili.com/api/app_index_page_v3
    public static void getBangumiHome(BilibiliCallback<BangumiHome> biliCallback)
    {
        String url = Uri.parse(URLConstants.BILIBILI_BANGUMI_HOME).buildUpon()
                .build().toString();

        Request request = new Request.Builder().url(url).build();

        Callback callback = new DefaultCallback<>(biliCallback, BangumiHome.class);
        client.newCall(request).enqueue(callback);
    }

    //[API]
    public static void getBangumiRecommendation(long timestamp, BilibiliCallback<BangumiHome> biliCallback)
    {

    }
}
