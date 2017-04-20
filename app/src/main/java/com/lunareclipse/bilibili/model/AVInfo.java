package com.lunareclipse.bilibili.model;

import java.util.List;

/**
 * Created by YaeSakura on 16/8/24.
 */
public class AvInfo
{

    /**
     * code : 0
     * msg : OK
     * av : 5216011
     * title : 【7月】NEW GAME! 01
     * time : 1468320646
     * desc : #01 好像真的入职公司了耶！
     * img : http://i1.hdslb.com/bfs/archive/a3ed13eb2986fc62220f8ccaa7688a8da6fe8e5b.jpg
     * up : 哔哩哔哩番剧
     * upsign :
     * upimg : http://i0.hdslb.com/bfs/face/60a9153609998b04301dc5b8ed44c41b537a2268.jpg
     * maxpage : 1
     * list :
     * [{
     *      "AV":5216011,
     *      "P":1,
     *      "CID":8477109,
     *      "Title":"【7月】NEW GAME! 01",
     *      "Mp3Url":"http://www.bilibilijj.com/Files/DownLoad/8477109.mp3/www.bilibilijj.com.mp3?mp3=true",
     *      "Mp3Length":-1,
     *      "Mp3Click":52,
     *      "Mp4Url":"http://www.bilibilijj.com/Files/DownLoad/8477109.mp4/www.bilibilijj.com.mp4?mp3=true",
     *      "Mp4Length":209223412,
     *      "Mp4Click":2285
     * }]
     */

    private int code;
    private String msg;
    private int av;
    private String title;
    private int time;
    private String desc;
    private String img;
    private String up;
    private String upsign;
    private String upimg;
    private int maxpage;

    private List<ListBean> list;


    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public int getAv()
    {
        return av;
    }

    public void setAv(int av)
    {
        this.av = av;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getUp()
    {
        return up;
    }

    public void setUp(String up)
    {
        this.up = up;
    }

    public String getUpsign()
    {
        return upsign;
    }

    public void setUpsign(String upsign)
    {
        this.upsign = upsign;
    }

    public String getUpimg()
    {
        return upimg;
    }

    public void setUpimg(String upimg)
    {
        this.upimg = upimg;
    }

    public int getMaxpage()
    {
        return maxpage;
    }

    public void setMaxpage(int maxpage)
    {
        this.maxpage = maxpage;
    }

    public List<ListBean> getList()
    {
        return list;
    }

    public void setList(List<ListBean> list)
    {
        this.list = list;
    }

    public static class ListBean
    {
        private int AV;
        private int P;
        private int CID;
        private String Title;
        private String Mp3Url;
        private int Mp3Length;
        private int Mp3Click;
        private String Mp4Url;
        private int Mp4Length;
        private int Mp4Click;

        public int getAV()
        {
            return AV;
        }

        public void setAV(int AV)
        {
            this.AV = AV;
        }

        public int getP()
        {
            return P;
        }

        public void setP(int P)
        {
            this.P = P;
        }

        public int getCID()
        {
            return CID;
        }

        public void setCID(int CID)
        {
            this.CID = CID;
        }

        public String getTitle()
        {
            return Title;
        }

        public void setTitle(String Title)
        {
            this.Title = Title;
        }

        public String getMp3Url()
        {
            return Mp3Url;
        }

        public void setMp3Url(String Mp3Url)
        {
            this.Mp3Url = Mp3Url;
        }

        public int getMp3Length()
        {
            return Mp3Length;
        }

        public void setMp3Length(int Mp3Length)
        {
            this.Mp3Length = Mp3Length;
        }

        public int getMp3Click()
        {
            return Mp3Click;
        }

        public void setMp3Click(int Mp3Click)
        {
            this.Mp3Click = Mp3Click;
        }

        public String getMp4Url()
        {
            return Mp4Url;
        }

        public void setMp4Url(String Mp4Url)
        {
            this.Mp4Url = Mp4Url;
        }

        public int getMp4Length()
        {
            return Mp4Length;
        }

        public void setMp4Length(int Mp4Length)
        {
            this.Mp4Length = Mp4Length;
        }

        public int getMp4Click()
        {
            return Mp4Click;
        }

        public void setMp4Click(int Mp4Click)
        {
            this.Mp4Click = Mp4Click;
        }
    }
}
