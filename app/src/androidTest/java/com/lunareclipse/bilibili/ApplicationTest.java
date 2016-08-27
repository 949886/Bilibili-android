package com.lunareclipse.bilibili;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.lunareclipse.bilibili.api.app.BilibiliAppAPI;
import com.lunareclipse.bilibili.api.video.BilibiliVideoAPI;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application>
{
    public ApplicationTest()
    {
        super(Application.class);

        BilibiliAppAPI.getLiveHome(null);

    }
}