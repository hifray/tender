package com.woostar.tender.quartz.job;

import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.webmagic.pipeline.SGCCPipeline;
import com.woostar.tender.webmagic.processor.SGCCPageProcessor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Spider;

/**
 * @author huangs
 * @createtime 2018-06-26
 * @description
 */
public class SGCCJob extends BaseJob {

    @Autowired
    private SGCCPipeline sgccPipeline;

    /**
     * 定时任务执行方法
     * @param jobExecutionContext 定时任务内容
     * @throws JobExecutionException 执行异常
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("定时任务已启动("+ DateTimeUtil.dateToString(jobExecutionContext.getFireTime(), DateTimeUtil.DEFAULT_FORMAT) +")");
        try {
            Spider.create(new SGCCPageProcessor())
                    .addUrl(SGCCPageProcessor.LIST_URL + SGCCPageProcessor.LIST_URL_PARAMETERS)
                    .addPipeline(sgccPipeline)
                    .thread(5)
                    .setExitWhenComplete(true)
                    .run();
        } catch (Exception e) {
            LOGGER.error("定时任务执行异常" + e.getMessage(), e);
        }
        LOGGER.info("定时任务已结束。下次启动时间为("+ DateTimeUtil.dateToString(jobExecutionContext.getNextFireTime(), DateTimeUtil.DEFAULT_FORMAT) +")");
    }
}
