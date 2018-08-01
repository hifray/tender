package com.woostar.tender.webmagic.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;


/**
 * Class BasePageProcessor PageProcessor基类
 *
 * @author huangshuo
 * Created on 2018-07-30
 */
public class BasePageProcessor implements PageProcessor {

    /**
     * Field LOGGER 日志
     */
    static final Logger LOGGER = LoggerFactory.getLogger(BasePageProcessor.class);

    /**
     * Field FIELD_KEY page存储field的key
     */
    public static final String FIELD_KEY = "projectDetail";

    /**
     * Field site 目标网站
     */
    Site site = Site.me()
            .setCharset("UTF-8")
            .setSleepTime(3000)
            .setRetryTimes(5)
            .setTimeOut(10000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");

    /**
     * Method process 爬虫主方法
     *
     * @param page of type Page
     */
    @Override
    public void process(Page page) {

    }

    /**
     * Method getSite returns the site of this BasePageProcessor object.
     *
     *  Field site 目标网站
     *
     * @return the site (type Site) of this BasePageProcessor object.
     */
    @Override
    public Site getSite() {
        return null;
    }

    /**
     * Method getContent
     *
     * @param selectable of type Selectable
     * @param regexString of type String
     * @return String
     */
    String getContent(Selectable selectable, String regexString) {
        // 去掉文本内容中的&nbsp;
        return selectable.replace("&nbsp;", "").replace("/n", "").regex(regexString).toString().trim();
    }
}
