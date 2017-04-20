package com.lunareclipse.bilibili.api.support;

/**
 * Created by YaeSakura on 16/8/12.
 */
public class URLConstants
{

    /* API GET */

    public static final String BILIBILI_CAPTCHA = "https://passport.bilibili.com/captcha";

    public static final String BILIBILI_VIDEO_INFO = "http://app.bilibili.com/x/view";
    public static final String BILIBILI_VIDEO_COMMENTS = "http://api.bilibili.com/feedback";
    public static final String BILIBILI_VIDEO_BP = "http://www.bilibili.com/widget/ajaxGetBP";
    public static final String BILIBILI_VIDEO_PLAYURL = "http://interface.bilibili.com/playurl";     //签名算法未知，暂不可用
    public static final String BILIBILI_VIDEO_PLAYURL_M = "http://www.bilibili.com/m/html5";             //低清开放接口

    public static final String BILIBILI_BANGUMI_INFO = "http://bangumi.bilibili.com/api/season_v3";
    public static final String BILIBILI_BANGUMI_GET_BY_TAG = "http://bangumi.bilibili.com/api/get_season_by_tag_v2";

    public static final String BILIBILI_DANMAKU = "http://comment.bilibili.com/";

    public static final String BILIBILI_USER_INFO = "http://api.bilibili.cn/userinfo";
    public static final String BILIBILI_USER_ATTENTION_LIST = "http://space.bilibili.com/ajax/friend/GetAttentionList";
    public static final String BILIBILI_USER_FANS_LIST = "http://space.bilibili.com/ajax/friend/GetFansList";
    public static final String BILIBILI_USER_SUBSCRIBED_BANGUMI = "http://space.bilibili.com/ajax/bangumi/getlist";
    public static final String BILIBILI_USER_SUBSCRIBED_TAG = "http://space.bilibili.com/ajax/tags/getsublist";
    public static final String BILIBILI_USER_FAVORIATE_BOX_LIST = "http://space.bilibili.com/ajax/fav/getboxlist";
    public static final String BILIBILI_USER_SUBMITTED_VIDEO = "http://space.bilibili.com/ajax/member/getSubmitVideos";
    public static final String BILIBILI_USER_HISTORY = "http://api.bilibili.com/x/v2/history";

    public static final String BILIBILI_BANNER = "http://app.bilibili.com/x/banner/old";

    public static final String BILIBILI_LIVE_HOME = "http://live.bilibili.com/AppIndex/home";
    public static final String BILIBILI_RECOMMEND_HOME = "http://app.bilibili.com/x/v2/show";
    public static final String BILIBILI_BANGUMI_HOME = "http://bangumi.bilibili.com/api/app_index_page_v3";
    public static final String BILIBILI_BANGUMI_RECOMMEND = "http://bangumi.bilibili.com/api/bangumi_recommend";

    public static final String BILIBILI_IPAD_RECOMMEND_HOME = "https://app.bilibili.com/x/show";
    public static final String BILIBILI_IPAD_BANGUMI_HOME = "http://bangumi.bilibili.com/api/app_index_page";
    public static final String BILIBILI_IPAD_BANGUMI_TIMELINE = "http://bangumi.bilibili.com/jsonp/timeline_v2";
    public static final String BILIBILI_IPAD_BANGUMI_TAGS = "http://bangumi.bilibili.com/api/tags";
    public static final String BILIBILI_IPAD_BANGUMI_CONCERNED = "http://bangumi.bilibili.com/api/get_concerned_season";

    /* API POST */

    public static final String BILIBILI_ADD_REPLY = "http://api.bilibili.com/x/reply/add";
    public static final String BILIBILI_ADD_FAVOURIATE_VIDEO = "http://api.bilibili.com/x/favourite/video/add";

    public static final String BILIBILI_DELETE_FAVOURIATE_VIDEO = "http://api.bilibili.com/x/favourite/video/del";

    /* JJ */
    public static final String BILIBILIJJ_AV2CID = "http://www.bilibilijj.com/Api/AvToCid/";
}
