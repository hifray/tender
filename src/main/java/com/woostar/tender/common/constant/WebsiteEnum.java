package com.woostar.tender.common.constant;

/**
 * Enum WebsiteEnum 招标网站枚举类
 *
 * @author huangshuo
 * Created on 2018-07-26
 */
public enum WebsiteEnum {

    /**
     * Field BIDCHANCE 中国招标网
     */
    BIDCHANCE("http://www.bidchance.com/", "中国招标网", "1"),
    /**
     * Field CHINABIDDING 采购网与招标网
     */
    CHINABIDDING("https://www.chinabidding.cn/", "采购网与招标网", "2"),
    /**
     * Field SGCC 国家电网电子商务平台
     */
    SGCC("http://ecp.sgcc.com.cn/", "国家电网电子商务平台", "3"),
    /**
     * Field HBBIDCLOUD 湖北省公共资源交易中心
     */
    HBBIDCLOUD("http://www.hbbidcloud.com", "湖北省公共资源交易中心", "4"),
    /**
     * Field WHZBTB 武汉市公共资源交易中心
     */
    WHZBTB("http://www.jy.whzbtb.com", "武汉市公共资源交易中心", "5");

    /**
     * Field url 网址
     */
    private String url;
    /**
     * Field name 网站名称
     */
    private String name;
    /**
     * Field code 网站编号
     */
    private String code;

    /**
     * Constructor WebsiteEnum creates a new WebsiteEnum instance.
     *
     * @param url of type String 网址
     * @param name of type String 网站名称
     * @param code of type Integer 网站编号
     */
    WebsiteEnum(String url, String name, String code) {
        this.url = url;
        this.name = name;
        this.code = code;
    }

    /**
     * Method getUrl returns the url of this WebsiteEnum object.
     *
     *  Field url 网址
     *
     * @return the url (type String) of this WebsiteEnum object.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Method getName returns the name of this WebsiteEnum object.
     *
     *  Field name 网站名称
     *
     * @return the name (type String) of this WebsiteEnum object.
     */
    public String getName() {
        return name;
    }

    /**
     * Method getCode returns the code of this WebsiteEnum object.
     *
     *  Field code 网站编号
     *
     * @return the code (type String) of this WebsiteEnum object.
     */
    public String getCode() {
        return code;
    }
}