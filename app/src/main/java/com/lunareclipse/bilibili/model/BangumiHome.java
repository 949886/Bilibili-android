package com.lunareclipse.bilibili.model;

import java.util.List;

/**
 * Created by YaeSakura on 16/8/26.
 */
public class BangumiHome
{

    /**
     * [API]
     * http://bangumi.bilibili.com/api/app_index_page_v3?device=phone
     *
     * list : ...
     * updateCount : 2
     */

    private LatestUpdateBean latestUpdate;
    /**
     * id : 0
     * img : http://i0.hdslb.com/bfs/bangumi/3c1d4f8e24d2c15134d2c8adbe211f912ef4a774.jpg
     * is_ad : 0
     * link : http://bangumi.bilibili.com/anime/3452
     * title : 三者三叶
     */

    private List<BannersBean> banners;
    /**
     * cover : http://i0.hdslb.com/bfs/bangumi/17bb1697f353bf26eb181891b4ec7859da8a4b6d.jpg
     * last_time : 1407151835
     * newest_ep_id : 53391
     * newest_ep_index : 49
     * season_id : 2325
     * title : 魔法骑士
     * total_count : 49
     * watchingCount : 0
     */

    private List<EndsBean> ends;

    public LatestUpdateBean getLatestUpdate()
    {
        return latestUpdate;
    }

    public void setLatestUpdate(LatestUpdateBean latestUpdate)
    {
        this.latestUpdate = latestUpdate;
    }

    public List<BannersBean> getBanners()
    {
        return banners;
    }

    public void setBanners(List<BannersBean> banners)
    {
        this.banners = banners;
    }

    public List<EndsBean> getEnds()
    {
        return ends;
    }

    public void setEnds(List<EndsBean> ends)
    {
        this.ends = ends;
    }

    public static class LatestUpdateBean
    {
        private String updateCount;
        /**
         * cover : http://i0.hdslb.com/bfs/archive/1b686bcd3a4e9a004abb99550bbdf40fc005a72b.jpg
         * last_time : 1472144710
         * newest_ep_id : 89129
         * newest_ep_index : 47
         * season_id : 2990
         * title : 恐怖！僵尸猫
         * total_count : 20
         * watchingCount : 0
         */

        private List<ListBean> list;

        public String getUpdateCount()
        {
            return updateCount;
        }

        public void setUpdateCount(String updateCount)
        {
            this.updateCount = updateCount;
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
            private String cover;
            private String last_time;
            private String newest_ep_id;
            private String newest_ep_index;
            private String season_id;
            private String title;
            private String total_count;
            private String watchingCount;

            public String getCover()
            {
                return cover;
            }

            public void setCover(String cover)
            {
                this.cover = cover;
            }

            public String getLast_time()
            {
                return last_time;
            }

            public void setLast_time(String last_time)
            {
                this.last_time = last_time;
            }

            public String getNewest_ep_id()
            {
                return newest_ep_id;
            }

            public void setNewest_ep_id(String newest_ep_id)
            {
                this.newest_ep_id = newest_ep_id;
            }

            public String getNewest_ep_index()
            {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index)
            {
                this.newest_ep_index = newest_ep_index;
            }

            public String getSeason_id()
            {
                return season_id;
            }

            public void setSeason_id(String season_id)
            {
                this.season_id = season_id;
            }

            public String getTitle()
            {
                return title;
            }

            public void setTitle(String title)
            {
                this.title = title;
            }

            public String getTotal_count()
            {
                return total_count;
            }

            public void setTotal_count(String total_count)
            {
                this.total_count = total_count;
            }

            public String getWatchingCount()
            {
                return watchingCount;
            }

            public void setWatchingCount(String watchingCount)
            {
                this.watchingCount = watchingCount;
            }
        }
    }

    public static class BannersBean
    {
        private int id;
        private String img;
        private int is_ad;
        private String link;
        private String title;

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getImg()
        {
            return img;
        }

        public void setImg(String img)
        {
            this.img = img;
        }

        public int getIs_ad()
        {
            return is_ad;
        }

        public void setIs_ad(int is_ad)
        {
            this.is_ad = is_ad;
        }

        public String getLink()
        {
            return link;
        }

        public void setLink(String link)
        {
            this.link = link;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }
    }

    public static class EndsBean
    {
        private String cover;
        private String last_time;
        private String newest_ep_id;
        private String newest_ep_index;
        private String season_id;
        private String title;
        private String total_count;
        private String watchingCount;

        public String getCover()
        {
            return cover;
        }

        public void setCover(String cover)
        {
            this.cover = cover;
        }

        public String getLast_time()
        {
            return last_time;
        }

        public void setLast_time(String last_time)
        {
            this.last_time = last_time;
        }

        public String getNewest_ep_id()
        {
            return newest_ep_id;
        }

        public void setNewest_ep_id(String newest_ep_id)
        {
            this.newest_ep_id = newest_ep_id;
        }

        public String getNewest_ep_index()
        {
            return newest_ep_index;
        }

        public void setNewest_ep_index(String newest_ep_index)
        {
            this.newest_ep_index = newest_ep_index;
        }

        public String getSeason_id()
        {
            return season_id;
        }

        public void setSeason_id(String season_id)
        {
            this.season_id = season_id;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getTotal_count()
        {
            return total_count;
        }

        public void setTotal_count(String total_count)
        {
            this.total_count = total_count;
        }

        public String getWatchingCount()
        {
            return watchingCount;
        }

        public void setWatchingCount(String watchingCount)
        {
            this.watchingCount = watchingCount;
        }
    }
}
