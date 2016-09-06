package com.lunareclipse.bilibili.model;

/**
 * Created by LunarEclipse on 16/8/29.
 */
public class ImageLink
{
    private String src;
    private String height;
    private String width;

    public String getSrc()
    {
        return src;
    }

    public void setSrc(String src)
    {
        this.src = src;
    }

    public int getHeight()
    {
        return Integer.parseInt(height);
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return Integer.parseInt(width);
    }

    public void setWidth(String width)
    {
        this.width = width;
    }
}
