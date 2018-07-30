package com.woostar.tender.webmagic.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * @author hifra
 * @createtime 2018-07-30
 * @description
 */
public class BasePageProcessor implements PageProcessor {

    static final Logger LOGGER = LoggerFactory.getLogger(BasePageProcessor.class);

    public static final String FIELD_KEY = "projectDetail";

    /**
     * 网站相关配置
     */
    Site site = Site.me()
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

    String getContent(Selectable selectable, String regexString) {
        // 去掉文本内容中的 &nbsp;
        return selectable.replace("&nbsp;", "").replace("/n", "").regex(regexString).toString().trim();
    }
}
