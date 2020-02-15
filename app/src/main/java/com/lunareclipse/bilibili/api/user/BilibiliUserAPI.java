package com.lunareclipse.bilibili.api.user;

import android.net.Uri;

import android.util.Pair;
import com.lunareclipse.bilibili.api.support.BilibiliCallback;
import com.lunareclipse.bilibili.api.support.DefaultCallback;
import com.lunareclipse.bilibili.api.support.URLConstants;
import com.lunareclipse.bilibili.model.User;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by YaeSakura on 16/8/26.
 */
public class BilibiliUserAPI
{
    private static final OkHttpClient client = new OkHttpClient();

    public static void getUser(int uid, BilibiliCallback<User> biliCallback)
    {
        getUser(uid, null, biliCallback);
    }

    public static void getUser(String username, BilibiliCallback<User> biliCallback)
    {
        getUser(-1, username, biliCallback);
    }

    /**
     *  [API]
     *  通过用户名(user)获取：http://api.bilibili.cn/userinfo?user=月蝕LunarEclipse
     *  通过用ID(mid)获取：http://api.bilibili.cn/userinfo?mid=17281
     */
    private static void getUser(int uid, String username, BilibiliCallback<User> biliCallback)
    {
        //Choose parameter.
        Pair<String, String> pair;
        if (username == null)
            pair = new Pair<>("mid", Integer.toString(uid));
        else pair = new Pair<>("name", username);

        String url = Uri.parse(URLConstants.BILIBILI_USER_INFO).buildUpon()
                .appendQueryParameter(pair.first, pair.second)
                .build().toString();

        Request request = new Request.Builder().url(url).build();

        Callback callback = new DefaultCallback<>(biliCallback, User.class);
        client.newCall(request).enqueue(callback);
    }
}
