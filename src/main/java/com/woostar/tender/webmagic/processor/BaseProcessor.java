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

    @Override
    public void process(Page page) {
    }

    @Override
    public Site getSite() {
        return null;
    }
}
