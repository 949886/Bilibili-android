package com.lunareclipse.bilibili;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.lunareclipse.bilibili.api.video.BilibiliVideoAPI;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application>
{
    public ApplicationTest()
    {
        super(Application.class);

        BilibiliVideoAPI.getVideoURL(0, 0);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("aaaaaaaaaaa");
            }
        });
    }
}