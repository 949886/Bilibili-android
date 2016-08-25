package com.lunareclipse.bilibili.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by LunarEclipse on 16/8/26.
 */
public class RecommendHome
{

    /**
     * param :
     * type : recommend
     * style : medium
     * title : 热门焦点
     * body :
     * [
     *      title : MMD Girls GUMI  巡音 弱音 镜音 初音 凤凰式旗袍 改模配布
     *      cover : http://i2.hdslb.com/bfs/archive/4c640253ded4b7543449be678c48a88a5d72fa83.jpg_320x200.jpg
     *      uri : bilibili://video/5963630
     *       param : 5963630
     *       goto : av
     *      play : 43139
     *      danmaku : 1049
     * ]
     * banner :
     * {
     *       id : 4772
     *       title : 频道精选 科技区 NO.26
     *       image : http://i0.hdslb.com/bfs/archive/8213de22329855da5a0e87226e86dd83730fc89b.jpg
     *       hash : ead7a11dd7b4c80b2a8b9c2368b311c5
     *       uri : http://www.bilibili.com/topic/v2/phone1474.html
     * }
     *
     */

    private String param;
    private String type;
    private String style;
    private String title;
    private BannerBean banner;
    private List<BodyBean> body;

    public String getParam()
    {
        return param;
    }

    public void setParam(String param)
    {
        this.param = param;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public BannerBean getBanner()
    {
        return banner;
    }

    public void setBanner(BannerBean banner)
    {
        this.banner = banner;
    }

    public List<BodyBean> getBody()
    {
        return body;
    }

    public void setBody(List<BodyBean> body)
    {
        this.body = body;
    }

    public static class BannerBean
    {
        /**
         * id : 4772
         * title : 频道精选 科技区 NO.26
         * image : http://i0.hdslb.com/bfs/archive/8213de22329855da5a0e87226e86dd83730fc89b.jpg
         * hash : ead7a11dd7b4c80b2a8b9c2368b311c5
         * uri : http://www.bilibili.com/topic/v2/phone1474.html
         */

        private List<TopBean> top;

        public List<TopBean> getTop()
        {
            return top;
        }

        public void setTop(List<TopBean> top)
        {
            this.top = top;
        }

        public static class TopBean
        {
            private int id;
            private String title;
            private String image;
            private String hash;
            private String uri;

            public int getId()
            {
                return id;
            }

            public void setId(int id)
            {
                this.id = id;
            }

            public String getTitle()
            {
                return title;
            }

            public void setTitle(String title)
            {
                this.title = title;
            }

            public String getImage()
            {
                return image;
            }

            public void setImage(String image)
            {
                this.image = image;
            }

            public String getHash()
            {
                return hash;
            }

            public void setHash(String hash)
            {
                this.hash = hash;
            }

            public String getUri()
            {
                return uri;
            }

            public void setUri(String uri)
            {
                this.uri = uri;
            }
        }
    }

    public static class BodyBean
    {
        private String title;
        private String cover;
        private String uri;
        private String param;   //视频:av号 直播:live房间号 番剧:bangumi_id 话题:网页URL
        private boolean finish;
        @JSONField(name="goto")
        private String _goto;

        /* Video Only */
        private int play;
        private int danmaku;

        /* Bangumi Only */
        private String mtime;       //最新一集时间
        private int index;             //最新一集是第几集

        /* Live Only */
        private String name;
        private String face;
        private int online;
        private ExtBean ext;

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getCover()
        {
            return cover;
        }

        public void setCover(String cover)
        {
            this.cover = cover;
        }

        public String getUri()
        {
            return uri;
        }

        public void setUri(String uri)
        {
            this.uri = uri;
        }

        public String getParam()
        {
            return param;
        }

        public void setParam(String param)
        {
            this.param = param;
        }

        public String getGoto()
        {
            return _goto;
        }

        public void setGoto(String _goto)
        {
            this._goto = _goto;
        }

        public int getPlay()
        {
            return play;
        }

        public void setPlay(int play)
        {
            this.play = play;
        }

        public int getDanmaku()
        {
            return danmaku;
        }

        public void setDanmaku(int danmaku)
        {
            this.danmaku = danmaku;
        }

        public boolean isFinish()
        {
            return finish;
        }

        public void setFinish(boolean finish)
        {
            this.finish = finish;
        }

        public String get_goto()
        {
            return _goto;
        }

        public void set_goto(String _goto)
        {
            this._goto = _goto;
        }

        public String getMtime()
        {
            return mtime;
        }

        public void setMtime(String mtime)
        {
            this.mtime = mtime;
        }

        public int getIndex()
        {
            return index;
        }

        public void setIndex(int index)
        {
            this.index = index;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getFace()
        {
            return face;
        }

        public void setFace(String face)
        {
            this.face = face;
        }

        public int getOnline()
        {
            return online;
        }

        public void setOnline(int online)
        {
            this.online = online;
        }

        public ExtBean getExt()
        {
            return ext;
        }

        public void setExt(ExtBean ext)
        {
            this.ext = ext;
        }

        public static class ExtBean
        {
            @JSONField(name = "live_count")
            private int liveCount;

            public int getLiveCount()
            {
                return liveCount;
            }

            public void setLiveCount(int liveCount)
            {
                this.liveCount = liveCount;
            }
        }
    }

}
