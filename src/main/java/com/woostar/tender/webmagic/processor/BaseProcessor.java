package com.woostar.tender.webmagic.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author huangs
 * @createtime 2018-06-04
 * @description processor基类
 */
public class BaseProcessor implements PageProcessor {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ProjectPageProcessor.class);

    /**
     * 网站相关配置
     */
    protected Site site = Site.me()
            .setCharset("UTF-8")
            .setSleepTime(3000)
            .setRetryTimes(5)
            .setTimeOut(10000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");

    @Override
    public void process(Page page) {
    }

    @Override
    public Site getSite() {
        return null;
    }
}
