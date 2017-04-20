package com.lunareclipse.bilibili.model;

import java.util.List;

/**
 * Created by YaeSakura on 16/8/26.
 */
public class LiveHome
{
    //[API]
    // http://live.bilibili.com/AppIndex/home?device=phone&platform=ios&scale=2

    private List<BannerBean> banner;
    private List<EntranceIconsBean> entranceIcons;
    private List<PartitionsBean> partitions;
    private PartitionsBean recommend_data;

    public List<BannerBean> getBanner()
    {
        return banner;
    }

    public void setBanner(List<BannerBean> banner)
    {
        this.banner = banner;
    }

    public List<EntranceIconsBean> getEntranceIcons()
    {
        return entranceIcons;
    }

    public void setEntranceIcons(List<EntranceIconsBean> entranceIcons)
    {
        this.entranceIcons = entranceIcons;
    }

    public List<PartitionsBean> getPartitions()
    {
        return partitions;
    }

    public void setPartitions(List<PartitionsBean> partitions)
    {
        this.partitions = partitions;
    }

    public PartitionsBean getRecommend_data()
    {
        return recommend_data;
    }

    public void setRecommend_data(PartitionsBean recommend_data)
    {
        this.recommend_data = recommend_data;
    }

    public static class BannerBean
    {
        private String title;
        private String img;
        private String remark;
        private String link;

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getImg()
        {
            return img;
        }

        public void setImg(String img)
        {
            this.img = img;
        }

        public String getRemark()
        {
            return remark;
        }

        public void setRemark(String remark)
        {
            this.remark = remark;
        }

        public String getLink()
        {
            return link;
        }

        public void setLink(String link)
        {
            this.link = link;
        }
    }

    public static class EntranceIconsBean
    {
        private int id;
        private String name;
        /**
         * src : http://static.hdslb.com/live-static/images/mobile/ios/phone/11_big_2x.png?2016082501
         * height : 100
         * width : 100
         */

        private ImageLink entrance_icon;

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public ImageLink getEntrance_icon()
        {
            return entrance_icon;
        }

        public void setEntrance_icon(ImageLink entrance_icon)
        {
            this.entrance_icon = entrance_icon;
        }
    }

    public static class PartitionsBean
    {
        /**
         * id : 9
         * name : 绘画专区
         * area : draw
         * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/ios/phone/9_s_2x.png?2016082501","height":"40","width":"40"}
         * count : 51
         */

        private PartitionBean partition;
        /**
         * owner : {"face":"http://i1.hdslb.com/bfs/face/fea9d678ac65aa0a1a9240d173f793257f5e9da5.jpg","mid":1348074,"name":"译水"}
         * cover : {"src":"http://i0.hdslb.com/bfs/live/a78e968ce917d865d6946b000f4d17389114ef79.jpg","height":180,"width":320}
         * title : 赶稿
         * room_id : 49064
         * check_version : 0
         * online : 30
         * area : 绘画专区
         * area_id : 9
         * playurl : http://live-play.acgvideo.com/live/205/live_1348074_332_c521e483.flv?wsSecret=d4a09650b1d3da9dfac132b048ee678a&wsTime=5797b282
         * accept_quality : 4
         * broadcast_type : 0
         * is_tv : 0
         */

        private List<Live> lives;

        /**
         * owner : {"face":"http://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","mid":11153765,"name":"哔哩哔哩音乐台"}
         * cover : {"src":"http://i0.hdslb.com/bfs/live/98c268f907705241a3e3face25ae365e3120406b.png","height":180,"width":320}
         * title : 【官方】哔哩哔哩官方音乐台
         * room_id : 23058
         * check_version : 0
         * online : 8641
         * area : 放映厅
         * area_id : 7
         * playurl : http://dl.live-play.acgvideo.com/live-dl/108815/live_11153765_9369560.flv?wsSecret=4e5de313c6e5321a63b05237978e8eca&wsTime=1472149543
         * accept_quality : 4
         * broadcast_type : 0
         * is_tv : 0
         */

        private List<Live> banner_data;

        public PartitionBean getPartition()
        {
            return partition;
        }

        public void setPartition(PartitionBean partition)
        {
            this.partition = partition;
        }

        public List<Live> getLives()
        {
            return lives;
        }

        public void setLives(List<Live> lives)
        {
            this.lives = lives;
        }

        public static class PartitionBean
        {
            private int id;
            private String name;
            private String area;

            /**
             * src : http://static.hdslb.com/live-static/images/mobile/ios/phone/9_s_2x.png?2016082501
             * height : 40
             * width : 40
             */

            private ImageLink sub_icon;
            private int count;

            public int getId()
            {
                return id;
            }

            public void setId(int id)
            {
                this.id = id;
            }

            public String getName()
            {
                return name;
            }

            public void setName(String name)
            {
                this.name = name;
            }

            public String getArea()
            {
                return area;
            }

            public void setArea(String area)
            {
                this.area = area;
            }

            public ImageLink getSub_icon()
            {
                return sub_icon;
            }

            public void setSub_icon(ImageLink sub_icon)
            {
                this.sub_icon = sub_icon;
            }

            public int getCount()
            {
                return count;
            }

            public void setCount(int count)
            {
                this.count = count;
            }
        }
    }
}
