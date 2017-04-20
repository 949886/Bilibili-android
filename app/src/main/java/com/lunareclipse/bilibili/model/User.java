package com.lunareclipse.bilibili.model;

import java.util.List;

/**
 * Created by YaeSakura on 16/8/15.
 */

public class User
{
    /**
     *
     * [API]
     * 通过用户名(user)获取：http://api.bilibili.cn/userinfo?user=月蝕LunarEclipse
     * 通过用ID(mid)获取：http://api.bilibili.cn/userinfo?mid=17281
     *
     * [字段]
     * mid : 17281
     * name : 月蝕LunarEclipse
     * approve : false
     * sex : 保密
     * rank : 10000
     * face : http://i1.hdslb.com/bfs/face/cd30bef7029b7fce27a357c01406927556f80557.jpg
     * coins : 845.3
     * DisplayRank : 10000
     * regtime : 1267285345
     * spacesta : 2
     * birthday : 1995-10-26
     * place :
     * description :
     * article : 1
     * fans : 4
     * friend : 61
     * attention : 61
     * sign : iOS, Android & Unity3D 开发者 / にほんご好き / 业余板绘 / 喜欢猫
     * level_info :
     * {
     *      "current_level":4,
     *      "current_min":4500,
     *      "current_exp":8773,
     *      "next_exp":10800
     * }
     * pendant :
     * {
     *      "pid":0,
     *      "name":"",
     *      "image":"",
     *      "expire":0
     *  }
     * nameplate :
     * {
     *      "nid":0,
     *      "name":"",
     *      "image":"",
     *      "image_small":"",
     *      "level":null,
     *      "condition":null
     * }
     * attentions : [374377,1534104,2642801,36012,183915,111559,580207,387984,736288]
     * code : 0
     */

    private int mid;
    private String name;
    private boolean approve;
    private String sex;
    private int rank;
    private String face;
    private double coins;
    private String DisplayRank;
    private int regtime;
    private int spacesta;
    private String birthday;
    private String place;
    private String description;
    private int article;
    private int fans;
    private int friend;
    private int attention;
    private String sign;
    private int code;

    private LevelInfoBean level_info;
    private PendantBean pendant;
    private NameplateBean nameplate;

    private List<Integer> attentions;


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

    public boolean isApprove()
    {
        return approve;
    }

    public void setApprove(boolean approve)
    {
        this.approve = approve;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public String getFace()
    {
        return face;
    }

    public void setFace(String face)
    {
        this.face = face;
    }

    public double getCoins()
    {
        return coins;
    }

    public void setCoins(double coins)
    {
        this.coins = coins;
    }

    public String getDisplayRank()
    {
        return DisplayRank;
    }

    public void setDisplayRank(String DisplayRank)
    {
        this.DisplayRank = DisplayRank;
    }

    public int getRegtime()
    {
        return regtime;
    }

    public void setRegtime(int regtime)
    {
        this.regtime = regtime;
    }

    public int getSpacesta()
    {
        return spacesta;
    }

    public void setSpacesta(int spacesta)
    {
        this.spacesta = spacesta;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getArticle()
    {
        return article;
    }

    public void setArticle(int article)
    {
        this.article = article;
    }

    public int getFans()
    {
        return fans;
    }

    public void setFans(int fans)
    {
        this.fans = fans;
    }

    public int getFriend()
    {
        return friend;
    }

    public void setFriend(int friend)
    {
        this.friend = friend;
    }

    public int getAttention()
    {
        return attention;
    }

    public void setAttention(int attention)
    {
        this.attention = attention;
    }

    public String getSign()
    {
        return sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }

    public LevelInfoBean getLevel_info()
    {
        return level_info;
    }

    public void setLevel_info(LevelInfoBean level_info)
    {
        this.level_info = level_info;
    }

    public PendantBean getPendant()
    {
        return pendant;
    }

    public void setPendant(PendantBean pendant)
    {
        this.pendant = pendant;
    }

    public NameplateBean getNameplate()
    {
        return nameplate;
    }

    public void setNameplate(NameplateBean nameplate)
    {
        this.nameplate = nameplate;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public List<Integer> getAttentions()
    {
        return attentions;
    }

    public void setAttentions(List<Integer> attentions)
    {
        this.attentions = attentions;
    }

    public static class LevelInfoBean
    {
        private int current_level;
        private int current_min;
        private int current_exp;
        private int next_exp;

        public int getCurrent_level()
        {
            return current_level;
        }

        public void setCurrent_level(int current_level)
        {
            this.current_level = current_level;
        }

        public int getCurrent_min()
        {
            return current_min;
        }

        public void setCurrent_min(int current_min)
        {
            this.current_min = current_min;
        }

        public int getCurrent_exp()
        {
            return current_exp;
        }

        public void setCurrent_exp(int current_exp)
        {
            this.current_exp = current_exp;
        }

        public int getNext_exp()
        {
            return next_exp;
        }

        public void setNext_exp(int next_exp)
        {
            this.next_exp = next_exp;
        }
    }

    public static class PendantBean
    {
        private int pid;
        private String name;
        private String image;
        private int expire;

        public int getPid()
        {
            return pid;
        }

        public void setPid(int pid)
        {
            this.pid = pid;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getImage()
        {
            return image;
        }

        public void setImage(String image)
        {
            this.image = image;
        }

        public int getExpire()
        {
            return expire;
        }

        public void setExpire(int expire)
        {
            this.expire = expire;
        }
    }

    public static class NameplateBean
    {
        private int nid;
        private String name;
        private String image;
        private String image_small;
        private Object level;
        private Object condition;

        public int getNid()
        {
            return nid;
        }

        public void setNid(int nid)
        {
            this.nid = nid;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getImage()
        {
            return image;
        }

        public void setImage(String image)
        {
            this.image = image;
        }

        public String getImage_small()
        {
            return image_small;
        }

        public void setImage_small(String image_small)
        {
            this.image_small = image_small;
        }

        public Object getLevel()
        {
            return level;
        }

        public void setLevel(Object level)
        {
            this.level = level;
        }

        public Object getCondition()
        {
            return condition;
        }

        public void setCondition(Object condition)
        {
            this.condition = condition;
        }
    }
}
