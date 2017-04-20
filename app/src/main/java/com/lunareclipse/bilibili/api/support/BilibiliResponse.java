package com.lunareclipse.bilibili.api.support;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by YaeSakura on 16/8/24.
 */

public class BilibiliResponse
{
    public int code;
    public String message;

    public String data;
    public String result;

    public Request request;
    public Response response;

    public BilibiliResponse() {}

    public BilibiliResponse(int code, String message)
    {
        this.code = code;
        this.message = message;
    }
}
