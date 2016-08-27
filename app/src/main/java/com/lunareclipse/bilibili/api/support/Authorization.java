package com.lunareclipse.bilibili.api.support;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by LunarEclipse on 16/8/26.
 */

public class Authorization
{
    private static final String appkey = "c1b107428d337928";    //85eb6835b0a1034e
    private static final String appSecret = "ea85624dfcf12d7cc7b2b3a94fac1f2c";     //2ad42749773c441109bdc0191257a664

    /**
     *  Algorithm:
     *  sign = MD5(sortedQueryParameters + appSecret)
     *  E.G. sortedQueryParameters:  a=xxx&appkey=xxx&b=xxx&c=xxx
     *  (Can not be applied to fetch play-url.)
     */
    public static String generateSign(String url)
    {
        if(url == null) return "";

        String sign = null;

        String[] results = url.split("\\?");    //Separate by ?.
        String query = results[results.length - 1];

        //Split query parameters then sort.
        String[] params = query.split("&");
        Arrays.sort(params);

        String sortedQuery = "";
        for (String param : params)
            sortedQuery += param + "&";
        sortedQuery = query.substring(0, query.length() - 1) + appSecret;

        sign = MD5(sortedQuery);

        return sign;
    }

    private static String MD5(String string)
    {
        String result = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(string.getBytes());
            BigInteger bigInt = new BigInteger(1, bytes);
            result = bigInt.toString(16);
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
