package com.lunareclipse.bilibili;

import android.net.Uri;
import android.os.Looper;

import com.alibaba.fastjson.JSON;
import com.lunareclipse.bilibili.api.app.BilibiliAppAPI;
import com.lunareclipse.bilibili.api.support.Authorization;
import com.lunareclipse.bilibili.api.support.BilibiliResponse;
import com.lunareclipse.bilibili.api.support.URLConstants;
import com.lunareclipse.bilibili.api.video.BilibiliVideoAPI;
import com.lunareclipse.bilibili.model.LiveHome;

import org.junit.Test;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest
{
    @Test
    public void addition_isCorrect() throws Exception
    {

//
//        String url = Uri.parse(URLConstants.BILIBILI_LIVE_HOME).buildUpon()
//                .appendQueryParameter("device", "phone")
//                .appendQueryParameter("platform", "ios")
//                .appendQueryParameter("scale", "2")
//                .build().toString();

//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//         OkHttpClient client = new OkHttpClient();
//        Response response = client.newCall(request).execute();
//
//        String json = response.body().string();
//        BilibiliResponse bilibiliResponse = JSON.parseObject(json, BilibiliResponse.class);
//
//        String data = bilibiliResponse.data;
//
//        LiveHome liveHome = JSON.parseObject(data, LiveHome.class);

        assertEquals(4, 2 + 2);

    }
}