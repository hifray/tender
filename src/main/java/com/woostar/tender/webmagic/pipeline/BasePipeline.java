package com.woostar.tender.webmagic.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author huangs
 * @createtime 2018-06-04
 * @description pipeline基类
 */
@Component
public class BasePipeline implements Pipeline {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BasePipeline.class);

    @Override
    public void process(ResultItems resultItems, Task task) {
    }
}
