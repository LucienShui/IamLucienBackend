package ink.lucien.iamlucien.model;

import lombok.Data;

/**
 * 友链 Persistent Object
 */

@Data
public class FriendPO {

    public static class TYPE {

        // 全站链接
        public static String GLOBAL = "ten";

        // 内页链接
        public static String INNER = "one";

        // 推荐链接
        public static String RECOMMEND = "good";

        // 失效链接
        public static String INVALID = "others";
    }

    // 链接名称
    String name;

    // URL
    String url;

    // 链接类型
    String type;

    // favicon url
    String faviconUrl;

    // 链接描述
    String description;

    // 排序关键字
    Integer order;

    // 预留字段
    String detail;

    // TODO FriendPO(FriendDTO)
}
