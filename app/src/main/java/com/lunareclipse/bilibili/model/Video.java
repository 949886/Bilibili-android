package com.lunareclipse.bilibili.model;

import java.util.List;

/**
 * Created by YaeSakura on 16/8/29.
 */
public class Video
{

    private int code;
    private DataBean data;
    private String message;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public DataBean getData()
    {
        return data;
    }

    public void setData(DataBean data)
    {
        this.data = data;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public static class DataBean
    {
        private int aid;
        private int tid;
        private String tname;
        private int copyright;
        private String pic;
        private String title;
        private int pubdate;
        private int ctime;
        private String desc;
        private int state;
        private int attribute;
        private int duration;
        /**
         * bp : 0
         * elec : 1
         * download : 1
         * movie : 0
         * pay : 0
         */

        private RightsBean rights;
        /**
         * mid : 122879
         * name : 敖厂长
         * face : http://i1.hdslb.com/bfs/face/5227f7892c58fb72706d9799eda0e5eb7d26e320.jpg
         */

        private OwnerBean owner;
        /**
         * view : 1502709
         * danmaku : 52598
         * reply : 15356
         * favorite : 30493
         * coin : 453494
         * share : 6510
         * now_rank : 0
         * his_rank : 0
         */

        private StatBean stat;
        /**
         * attention : -999
         * favorite : 1
         */

        private ReqUserBean req_user;
        /**
         * show : true
         * total : 8279
         * count : 2745
         * list : [{"mid":122879,"pay_mid":11383186,"rank":1,"uname":"入坑到底的死宅","avatar":"http://i1.hdslb.com/bfs/face/4e9942b40e21b004db7e24733c871d0105a6bcad.jpg","message":"","msg_deleted":0},{"mid":122879,"pay_mid":13270447,"rank":2,"uname":"睡不醒的白熊","avatar":"http://i0.hdslb.com/bfs/face/d11634a9c17f01378ce24c8384e3701b50c78916.jpg","message":"","msg_deleted":0},{"mid":122879,"pay_mid":208259,"rank":3,"uname":"ruich97","avatar":"http://i1.hdslb.com/bfs/face/8920e6741fc2808cce5b81bc27abdbda291655d3.png","message":"感动中国系列！","msg_deleted":0},{"mid":122879,"pay_mid":4312619,"rank":4,"uname":"一只活蹦乱跳的咖啡","avatar":"http://i1.hdslb.com/bfs/face/5188d905feb5310a5f42e3eafbdc1d489dc66787.jpg"},{"mid":122879,"pay_mid":4776169,"rank":5,"uname":"中二狗蛋","avatar":"http://i0.hdslb.com/bfs/face/1cd17a783da37af3c2d393b513dfa00f3145d970.jpg"},{"mid":122879,"pay_mid":921025,"rank":6,"uname":"仙术经","avatar":"http://i1.hdslb.com/bfs/face/3b2eb4aeb13e0e4471c6d0eb530470bf10338268.jpg"},{"mid":122879,"pay_mid":12297656,"rank":7,"uname":"ZheiZhei","avatar":"http://i0.hdslb.com/bfs/face/5ed5388edbc865a7258f9ae66c4855c3fc33b593.jpg"},{"mid":122879,"pay_mid":249896,"rank":8,"uname":"nemo314","avatar":"http://i0.hdslb.com/bfs/face/5d2c92beb774a4bb30762538bb102d23670ae9c0.gif"},{"mid":122879,"pay_mid":907154,"rank":9,"uname":"千仙大使","avatar":"http://i1.hdslb.com/bfs/face/753fdc0ef6617a47eedf6d0e8ed591cec8a28856.jpg"},{"mid":122879,"pay_mid":14216101,"rank":10,"uname":"买菜的小男孩","avatar":"http://i2.hdslb.com/bfs/face/82f4e9f0bbefd2548e36ddf45fd1bf3167aeaa71.jpg"},{"mid":122879,"pay_mid":1477346,"rank":11,"uname":"进击的御坂桑","avatar":"http://i0.hdslb.com/bfs/face/3b8ebc8e8fd6487e1bfa63e7cb109632558abea7.jpg"},{"mid":122879,"pay_mid":38680710,"rank":12,"uname":"最会选礼物的礼物说","avatar":"http://i0.hdslb.com/bfs/face/5ca9607511ac1841771f657f9de0d1b3b53487ce.jpg"},{"mid":122879,"pay_mid":13820391,"rank":13,"uname":"骑♂鸡的世代","avatar":"http://i1.hdslb.com/bfs/face/0051f6c10adeeba8f89b8d7038376257ea19db99.jpg"},{"mid":122879,"pay_mid":5003339,"rank":14,"uname":"院长のbilibili","avatar":"http://i2.hdslb.com/bfs/face/171332bb8861c54caa92a748142185ea693a1d38.jpg"},{"mid":122879,"pay_mid":7690817,"rank":15,"uname":"qazsssooosss","avatar":"http://static.hdslb.com/images/member/noface.gif"},{"mid":122879,"pay_mid":6713892,"rank":16,"uname":"秀男","avatar":"http://i1.hdslb.com/bfs/face/f04fbf3a47c854194b7a7474b3221f155548cb03.jpg"},{"mid":122879,"pay_mid":6986541,"rank":17,"uname":"无与伦比丶飞","avatar":"http://i0.hdslb.com/bfs/face/b40341142c61e74453c352ef77bfc8e20d7a3618.jpg"},{"mid":122879,"pay_mid":309025,"rank":18,"uname":"摩柯迦罗","avatar":"http://i2.hdslb.com/bfs/face/7f2427246e01f2b30d0688ef2b9ff763513dcc00.jpg"},{"mid":122879,"pay_mid":4992241,"rank":19,"uname":"磁盘酱","avatar":"http://i0.hdslb.com/bfs/face/caaac5f5586d155b0b9b20113a6652aa77a0428f.jpg"},{"mid":122879,"pay_mid":7164057,"rank":20,"uname":"初音没未来","avatar":"http://i0.hdslb.com/bfs/face/72caf1c4bf5627331661793c2a47973159c93df4.jpg"},{"mid":122879,"pay_mid":14118759,"rank":21,"uname":"何厚烨","avatar":"http://i2.hdslb.com/bfs/face/09aa9e3a45ee7e7544a1ca7fb51d51b9e309c33e.jpg"},{"mid":122879,"pay_mid":3862596,"rank":22,"uname":"黑色疯狂勇者","avatar":"http://i0.hdslb.com/bfs/face/a6635708fd0663b4eb99ec79a3c76e5d5ff7af0f.jpg"},{"mid":122879,"pay_mid":3517173,"rank":23,"uname":"咕咚咕咚77","avatar":"http://i1.hdslb.com/bfs/face/d211ea5cded014b762d913c74a63b32d9ae60131.jpg"},{"mid":122879,"pay_mid":577009,"rank":24,"uname":"Mldr","avatar":"http://i2.hdslb.com/bfs/face/297c9f97a0d3d86ef2b59cacf6c38254d9720fb9.jpg"},{"mid":122879,"pay_mid":3207651,"rank":25,"uname":"残梦的黑八","avatar":"http://i2.hdslb.com/bfs/face/b229f2a31bbecf4283709b89ac1cc578e95d6d04.gif"},{"mid":122879,"pay_mid":2316849,"rank":26,"uname":"Robert_V","avatar":"http://i0.hdslb.com/bfs/face/333ad62035dcb0abb1ab86ee6cc13886ded2449b.jpg"},{"mid":122879,"pay_mid":1922885,"rank":27,"uname":"马森长颈鹿","avatar":"http://i2.hdslb.com/bfs/face/8e577003220614ec55c1153493d4ad3d2397b319.jpg"},{"mid":122879,"pay_mid":16457944,"rank":28,"uname":"ltyzlv587","avatar":"http://i1.hdslb.com/bfs/face/6250eb5df65d11fb0b897fddf4e1c0814d8f023b.jpg"},{"mid":122879,"pay_mid":7564738,"rank":29,"uname":"ZARDIS","avatar":"http://i1.hdslb.com/bfs/face/9beb2cea4a1d848e34388962c06f6946473dfbfa.jpg"},{"mid":122879,"pay_mid":187977,"rank":30,"uname":"EnzoK","avatar":"http://i0.hdslb.com/bfs/face/933b7d4c3f4b2d7da5ff4672fea83b9fa57cf0f3.jpg"},{"mid":122879,"pay_mid":2007154,"rank":31,"uname":"NagasawaTenzo","avatar":"http://i1.hdslb.com/bfs/face/69b84c8930f3bb2c26ecae9a1d89c492b9dd140c.jpg"}]
         */

        private ElecBean elec;
        private List<String> tags;
        /**
         * cid : 9769747
         * page : 1
         * from : vupload
         * link :
         * has_alias : 0
         * weblink :
         * part :
         * rich_vid :
         * vid : vupload_9769747
         */

        private List<PagesBean> pages;
        /**
         * aid : 6019199
         * pic : http://i0.hdslb.com/bfs/archive/f839102fd2486b9fdf6ea25916bac0b682ba0c85.png
         * title : 【午夜熊】太空站上的猎空干尸！
         * owner : {"mid":0,"name":"间月","face":""}
         * stat : {"view":14098,"danmaku":1033,"reply":238,"favorite":92,"coin":0,"share":0,"now_rank":0,"his_rank":0}
         */

        private List<RelatesBean> relates;

        public int getAid()
        {
            return aid;
        }

        public void setAid(int aid)
        {
            this.aid = aid;
        }

        public int getTid()
        {
            return tid;
        }

        public void setTid(int tid)
        {
            this.tid = tid;
        }

        public String getTname()
        {
            return tname;
        }

        public void setTname(String tname)
        {
            this.tname = tname;
        }

        public int getCopyright()
        {
            return copyright;
        }

        public void setCopyright(int copyright)
        {
            this.copyright = copyright;
        }

        public String getPic()
        {
            return pic;
        }

        public void setPic(String pic)
        {
            this.pic = pic;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public int getPubdate()
        {
            return pubdate;
        }

        public void setPubdate(int pubdate)
        {
            this.pubdate = pubdate;
        }

        public int getCtime()
        {
            return ctime;
        }

        public void setCtime(int ctime)
        {
            this.ctime = ctime;
        }

        public String getDesc()
        {
            return desc;
        }

        public void setDesc(String desc)
        {
            this.desc = desc;
        }

        public int getState()
        {
            return state;
        }

        public void setState(int state)
        {
            this.state = state;
        }

        public int getAttribute()
        {
            return attribute;
        }

        public void setAttribute(int attribute)
        {
            this.attribute = attribute;
        }

        public int getDuration()
        {
            return duration;
        }

        public void setDuration(int duration)
        {
            this.duration = duration;
        }

        public RightsBean getRights()
        {
            return rights;
        }

        public void setRights(RightsBean rights)
        {
            this.rights = rights;
        }

        public OwnerBean getOwner()
        {
            return owner;
        }

        public void setOwner(OwnerBean owner)
        {
            this.owner = owner;
        }

        public StatBean getStat()
        {
            return stat;
        }

        public void setStat(StatBean stat)
        {
            this.stat = stat;
        }

        public ReqUserBean getReq_user()
        {
            return req_user;
        }

        public void setReq_user(ReqUserBean req_user)
        {
            this.req_user = req_user;
        }

        public ElecBean getElec()
        {
            return elec;
        }

        public void setElec(ElecBean elec)
        {
            this.elec = elec;
        }

        public List<String> getTags()
        {
            return tags;
        }

        public void setTags(List<String> tags)
        {
            this.tags = tags;
        }

        public List<PagesBean> getPages()
        {
            return pages;
        }

        public void setPages(List<PagesBean> pages)
        {
            this.pages = pages;
        }

        public List<RelatesBean> getRelates()
        {
            return relates;
        }

        public void setRelates(List<RelatesBean> relates)
        {
            this.relates = relates;
        }

        public static class RightsBean
        {
            private int bp;
            private int elec;
            private int download;
            private int movie;
            private int pay;

            public int getBp()
            {
                return bp;
            }

            public void setBp(int bp)
            {
                this.bp = bp;
            }

            public int getElec()
            {
                return elec;
            }

            public void setElec(int elec)
            {
                this.elec = elec;
            }

            public int getDownload()
            {
                return download;
            }

            public void setDownload(int download)
            {
                this.download = download;
            }

            public int getMovie()
            {
                return movie;
            }

            public void setMovie(int movie)
            {
                this.movie = movie;
            }

            public int getPay()
            {
                return pay;
            }

            public void setPay(int pay)
            {
                this.pay = pay;
            }
        }

        public static class OwnerBean
        {
            private int mid;
            private String name;
            private String face;

            public int getMid()
            {
                return mid;
            }

            public void setMid(int mid)
            {
                this.mid = mid;
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
        }

        public static class StatBean
        {
            private int view;
            private int danmaku;
            private int reply;
            private int favorite;
            private int coin;
            private int share;
            private int now_rank;
            private int his_rank;

            public int getView()
            {
                return view;
            }

            public void setView(int view)
            {
                this.view = view;
            }

            public int getDanmaku()
            {
                return danmaku;
            }

            public void setDanmaku(int danmaku)
            {
                this.danmaku = danmaku;
            }

            public int getReply()
            {
                return reply;
            }

            public void setReply(int reply)
            {
                this.reply = reply;
            }

            public int getFavorite()
            {
                return favorite;
            }

            public void setFavorite(int favorite)
            {
                this.favorite = favorite;
            }

            public int getCoin()
            {
                return coin;
            }

            public void setCoin(int coin)
            {
                this.coin = coin;
            }

            public int getShare()
            {
                return share;
            }

            public void setShare(int share)
            {
                this.share = share;
            }

            public int getNow_rank()
            {
                return now_rank;
            }

            public void setNow_rank(int now_rank)
            {
                this.now_rank = now_rank;
            }

            public int getHis_rank()
            {
                return his_rank;
            }

            public void setHis_rank(int his_rank)
            {
                this.his_rank = his_rank;
            }
        }

        public static class ReqUserBean
        {
            private int attention;
            private int favorite;

            public int getAttention()
            {
                return attention;
            }

            public void setAttention(int attention)
            {
                this.attention = attention;
            }

            public int getFavorite()
            {
                return favorite;
            }

            public void setFavorite(int favorite)
            {
                this.favorite = favorite;
            }
        }

        public static class ElecBean
        {
            private boolean show;
            private int total;
            private int count;
            /**
             * mid : 122879
             * pay_mid : 11383186
             * rank : 1
             * uname : 入坑到底的死宅
             * avatar : http://i1.hdslb.com/bfs/face/4e9942b40e21b004db7e24733c871d0105a6bcad.jpg
             * message :
             * msg_deleted : 0
             */

            private List<ListBean> list;

            public boolean isShow()
            {
                return show;
            }

            public void setShow(boolean show)
            {
                this.show = show;
            }

            public int getTotal()
            {
                return total;
            }

            public void setTotal(int total)
            {
                this.total = total;
            }

            public int getCount()
            {
                return count;
            }

            public void setCount(int count)
            {
                this.count = count;
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
                private int mid;
                private int pay_mid;
                private int rank;
                private String uname;
                private String avatar;
                private String message;
                private int msg_deleted;

                public int getMid()
                {
                    return mid;
                }

                public void setMid(int mid)
                {
                    this.mid = mid;
                }

                public int getPay_mid()
                {
                    return pay_mid;
                }

                public void setPay_mid(int pay_mid)
                {
                    this.pay_mid = pay_mid;
                }

                public int getRank()
                {
                    return rank;
                }

                public void setRank(int rank)
                {
                    this.rank = rank;
                }

                public String getUname()
                {
                    return uname;
                }

                public void setUname(String uname)
                {
                    this.uname = uname;
                }

                public String getAvatar()
                {
                    return avatar;
                }

                public void setAvatar(String avatar)
                {
                    this.avatar = avatar;
                }

                public String getMessage()
                {
                    return message;
                }

                public void setMessage(String message)
                {
                    this.message = message;
                }

                public int getMsg_deleted()
                {
                    return msg_deleted;
                }

                public void setMsg_deleted(int msg_deleted)
                {
                    this.msg_deleted = msg_deleted;
                }
            }
        }

        public static class PagesBean
        {
            private int cid;
            private int page;
            private String from;
            private String link;
            private int has_alias;
            private String weblink;
            private String part;
            private String rich_vid;
            private String vid;

            public int getCid()
            {
                return cid;
            }

            public void setCid(int cid)
            {
                this.cid = cid;
            }

            public int getPage()
            {
                return page;
            }

            public void setPage(int page)
            {
                this.page = page;
            }

            public String getFrom()
            {
                return from;
            }

            public void setFrom(String from)
            {
                this.from = from;
            }

            public String getLink()
            {
                return link;
            }

            public void setLink(String link)
            {
                this.link = link;
            }

            public int getHas_alias()
            {
                return has_alias;
            }

            public void setHas_alias(int has_alias)
            {
                this.has_alias = has_alias;
            }

            public String getWeblink()
            {
                return weblink;
            }

            public void setWeblink(String weblink)
            {
                this.weblink = weblink;
            }

            public String getPart()
            {
                return part;
            }

            public void setPart(String part)
            {
                this.part = part;
            }

            public String getRich_vid()
            {
                return rich_vid;
            }

            public void setRich_vid(String rich_vid)
            {
                this.rich_vid = rich_vid;
            }

            public String getVid()
            {
                return vid;
            }

            public void setVid(String vid)
            {
                this.vid = vid;
            }
        }

        public static class RelatesBean
        {
            private int aid;
            private String pic;
            private String title;
            /**
             * mid : 0
             * name : 间月
             * face :
             */

            private OwnerBean owner;
            /**
             * view : 14098
             * danmaku : 1033
             * reply : 238
             * favorite : 92
             * coin : 0
             * share : 0
             * now_rank : 0
             * his_rank : 0
             */

            private StatBean stat;

            public int getAid()
            {
                return aid;
            }

            public void setAid(int aid)
            {
                this.aid = aid;
            }

            public String getPic()
            {
                return pic;
            }

            public void setPic(String pic)
            {
                this.pic = pic;
            }

            public String getTitle()
            {
                return title;
            }

            public void setTitle(String title)
            {
                this.title = title;
            }

            public OwnerBean getOwner()
            {
                return owner;
            }

            public void setOwner(OwnerBean owner)
            {
                this.owner = owner;
            }

            public StatBean getStat()
            {
                return stat;
            }

            public void setStat(StatBean stat)
            {
                this.stat = stat;
            }

            public static class OwnerBean
            {
                private int mid;
                private String name;
                private String face;

                public int getMid()
                {
                    return mid;
                }

                public void setMid(int mid)
                {
                    this.mid = mid;
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
            }

            public static class StatBean
            {
                private int view;
                private int danmaku;
                private int reply;
                private int favorite;
                private int coin;
                private int share;
                private int now_rank;
                private int his_rank;

                public int getView()
                {
                    return view;
                }

                public void setView(int view)
                {
                    this.view = view;
                }

                public int getDanmaku()
                {
                    return danmaku;
                }

                public void setDanmaku(int danmaku)
                {
                    this.danmaku = danmaku;
                }

                public int getReply()
                {
                    return reply;
                }

                public void setReply(int reply)
                {
                    this.reply = reply;
                }

                public int getFavorite()
                {
                    return favorite;
                }

                public void setFavorite(int favorite)
                {
                    this.favorite = favorite;
                }

                public int getCoin()
                {
                    return coin;
                }

                public void setCoin(int coin)
                {
                    this.coin = coin;
                }

                public int getShare()
                {
                    return share;
                }

                public void setShare(int share)
                {
                    this.share = share;
                }

                public int getNow_rank()
                {
                    return now_rank;
                }

                public void setNow_rank(int now_rank)
                {
                    this.now_rank = now_rank;
                }

                public int getHis_rank()
                {
                    return his_rank;
                }

                public void setHis_rank(int his_rank)
                {
                    this.his_rank = his_rank;
                }
            }
        }
    }
}
