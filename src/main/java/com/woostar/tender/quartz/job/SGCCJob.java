package com.woostar.tender.quartz.job;

import com.woostar.tender.common.util.DateTimeUtil;
import com.woostar.tender.webmagic.pipeline.ProjectPipeline;
import com.woostar.tender.webmagic.processor.SGCCPageProcessor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Spider;

/**
 * Class SGCCJob
 *
 * @author huangshuo
 * Created on 2018-06-26
 */
public class SGCCJob extends BaseJob {

    /**
     * Field projectPipeline
     */
    @Autowired
    private ProjectPipeline projectPipeline;

    /**
     * Method executeInternal 定时任务主方法
     *
     * @param jobExecutionContext of type JobExecutionContext
     * @throws JobExecutionException when 定时任务异常
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("定时任务已启动("+ DateTimeUtil.dateToString(jobExecutionContext.getFireTime(), DateTimeUtil.DEFAULT_FORMAT) +")");
        try {
            Spider.create(new SGCCPageProcessor())
                    .addUrl(SGCCPageProcessor.LIST_URL + SGCCPageProcessor.LIST_URL_PARAMETERS)
                    .addPipeline(projectPipeline)
                    .thread(5)
                    .setExitWhenComplete(true)
                    .run();
        } catch (Exception e) {
            LOGGER.error("定时任务执行异常" + e.getMessage(), e);
        }
        LOGGER.info("定时任务已结束。下次启动时间为("+ DateTimeUtil.dateToString(jobExecutionContext.getNextFireTime(), DateTimeUtil.DEFAULT_FORMAT) +")");
    }
}
