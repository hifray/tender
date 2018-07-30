package com.woostar.tender.common.constant;

/**
 * @author hifra
 * @createtime 2018-07-26
 * @description
 */
public enum Website {

    WHZBTB("http://www.jy.whzbtb.com", "武汉市公共资源交易平台"),
    BIDCHANCE("http://www.bidchance.com/", "招标网"),
    SGCC("http://ecp.sgcc.com.cn/", "国家电网电子商务平台"),
    CHINABIDDING("https://www.chinabidding.cn/", "采购网与招标网"),
    HBBIDCLOUD("http://www.hbbidcloud.com", "湖北省电子招标投标交易云平台");

    private String url;
    private String name;

    Website (String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
